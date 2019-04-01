package com.netty.client.tcp_client;

import com.beidou.common.netty.enums.CmdCode;
import com.beidou.common.netty.enums.ModuleCode;
import com.beidou.common.netty.model.CarPosition;
import com.beidou.common.netty.model.Request;
import com.beidou.common.netty.utils.SerialUtil;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


@Component
public class Client {

	private Logger logger= LoggerFactory.getLogger(this.getClass());


	private EventLoopGroup group;
	private Bootstrap client;


	private volatile static Client uniqueSingleton;

	private Client() {
		group = new NioEventLoopGroup();
		client = new Bootstrap();
		client.group(group)
				.channel(NioSocketChannel.class)
				.handler(new ClientInitialzer());
	}

	public static Client getInstance() {
		if (null == uniqueSingleton) {
			synchronized (Client.class) {
				if (null == uniqueSingleton) {
					uniqueSingleton = new Client();
				}
			}
		}
		return uniqueSingleton;
	}

	public void start(String host,int port) {
		try {
			ChannelFuture future = client.connect(host,port).sync();
			logger.info("netty tcp_client session 启动完毕...,开启端口：{}",port);
			CarPosition carPosition=new CarPosition();
			carPosition.setCarId("123");
			carPosition.setLat("116.1245325");
			carPosition.setLon("23.124366");

			Request request = new Request();
			request.setModule((short) ModuleCode.SENDPOSITION.getCode());
			request.setCmd((short) CmdCode.SENDPOSITION.getCode());
			request.setData(SerialUtil.encodes(carPosition));
			//发送请求
			future.channel().writeAndFlush(request);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	public void stop(){
		// 优雅退出，释放线程池资源
		group.shutdownGracefully();
		logger.info("netty tcp_client session 关闭~~~");
	}
	
}
