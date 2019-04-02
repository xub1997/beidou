package com.beidou.server.tcp_server;

import io.netty.channel.Channel;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class SessionManager {
    private static volatile SessionManager instance = null;
    // netty生成的sessionID和Session的对应关系
    private Map<String, Session> sessionIdMap;


    private SessionManager() {
        this.sessionIdMap = new ConcurrentHashMap<>();
    }

    public static SessionManager getInstance() {
        if (instance == null) {
            synchronized (SessionManager.class) {
                if (instance == null) {
                    instance = new SessionManager();
                }
            }
        }
        return instance;
    }

    public Session put(String sessionId, String carId, Channel channel){
        Session session=Session.buildSession(carId,channel);
        return sessionIdMap.put(sessionId,session);
    }

    public Session put(String sessionId,Session session){
        return sessionIdMap.put(sessionId,session);
    }

    public Session findBySessionId(String sessionId){
        return sessionIdMap.get(sessionId);
    }

    public Session remove(String sessionId){
        if(sessionIdMap.containsKey(sessionId))
            return sessionIdMap.remove(sessionId);
        return null;
    }

}
