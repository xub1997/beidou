package com.beidou.position.websocket.server;


import org.apache.log4j.Logger;


import server.Server;


public class StartServer {
	private static Logger logger = Logger.getLogger(StartServer.class);
	
	public static void main(String[] args) throws InterruptedException {
		logger.info("开始启动~");
        try {
            Server.getServer("127.0.0.1",8888).start();
        } catch (Exception e) {
            e.printStackTrace();
        }
		
	}
}
