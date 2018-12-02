package business.services;

import business.entity.ActualPos;
import business.entity.repositories.JdbcActualPositionDao;
import business.util.MyDateFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
@EnableScheduling
public class ActualPosServices {

    @Autowired
    private MyDateFormat dateFormat;

    @Autowired
    private JdbcActualPositionDao positionDao;

    @Scheduled(cron = "0 0 0 1/1 * ? ")
    public void ActualPosTable(){
        positionDao.createTableByName(dateFormat.myformat());
    }

    public void saveActualPos(String messege){
        ActualPos actualPos = new ActualPos();

        positionDao.insertActualPos(dateFormat.myformat(),actualPos);
    }

    private void toActualPos(String messege,ActualPos actualPos){

    }
}
