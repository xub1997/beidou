package com.beidou.position.websocket.entity;

import io.netty.channel.Channel;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.util.concurrent.GlobalEventExecutor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.InetSocketAddress;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class GlobalChannelMap {
	private static Logger logger = LoggerFactory.getLogger(GlobalChannelMap.class);
	
	//存储每一个客户端接入进来时的channel对象(全局)
	public static ChannelGroup group = new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);
	
	private static UserInfo userInfo=null;

	public static ConcurrentMap<String, UserInfo> map = new ConcurrentHashMap<>();
	
	public static String parseChannelRemoteAddr(Channel channel) {
        InetSocketAddress insocket = (InetSocketAddress) channel.remoteAddress();
        return insocket.getAddress().getHostAddress();
    }

	public static void add(String clientId, Channel channel) {
		String remoteAddr = GlobalChannelMap.parseChannelRemoteAddr(channel);
		userInfo = new UserInfo();
        userInfo.setUserId(clientId);
        userInfo.setAddress(remoteAddr);
        userInfo.setChannel(channel);
        map.put(clientId, userInfo);
        if(!group.contains(channel)) {
        	group.add(channel);
        }
        logger.info("连接个数："+map.size());
        logger.info(map.toString());
        logger.info(group.toString());
	}

	public static UserInfo get(String clientId) {
		return map.get(clientId);
	}

	@SuppressWarnings("rawtypes")
	public static void remove(Channel channel) {
		for (Map.Entry entry : map.entrySet()) {
			if (entry.getValue() == channel) {
				map.remove(entry.getKey());
				if(group.contains(channel)) {
		        	group.remove(channel);
		        }
			}
		}
	}

	
}
