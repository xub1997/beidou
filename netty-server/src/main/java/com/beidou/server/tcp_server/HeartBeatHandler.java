package com.beidou.server.tcp_server;

import com.beidou.common.netty.enums.CmdCode;
import com.beidou.common.netty.enums.ModuleCode;
import com.beidou.common.netty.enums.StateCode;
import com.beidou.common.netty.model.Response;
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

					if (loss_connect_time > 5) {
						Channel channel=ctx.channel();
						Response response = new Response();
						//发送提示信息
						response.setModule((short) ModuleCode.SENDPOSITION.getCode());
						response.setCmd((short) CmdCode.SENDPOSITION.getCode());
						response.setStateCode(StateCode.FAIL.getCode());
						response.setData(CmdCode.LOGOUT.getMsg().getBytes());
						ctx.channel().writeAndFlush(response);
						// 关闭无用的channel，以防资源浪费
						SessionManager.getInstance().remove(channel.id().toString().replaceAll("-",""));
						channel.close();

					}
					break;
				default:
					break;
			}
		}
		
	}
	
}
