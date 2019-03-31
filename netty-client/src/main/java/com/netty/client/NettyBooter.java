package com.netty.client;


import com.netty.client.config.NettyConfig;
import com.netty.client.tcp_client.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
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
				Client.getInstance().start(nettyConfig.getHost(),nettyConfig.getPort());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
}
