package com.netty.client.tcp_client;

import com.beidou.common.netty.model.CarPosition;
import com.beidou.common.netty.model.Request;
import com.beidou.common.netty.model.Response;
import com.beidou.common.netty.model.StateCode;
import com.beidou.common.netty.utils.SerialUtil;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.util.concurrent.GlobalEventExecutor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * @Description: 处理消息的handler
 * TextWebSocketFrame： 在netty中，是用于为websocket专门处理文本的对象，frame是消息的载体
 */
public class ChatHandler extends SimpleChannelInboundHandler<Object> {

	private Logger logger= LoggerFactory.getLogger(this.getClass());


	// 用于记录和管理所有客户端的channle
	public static ChannelGroup clients =
			new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);


	/**
	 * 当客户端连接服务端之后（打开连接）
	 * 获取客户端的channle，并且放到ChannelGroup中去进行管理
	 */
	@Override
	public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
		clients.add(ctx.channel());
	}

	@Override
	public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
		// 当触发handlerRemoved，ChannelGroup会自动移除对应客户端的channel
		String channelId = ctx.channel().id().asLongText();
		logger.error("客户端被移除，channelId为：{}",channelId);

		clients.remove(ctx.channel());

	}

	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
		cause.printStackTrace();
		// 发生异常之后关闭连接（关闭channel），随后从ChannelGroup中移除
		ctx.channel().close();
		clients.remove(ctx.channel());

	}


	@Override
	protected void channelRead0(ChannelHandlerContext ctx, Object o) throws Exception {
		Response message = (Response)o;

		if(message.getModule() == 1){

			if(message.getCmd() == 1){

				CarPosition carPosition= (CarPosition) SerialUtil.decode(message.getData());

				System.out.println(carPosition.toString());



				/*Response response = new Response();
				response.setModule((short) 1);
				response.setCmd((short) 1);
				response.setStateCode(StateCode.SUCCESS);
				response.setData(SerialUtil.encodes(carPosition));
				ctx.channel().writeAndFlush(response);*/
			}else if(message.getCmd() == 2){

			}

		}else if (message.getModule() == 1){


		}
	}
}
