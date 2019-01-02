package com.beidou.position.business.service;

import com.beidou.position.business.dao.HistoryMapper;
import com.beidou.position.business.entity.History;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HistoryService {

    @Autowired
    HistoryMapper historyMapper;

    public List<History> getByCarId(int carId){
        History history=new History();
        history.setCarId(carId);
        return  historyMapper.select(history);
    }
}
