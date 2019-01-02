package com.beidou.position.websocket.init;

import java.util.concurrent.TimeUnit;

import handler.WebSocketHandler;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpServerCodec;
import io.netty.handler.stream.ChunkedWriteHandler;
import io.netty.handler.timeout.IdleStateHandler;

public class ServerChannelInitializer extends ChannelInitializer<SocketChannel> {

	protected void initChannel(SocketChannel e) throws Exception {
		
		//入参说明: 读超时时间、写超时时间、所有类型的超时时间、时间格式
        e.pipeline().addLast(new IdleStateHandler(10, 0, 0, TimeUnit.SECONDS));

		// HttpServerCodec：将请求和应答消息解码为HTTP消息
		e.pipeline().addLast("http-codec", new HttpServerCodec());
		// HttpObjectAggregator：将HTTP消息的多个部分合成一条完整的HTTP消息,最大消息大小为512 * 1024（512KB）
		e.pipeline().addLast("aggregator", new HttpObjectAggregator(65536));
		// ChunkedWriteHandler：向客户端发送HTML5文件
		e.pipeline().addLast("http-chunked", new ChunkedWriteHandler());
		
		
		
		 //业务逻辑实现类
		// 第一个参数是名字，无具体要求，如果填写null，系统会自动命名。
		e.pipeline().addLast("handler", new WebSocketHandler());
		/**
		 * ChannelPipeline和ChannelHandler机制类似于Servlet和Filter过滤器{@link ChannelPipeline}
		 * Netty中的事件分为inbound事件和outbound事件。
		 * inbound事件通常由I/O线程触发，例如TCP链路建立事件、链路关闭事件、读事件、异常通知事件等。方法名以file开始{@link ChannelHandlerContext}
		 * outbound事件类似于发送、刷新、断开连接、绑定本地地址等关闭channel
		 */
	}
}
