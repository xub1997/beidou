package web.websocket;

import business.util.SessionUser;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.CopyOnWriteArraySet;
//该容器用来存储sessionUser和对应的sessionid，方便websocket对指定的用户发送消息
public class WebSocketSessionRegistry {
    private final ConcurrentMap<String,List<String>> carsMap = new ConcurrentHashMap<String,List<String>>();
    private final ConcurrentMap<SessionUser, Set<String>> userSessionIds = new ConcurrentHashMap<>();
    private final Object lock = new Object();

    public Set<String> getSessionId(SessionUser user){
        Assert.notNull(user.getName(),"User Name must not null");
        Set set = (Set)this.userSessionIds.get(user);
        return set != null ? set : Collections.emptySet();
    }

    public ConcurrentMap<SessionUser, Set<String>> getAllUserSessionIds(){
        return this.userSessionIds;
    }

    public void registerSessionId(SessionUser user, String sessionId){
        Assert.notNull(user,"User must not be null");
        Assert.notNull(sessionId, "Session ID must not be null");
        synchronized (this.lock){
            Object set = (Set)this.userSessionIds.get(user);
            if(set == null){
                set = new CopyOnWriteArraySet<>();
                this.userSessionIds.put(user, (Set<String>)set);
            }
            ((Set)set).add(sessionId);
        }
    }


    public void cancelSessionId(SessionUser user, String sessionId){
        Assert.notNull(user,"User must not be null");
        Assert.notNull(sessionId, "Session ID must not be null");
        synchronized (this.lock){
            Set set = (Set)this.userSessionIds.get(user);
            if(set != null && set.remove(sessionId) && set.isEmpty()){
                this.userSessionIds.remove(user);
            }
        }
    }

    public ConcurrentMap<String,List<String>> getCarMap(){
        return this.carsMap;
    }

    public void registerCarSessionId(String sessionId){
        carsMap.put(sessionId,new ArrayList<>());
    }

    public void registerCars(String sessionId,List<String> cars){
        carsMap.put(sessionId,cars);
    }

    public void cancelCarSessionId(String sessionId){
        carsMap.remove(sessionId);
    }
}
