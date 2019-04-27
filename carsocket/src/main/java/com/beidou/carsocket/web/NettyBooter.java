package com.beidou.carsocket.web;


import com.beidou.carsocket.web.config.NettyConfig;
import com.beidou.carsocket.netty.websocket.WSServer;
import com.beidou.common.util.SpringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;


@Component
public class NettyBooter implements ApplicationListener<ContextRefreshedEvent> {

	@Autowired
	private NettyConfig nettyConfig;

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		if (event.getApplicationContext().getParent() == null) {
			try {
				WSServer.getInstance().start(nettyConfig.getPort());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	@Bean
	public SpringUtil getSpingUtil() {
		return new SpringUtil();
	}
	
}
