package web.controllers;

import business.entity.CarStopPos;
import business.entity.Position;
import business.entity.repositories.CarStopPosRepositories;
import business.util.SessionUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import web.websocket.WebSocketSessionRegistry;

import java.util.*;

@Controller
public class WebSocketController {

    @Autowired
    private CarStopPosRepositories carStopPosRepositories;

    @Autowired
    private WebSocketSessionRegistry webSocketSessionRegistry;

    @Autowired
    private SimpMessagingTemplate template;

    @Autowired
    private CarStopPosRepositories repositories;


    @MessageMapping("cars")
    //@SendToUser(destinations = "/topic/position", broadcast = false)
    public void getCars(String cars, StompHeaderAccessor accessor){
        if (cars == null)return;
        webSocketSessionRegistry.registerCars(accessor.getSessionId(), Arrays.asList(cars.trim().split(",")));
    }

    @Scheduled(fixedRate = 1000)
    public void sendPosition(){
        List<CarStopPos> carStopPos = carStopPosRepositories.findAll();
        Map<String,Position> cars = new HashMap<>();
        for (CarStopPos temp : carStopPos){
            cars.put(temp.getCar().getCard().toString(),temp.getPosition());
        }
        for (SessionUser user: webSocketSessionRegistry.getAllUserSessionIds().keySet()){
            for (String sessionId : webSocketSessionRegistry.getSessionId(user)){
                List<String> list = new ArrayList<>();
                for (String car : webSocketSessionRegistry.getCarMap().get(sessionId)){
                    if (cars.get(car) != null) {
                        list.add(car);
                        list.add(cars.get(car).getLon());
                        list.add(cars.get(car).getLat());
                    }
                }
                String[] output = new String[list.size()];
                list.toArray(output);
                template.convertAndSendToUser(sessionId,"/topic/position",output);
            }
        }
    }

}
