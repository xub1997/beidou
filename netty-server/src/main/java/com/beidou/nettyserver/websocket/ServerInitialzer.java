package com.beidou.nettyserver.websocket;

import com.beidou.common.netty.codc.ServerDecoder;
import com.beidou.common.netty.codc.ServerEncoder;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpServerCodec;
import io.netty.handler.codec.http.websocketx.WebSocketServerProtocolHandler;
import io.netty.handler.stream.ChunkedWriteHandler;
import io.netty.handler.timeout.IdleStateHandler;

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
