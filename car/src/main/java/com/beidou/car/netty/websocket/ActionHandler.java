package com.beidou.car.netty.websocket;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.beidou.car.web.dao.CarMapper;
import com.beidou.car.web.entity.Car;
import com.beidou.car.web.entity.CarPosition;
import com.beidou.car.web.entity.vo.CarVO;
import com.beidou.car.web.service.CarPositionService;
import com.beidou.car.web.service.CarService;
import com.beidou.common.util.SpringUtil;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import io.netty.util.concurrent.GlobalEventExecutor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * 
 * @Description: 处理消息的handler
 * TextWebSocketFrame： 在netty中，是用于为websocket专门处理文本的对象，frame是消息的载体
 */
public class ActionHandler extends SimpleChannelInboundHandler<TextWebSocketFrame> {

	private Logger logger= LoggerFactory.getLogger(this.getClass());


	// 用于记录和管理所有客户端的channle
	public static ChannelGroup clients =
			new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);
	
	@Override
	protected void channelRead0(ChannelHandlerContext ctx, TextWebSocketFrame msg) 
			throws Exception, JSONException {
		// 获取客户端传输过来的消息
		String msgcontent = msg.text();
		logger.error("时间： {}  ,客户端传来信息：{}",LocalDateTime.now(),msgcontent);
		Channel currentChannel = ctx.channel();

		//返回对象
		DataContent returnDataContent=new DataContent();
		Content returnContent=new Content();
		String returnMsg="";

		// 1. 获取客户端发来的消息
		DataContent dataContent = JSONObject.parseObject(msgcontent, DataContent.class);
		int action = dataContent.getAction();
		// 2. 判断消息类型，根据不同的类型来处理不同的业务
		ActionEnum actionEnum= ActionEnum.fromType(action);
		switch (actionEnum){
			case CONNECT://第一次(或重连)初始化连接
			{
				logger.info("{}客户端连接",currentChannel.id());
				Content content=dataContent.getContent();
				//绑定车辆与消息管道
				RelationShipMap.add(content.getCarId(),currentChannel);
				returnMsg="客户端连接";
				//组装返回消息
				returnContent.setMsg(returnMsg);
				returnDataContent.setContent(returnContent);
				//返回前端信息
				currentChannel.writeAndFlush(
						new TextWebSocketFrame(
								JSONObject.toJSONString(returnDataContent)));
			};break;
			case DISCONNECT://断开连接
			{
				logger.info("{}客户端断开",currentChannel.id());
				Content content=dataContent.getContent();
				//绑定车辆与消息管道
				RelationShipMap.remove(content.getCarId());
				returnMsg="客户端断开";
				//组装返回消息
				returnContent.setMsg(returnMsg);
				returnDataContent.setContent(returnContent);
				//返回前端信息
				currentChannel.writeAndFlush(
						new TextWebSocketFrame(
								JSONObject.toJSONString(returnDataContent)));
			};break;
			case KEEPALIVE://客户端保持心跳
			{
				logger.info("客户端保持心跳");
				returnMsg="客户端保持心跳";
				//组装返回消息
				returnContent.setMsg(returnMsg);
				returnDataContent.setContent(returnContent);
				//返回前端信息
				currentChannel.writeAndFlush(
						new TextWebSocketFrame(
								JSONObject.toJSONString(returnDataContent)));
			};break;
			case GETCARLIST://获取车辆列表
			{
				logger.info("获取车辆列表");
				CarMapper carMapper = (CarMapper) SpringUtil.getBean("carMapper");
				Content content=dataContent.getContent();
				Map<String,Object> params=new HashMap<>();
				params.put("comId",content.getComId());
				//获取对应公司的车辆
				List<CarVO> carVOList= carMapper.listCar(params);
				returnMsg=JSONObject.toJSONString(carVOList);
				//组装返回消息
				returnContent.setMsg(returnMsg);
				returnDataContent.setContent(returnContent);
				//返回前端信息
				currentChannel.writeAndFlush(
						new TextWebSocketFrame(
								JSONObject.toJSONString(returnDataContent)));

			};break;
			case GETCARSTATE://获取车辆状态
			{
				logger.info("获取车辆状态");
				CarService carService = (CarService) SpringUtil.getBean("carService");
				Content content=dataContent.getContent();

				//获取对应的车辆信息
				Car car = carService.getCar(content.getCarId());
				returnMsg=JSONObject.toJSONString(car);
				//组装返回消息
				returnContent.setMsg(returnMsg);
				returnDataContent.setContent(returnContent);
				//返回前端信息
				currentChannel.writeAndFlush(
						new TextWebSocketFrame(
								JSONObject.toJSONString(returnDataContent)));

			};break;
			case GETLASTPOSITION://获取车辆的最新位置
			{
				logger.info("获取车辆的最新位置");
				CarPositionService carPositionService = (CarPositionService) SpringUtil.getBean("carPositionService");
				Content content=dataContent.getContent();

				//获取对应车辆的最新位置
				CarPosition carPosition= carPositionService.getLastCarPosition(content.getCarId());
				returnMsg=JSONObject.toJSONString(carPosition);
				//组装返回消息
				returnContent.setMsg(returnMsg);
				returnDataContent.setContent(returnContent);
				//返回前端信息
				currentChannel.writeAndFlush(
						new TextWebSocketFrame(
								JSONObject.toJSONString(returnDataContent)));
			};break;
			default:
			{
				logger.info("命令错误");
				returnMsg="命令错误";
			};break;
		}

	}

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
		RelationShipMap.remove(ctx.channel());
	}

	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
		cause.printStackTrace();
		// 发生异常之后关闭连接（关闭channel），随后从ChannelGroup中移除
		ctx.channel().close();
		clients.remove(ctx.channel());
		RelationShipMap.remove(ctx.channel());
	}

	
	
}
