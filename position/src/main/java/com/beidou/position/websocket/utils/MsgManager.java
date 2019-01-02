package com.beidou.position.websocket.utils;


import com.beidou.common.util.StringUtil;
import com.beidou.position.websocket.entity.GlobalChannelMap;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;

import java.util.concurrent.locks.ReentrantReadWriteLock;

public class MsgManager {

	private static ReentrantReadWriteLock rwLock = new ReentrantReadWriteLock(true);

	/**
	 * 发送点对点消息
	 *
	 * @param message
	 */
	public static void sendP2PMessage(String senderId, String receiverId, String message) {

		/**
		 * A给B发消息，应该是B收到消息，并在B的对话框并输出消息
		 */
		if (!StringUtil.isEmpty(message)) {
			try {
				rwLock.readLock().lock();
				// 取出所有的channel,然后遍历，寻找sender对应的channel
				if (GlobalChannelMap.get(receiverId) != null) {
					String backMessage = senderId + "发来消息：" + message;
					GlobalChannelMap.get(receiverId).getChannel().writeAndFlush(new TextWebSocketFrame(backMessage));

				}

				/*
				 * for (String ch : keySet) { UserInfo userInfo = map.get(ch); //
				 * 当前通道不是接收者的话，重新遍历 if (!userInfo.getUserId().equals(receiverId) ) continue; //
				 * 当前通道是接收者的 String backMessage = senderId + "发来消息：" + message;
				 * System.out.println(backMessage); ch.writeAndFlush(new
				 * TextWebSocketFrame(backMessage)); hasReceiverId = true; break; } if
				 * (hasReceiverId == false) {
				 */
				if (GlobalChannelMap.get(receiverId) == null) {
					// 对方不在线

					String backMessage = receiverId + "不在线";
					System.out.println(backMessage);
					GlobalChannelMap.get(senderId).getChannel().writeAndFlush(new TextWebSocketFrame(backMessage));

				}
			} finally {
				rwLock.readLock().unlock();
			}
		}
	}
}
