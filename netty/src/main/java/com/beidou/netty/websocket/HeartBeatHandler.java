package com.beidou.netty.websocket;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.timeout.IdleStateEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Description: 用于检测channel的心跳handler 
 * 				 继承ChannelInboundHandlerAdapter，从而不需要实现channelRead0方法
 */
public class HeartBeatHandler extends ChannelInboundHandlerAdapter {
	private Logger logger= LoggerFactory.getLogger(this.getClass());

	private int loss_connect_time=0;

	@Override
	public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
		
		// 判断evt是否是IdleStateEvent（用于触发用户事件，包含 读空闲/写空闲/读写空闲 ）
		if (evt instanceof IdleStateEvent) {
			IdleStateEvent event = (IdleStateEvent)evt;		// 强制类型转换

			switch (event.state()){
				case READER_IDLE:
					logger.error("进入读空闲...");
					break;
				case WRITER_IDLE:
					logger.error("进入写空闲...");
					break;
				case ALL_IDLE:
					//loss_connect_time++;
					//logger.error("5 秒没有接收到客户端的信息了");
					if (loss_connect_time > 5) {
						Channel channel=ctx.channel();
						logger.error("channel关闭前，users的数量为：{},关闭channel为：{}",ChatHandler.clients.size(),channel.id());
						// 关闭无用的channel，以防资源浪费
						channel.close();
						logger.error("channel关闭后，users的数量为：{}",ChatHandler.clients.size() );
					}
					break;
				default:
					break;
			}
		}
		
	}
	
}
