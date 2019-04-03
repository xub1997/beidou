package com.beidou.server.tcp_server;


import com.beidou.common.netty.enums.CmdCode;
import com.beidou.common.netty.enums.ModuleCode;
import com.beidou.common.netty.model.Request;
import com.beidou.common.netty.model.Response;
import com.beidou.common.netty.enums.StateCode;
import com.beidou.common.netty.utils.SerialUtil;
import com.beidou.common.util.SpringUtil;
import com.beidou.server.CarStatus;
import com.beidou.server.entity.Car;
import com.beidou.server.entity.CarPosition;
import com.beidou.server.service.CarPositionService;
import com.beidou.server.service.CarService;
import io.netty.channel.Channel;
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
		String sessionId = ctx.channel().id().asLongText();
		logger.error("客户端被移除，sessionId为：{}",sessionId);
		Session session=SessionManager.getInstance().remove(sessionId);
		if(session!=null){
			//标志该车辆下线
			String carId=session.getCarId();
			Car car=new Car();
			car.setCarId(carId);
			car.setCarStatus(CarStatus.OFFLINE.getCode());
			//更新车辆最后位置信息
			CarPositionService carPositionService= (CarPositionService) SpringUtil.getBean("carPositionService");
			CarPosition carPosition=carPositionService.getLastPosition(carId);
			car.setCarLastPosition(carPosition.getLon()+","+carPosition.getLat());
			CarService carService= (CarService) SpringUtil.getBean("carService");
			int flag=carService.updateCar(car);
		}
		clients.remove(ctx.channel());
	}

	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
		cause.printStackTrace();
		String sessionId = ctx.channel().id().asLongText();
		// 发生异常之后关闭连接（关闭channel），随后从ChannelGroup中移除
		ctx.channel().close();
		logger.error("客户端发生错误，sessionId为：{}",sessionId);
		Session session=SessionManager.getInstance().remove(sessionId);
		if(session!=null){
			//标志该车辆下线
			String carId=session.getCarId();
			Car car=new Car();
			car.setCarId(carId);
			car.setCarStatus(CarStatus.OFFLINE.getCode());
			//更新车辆最后位置信息
			CarPositionService carPositionService= (CarPositionService) SpringUtil.getBean("carPositionService");
			CarPosition carPosition=carPositionService.getLastPosition(carId);
			car.setCarLastPosition(carPosition.getLon()+","+carPosition.getLat());
			CarService carService= (CarService) SpringUtil.getBean("carService");
			int flag=carService.updateCar(car);
		}
		clients.remove(ctx.channel());
	}


	@Override
	protected void channelRead0(ChannelHandlerContext ctx, Object o) throws Exception {
		Channel channel=ctx.channel();
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
					//记录channel跟Session
					com.beidou.common.netty.model.CarPosition carPosition= (com.beidou.common.netty.model.CarPosition)SerialUtil.decode(message.getData());
					String carId=carPosition.getCarId();
					SessionManager.getInstance().put(
							channel.id().asLongText(),
							carId,
							channel);
					//标记carId对应的车辆上线
					Car car=new Car();
					car.setCarId(carId);
					car.setCarStatus(CarStatus.ONLINE.getCode());
					CarService carService= (CarService) SpringUtil.getBean("carService");
					int flag=carService.updateCar(car);

					//返回信息
					response.setModule((short) ModuleCode.SENDPOSITION.getCode());
					response.setCmd((short) CmdCode.LOGIN.getCode());
					response.setStateCode(StateCode.getCodeByCode(flag));
					response.setData(CmdCode.LOGIN.getMsg().getBytes());
					channel.writeAndFlush(response);
				};break;
				case SENDPOSITION:
				{
					//获取位置信息
					com.beidou.common.netty.model.CarPosition carPosition= (com.beidou.common.netty.model.CarPosition) SerialUtil.decode(message.getData());

					System.out.println(carPosition.toString());
					//保存车辆位置信息
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
					channel.writeAndFlush(response);
				};break;
				case KEEPALIVE:
				{
					//返回心跳包
					response.setModule((short) ModuleCode.SENDPOSITION.getCode());
					response.setCmd((short) CmdCode.KEEPALIVE.getCode());
					response.setStateCode(StateCode.SUCCESS.getCode());
					response.setData(CmdCode.KEEPALIVE.getMsg().getBytes());
					ctx.channel().writeAndFlush(response);
				};break;
				case LOGOUT:
				{
					//移除session
					Session session=SessionManager.getInstance().remove(channel.id().asLongText());
					if(session!=null){
						//标志该车辆下线
						String carId=session.getCarId();
						Car car=new Car();
						car.setCarId(carId);
						car.setCarStatus(CarStatus.OFFLINE.getCode());
						//更新车辆最后位置信息
						CarPositionService carPositionService= (CarPositionService) SpringUtil.getBean("carPositionService");
						CarPosition carPosition=carPositionService.getLastPosition(carId);
						car.setCarLastPosition(carPosition.getLon()+","+carPosition.getLat());
						CarService carService= (CarService) SpringUtil.getBean("carService");
						int flag=carService.updateCar(car);

						//返回信息
						response.setModule((short) ModuleCode.SENDPOSITION.getCode());
						response.setCmd((short) CmdCode.LOGOUT.getCode());
						response.setStateCode(StateCode.getCodeByCode(flag));
						response.setData(CmdCode.LOGOUT.getMsg().getBytes());
						channel.writeAndFlush(response);
						clients.remove(ctx.channel());
					}
					//返回信息
					response.setModule((short) ModuleCode.SENDPOSITION.getCode());
					response.setCmd((short) CmdCode.LOGOUT.getCode());
					response.setStateCode(StateCode.FAIL.getCode());
					response.setData("未上线".getBytes());
					channel.writeAndFlush(response);
				};break;
			}
		}else{
			//提示错误
			response.setModule((short) ModuleCode.SENDPOSITION.getCode());
			response.setCmd((short) CmdCode.SENDPOSITION.getCode());
			response.setStateCode(StateCode.FAIL.getCode());
			response.setData(new String("模块名错误").getBytes());
			ctx.channel().writeAndFlush(response);
		}

	}
}
