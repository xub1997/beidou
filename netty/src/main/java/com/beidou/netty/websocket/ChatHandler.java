package com.beidou.netty.websocket;

import com.alibaba.fastjson.JSONObject;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import io.netty.util.concurrent.GlobalEventExecutor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @Description: 处理消息的handler
 * TextWebSocketFrame： 在netty中，是用于为websocket专门处理文本的对象，frame是消息的载体
 */
public class ChatHandler extends SimpleChannelInboundHandler<TextWebSocketFrame> {

	private Logger logger= LoggerFactory.getLogger(this.getClass());


	// 用于记录和管理所有客户端的channle
	public static ChannelGroup clients =
			new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);
	
	@Override
	protected void channelRead0(ChannelHandlerContext ctx, TextWebSocketFrame msg) 
			throws Exception {
		// 获取客户端传输过来的消息
		String content = msg.text();
		logger.error("时间： {}  ,客户端传来信息：{}",LocalDateTime.now(),content);
		Channel currentChannel = ctx.channel();
		

		/*DataContent dataContent = JSONObject.parseObject(content, DataContent.class);
		Integer action = dataContent.getAction();
		// 2. 判断消息类型，根据不同的类型来处理不同的业务

		if (action == MsgActionEnum.CONNECT.type) {
			// 	2.1  当websocket 第一次open的时候，初始化channel，把用的channel和userid关联起来
			String senderId = dataContent.getChatMsgVO().getSenderId();
			UserRelationShipMap.add(senderId, currentChannel);

			// 测试
			*//*for (Channel c : clients) {
				System.out.println(c.id().asLongText());
			}*//*
			UserRelationShipMap.output();
		} else if (action == MsgActionEnum.CHAT.type) {
			//  2.2  聊天类型的消息，把聊天记录保存到数据库，同时标记消息的签收状态[未签收]
			ChatMsgVO chatMsgVO = dataContent.getChatMsgVO();
			String msgText = chatMsgVO.getMsg();
			String receiverId = chatMsgVO.getReceiverId();
			String senderId = chatMsgVO.getSenderId();

			// 保存消息到数据库，并且标记为 未签收
			ChatMsgService chatMsgService = (ChatMsgService) SpringUtil.getBean("chatMsgService");
			String msgId = chatMsgService.saveMsg(chatMsgVO);
			chatMsgVO.setMsgId(msgId);

			DataContent dataContentMsg = new DataContent();
			dataContentMsg.setChatMsgVO(chatMsgVO);

			// 发送消息
			// 从全局用户Channel关系中获取接受方的channel
			Channel receiverChannel = UserRelationShipMap.get(receiverId);
			if (receiverChannel == null) {
				// TODO channel为空代表用户离线，推送消息（JPush，个推，小米推送）
				UserService userService = (UserService) SpringUtil.getBean("userService");
				User ssearch_result=userService.queryUserById(receiverId);
				PushConfig pushConfig = (PushConfig) SpringUtil.getBean("pushConfig");
				AppPush.pushToSingleWithNotificationTemplate(pushConfig,"未读消息",msgText,ssearch_result.getCid());
			} else {
				// 当receiverChannel不为空的时候，从ChannelGroup去查找对应的channel是否存在
				Channel findChannel = clients.find(receiverChannel.id());
				if (findChannel != null) {
					// 用户在线
					receiverChannel.writeAndFlush(
							new TextWebSocketFrame(
									JSONObject.toJSONString(dataContentMsg)));
				} else {
					// 用户离线 TODO 推送消息
				}
			}

		} else if (action == MsgActionEnum.SIGNED.type) {
			//  2.3  签收消息类型，针对具体的消息进行签收，修改数据库中对应消息的签收状态[已签收]
			ChatMsgService chatMsgService = (ChatMsgService) SpringUtil.getBean("chatMsgService");
			// 扩展字段在signed类型的消息中，代表需要去签收的消息id，逗号间隔
			String msgIdsStr = dataContent.getExtend();

			String msgIds[] = msgIdsStr.split(",");

			List<String> msgIdList = new ArrayList<>();
			for (String mid : msgIds) {
				if (!StringUtil.isEmpty(mid)) {
					msgIdList.add(mid);
					logger.error("签收id：{}",mid);
				}
			}
			if (msgIdList != null && !msgIdList.isEmpty() && msgIdList.size() > 0) {
				// 批量签收
				chatMsgService.updateMsgSigned(msgIdList);
			}

		} else if (action == MsgActionEnum.KEEPALIVE.type) {
			//  2.4  心跳类型的消息
			logger.error("收到来自channel为[ {} ]的心跳包...",currentChannel);
		}*/
		
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

	}

	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
		cause.printStackTrace();
		// 发生异常之后关闭连接（关闭channel），随后从ChannelGroup中移除
		ctx.channel().close();
		clients.remove(ctx.channel());

	}

	
	
}
