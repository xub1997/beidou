package com.netty.client.tcp_client;

import com.beidou.common.netty.codc.ClientDecoder;
import com.beidou.common.netty.codc.ClientEncoder;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpServerCodec;
import io.netty.handler.codec.http.websocketx.WebSocketServerProtocolHandler;
import io.netty.handler.stream.ChunkedWriteHandler;
import io.netty.handler.timeout.IdleStateHandler;

public class ClientInitialzer extends ChannelInitializer<SocketChannel> {

	@Override
	protected void initChannel(SocketChannel ch) throws Exception {
		ChannelPipeline pipeline = ch.pipeline();
		//自定义编解码器
		pipeline.addLast(new ClientDecoder());
		pipeline.addLast(new ClientEncoder());


		//自定义处理器
		pipeline.addLast(new ChatHandler());
	}

}
