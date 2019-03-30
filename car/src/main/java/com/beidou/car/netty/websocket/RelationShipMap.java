package com.beidou.car.netty.websocket;

import io.netty.channel.Channel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Description: 用户id和channel的关联关系处理
 */
public class RelationShipMap {
	private static Logger logger= LoggerFactory.getLogger(RelationShipMap.class);

	/*
	* 用户跟channel的全局关系
	* */
	private static Map<String, Channel> relation_manager = new ConcurrentHashMap<String, Channel>();//ConcurrentHashMap线程安全

	/*
	* 添加用户跟channel的绑定关系
	* */
	public static void add(String clientId, Channel channel) {
		relation_manager.put(clientId, channel);
	}

	/*
	 * 获取用户跟channel的绑定关系
	 * */
	public static Channel get(String clientId) {
		return relation_manager.get(clientId);
	}


	/*
	 * 移除用户跟channel的绑定关系
	 * */
	public static void remove(Channel channel){
		for (Map.Entry entry : relation_manager.entrySet()){
			if (entry.getValue()==channel){
				relation_manager.remove(entry.getKey());
			}
		}
	}

	/*
	 * 打印用户跟channel的绑定关系
	 * */
	public static void output() {
		for (HashMap.Entry<String, Channel> entry : relation_manager.entrySet()) {
			logger.error("UserId  :  {}   ，ChannelId  : {}",entry.getKey() ,entry.getValue().id().asLongText());
		}
	}
}
