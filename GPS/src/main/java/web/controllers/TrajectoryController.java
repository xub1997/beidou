package web.controllers;

import business.entity.ActualPos;
import business.entity.repositories.JdbcActualPositionDao;
import business.util.MyDateFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping(path = "/car/trajectory")
public class TrajectoryController {

    @Resource(name = "GMT")
    private DateFormat dateFormat;

    @Autowired
    private MyDateFormat myDateFormat;

    @Autowired
    private JdbcActualPositionDao actualPositionDao;

    @RequestMapping
    public String dtatlist(){
        return "history";
    }

    @RequestMapping(path = "/get")
    public @ResponseBody positions[] heheda(@RequestBody trajectory text) throws ParseException {
        Date from = dateFormat.parse(text.from); Date to = dateFormat.parse(text.to);
        List<ActualPos> list = new ArrayList<>();
        Calendar from1 = Calendar.getInstance(); from1.setTime(from);
        Calendar to1 = Calendar.getInstance(); to1.setTime(to);
        if (myDateFormat.isSameDay(from1,to1)){
            list = actualPositionDao.findPosByCarAndDate(myDateFormat.thisfromat(from),Long.valueOf(text.card),from,to);
        }else {
            long betweenDays = myDateFormat.betweenDays(from,to);
            for (int i = 0; i < betweenDays; i++){
                list.addAll(actualPositionDao.findPosByCarAndDate(myDateFormat.thisfromat(from1.getTime()),Long.valueOf(text.card),from,to));
                from1.add(Calendar.DAY_OF_YEAR,1);
            }
        }
        positions[] position = new positions[list.size()];
        for (int i = 0; i < list.size(); i++){
            position[i] = new positions();
            position[i].lat = list.get(i).getPosition().getLat();
            position[i].lon = list.get(i).getPosition().getLon();
        }
        return position;
    }
}

class trajectory{
    public String card;
    public String from;
    public String to;

}

class positions{
    positions(){

    }

    public String lon ;
    public String lat ;
}

