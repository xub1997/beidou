package com.beidou.server.tcp_server;


import com.beidou.common.netty.enums.CmdCode;
import com.beidou.common.netty.enums.ModuleCode;
import com.beidou.common.netty.model.Request;
import com.beidou.common.netty.model.Response;
import com.beidou.common.netty.enums.StateCode;
import com.beidou.common.netty.utils.SerialUtil;
import com.beidou.common.netty.model.CarPosition;
import com.beidou.common.util.SpringUtil;
import com.beidou.server.service.CarPositionService;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.util.concurrent.GlobalEventExecutor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;

/**
 * 
 * @Description: 处理消息的handler
 * TextWebSocketFrame： 在netty中，是用于为websocket专门处理文本的对象，frame是消息的载体
 */
public class RequestHandler extends SimpleChannelInboundHandler<Object> {

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
		Response response = new Response();
		Request message = (Request)o;
		//获取模块名
		ModuleCode moduleCode=ModuleCode.getByCode(message.getModule());

		if(moduleCode.equals(ModuleCode.SENDPOSITION)){//上传位置模块
			//获取命令名
			CmdCode cmdCode=CmdCode.getByCode(message.getCmd());
			switch (cmdCode){
				case LOGIN:
				{
					response.setModule((short) ModuleCode.SENDPOSITION.getCode());
					response.setCmd((short) CmdCode.SENDPOSITION.getCode());
					response.setStateCode(StateCode.FAIL.getCode());
					response.setData(CmdCode.LOGIN.getMsg().getBytes());
					ctx.channel().writeAndFlush(response);
				};break;
				case SENDPOSITION:
				{
					//获取位置信息
					CarPosition carPosition= (CarPosition) SerialUtil.decode(message.getData());

					System.out.println(carPosition.toString());
					//保存位置信息
					CarPositionService carPositionService= (CarPositionService) SpringUtil.getBean("carPositionService");
					com.beidou.server.entity.CarPosition realCarPosition=new com.beidou.server.entity.CarPosition();
					realCarPosition.setCarId(carPosition.getCarId());
					realCarPosition.setLon(carPosition.getLon());
					realCarPosition.setLat(carPosition.getLat());
					realCarPosition.setReceiveTime(new Date());
					realCarPosition.setSimNo(carPosition.getSimNo());
					realCarPosition.setUtcTime(carPosition.getUtcTime());
					int flag=carPositionService.insertCarPosition(realCarPosition);

					//返回信息
					response.setModule((short) ModuleCode.SENDPOSITION.getCode());
					response.setCmd((short) CmdCode.SENDPOSITION.getCode());
					response.setStateCode(StateCode.getCodeByCode(flag));
					response.setData(StateCode.getMsgByCode(flag).getBytes());
					ctx.channel().writeAndFlush(response);
				};break;
				case KEEPALIVE:
				{
					response.setModule((short) ModuleCode.SENDPOSITION.getCode());
					response.setCmd((short) CmdCode.SENDPOSITION.getCode());
					response.setStateCode(StateCode.FAIL.getCode());
					response.setData(CmdCode.KEEPALIVE.getMsg().getBytes());
					ctx.channel().writeAndFlush(response);
				};break;
				case LOGOUT:
				{
					response.setModule((short) ModuleCode.SENDPOSITION.getCode());
					response.setCmd((short) CmdCode.SENDPOSITION.getCode());
					response.setStateCode(StateCode.FAIL.getCode());
					response.setData(CmdCode.LOGOUT.getMsg().getBytes());
					ctx.channel().writeAndFlush(response);
					clients.remove(ctx.channel());
				};break;
			}
		}else{
			response.setModule((short) ModuleCode.SENDPOSITION.getCode());
			response.setCmd((short) CmdCode.SENDPOSITION.getCode());
			response.setStateCode(StateCode.FAIL.getCode());
			response.setData(new String("模块名错误").getBytes());
			ctx.channel().writeAndFlush(response);
		}

	}
}
