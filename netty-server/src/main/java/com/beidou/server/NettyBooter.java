package com.beidou.server;



import com.beidou.server.config.NettyConfig;
import com.beidou.server.tcp_server.Server;
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
				Server.getInstance().start(nettyConfig.getPort());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
}
