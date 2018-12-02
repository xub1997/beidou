package web.websocket;

import business.util.SessionUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.simp.config.ChannelRegistration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.messaging.simp.stomp.StompCommand;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.messaging.support.ChannelInterceptorAdapter;
import org.springframework.messaging.support.MessageHeaderAccessor;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.socket.config.annotation.*;


@Configuration
@EnableWebSocket
@EnableWebSocketMessageBroker
@EnableScheduling
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

    @Autowired
    private WebSocketSessionRegistry sessionRegistry;

    @Override
    public void configureMessageBroker(MessageBrokerRegistry config) {
        config.enableSimpleBroker("/topic");//配置一个路径来过滤针对代理的消息
        config.setApplicationDestinationPrefixes("/app");//配置一个匹配当前application的前缀，当消息被执行的时候，该前缀会从destination移除。因此注解的匹配方法不需要加上该路径
        config.setUserDestinationPrefix("/user");//用来点对点的订阅前缀
    }

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/gps").withSockJS();
    }


    @Override
    public void configureClientInboundChannel(ChannelRegistration registration) {
        registration.interceptors(new ChannelInterceptorAdapter() {
            @Override
            public Message<?> preSend(Message<?> message, MessageChannel channel) {
                StompHeaderAccessor accessor =
                        MessageHeaderAccessor.getAccessor(message, StompHeaderAccessor.class);
                String sessionId = accessor.getSessionId();
                if(StompCommand.CONNECT.equals(accessor.getCommand())){
                    SessionUser user = new SessionUser(sessionId);
                    accessor.setUser(user);
                    sessionRegistry.registerSessionId(user,sessionId);
                    sessionRegistry.registerCarSessionId(sessionId);
                }
                if(!accessor.isMutable()){
                    sessionRegistry.cancelSessionId((SessionUser) accessor.getUser(),sessionId);
                    sessionRegistry.cancelCarSessionId(sessionId);
                }
                return super.preSend(message, channel);
            }
        });
    }

    @Override
    public void configureClientOutboundChannel(ChannelRegistration registration) {
        registration.interceptors(new ChannelInterceptorAdapter() {
            @Override
            public Message<?> preSend(Message<?> message, MessageChannel channel) {
                StompHeaderAccessor accessor =
                        MessageHeaderAccessor.getAccessor(message, StompHeaderAccessor.class);
                return super.preSend(message, channel);
            }
        });
    }



}