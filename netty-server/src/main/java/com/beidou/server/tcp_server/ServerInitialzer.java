package com.beidou.server.tcp_server;

import com.beidou.common.netty.codc.ServerDecoder;
import com.beidou.common.netty.codc.ServerEncoder;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;

public class ServerInitialzer extends ChannelInitializer<SocketChannel> {

	@Override
	protected void initChannel(SocketChannel ch) throws Exception {
		ChannelPipeline pipeline = ch.pipeline();
		
		// 自定义编码解码器
		pipeline.addLast(new ServerDecoder());
		pipeline.addLast(new ServerEncoder());

		// 自定义的handler
		pipeline.addLast(new ChatHandler());
	}

}
