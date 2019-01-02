package com.beidou.position.websocket.server;

import java.net.InetSocketAddress;

import org.apache.log4j.Logger;

import init.ServerChannelInitializer;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;



public class Server {
	
	private static Logger logger = Logger.getLogger(Server.class);

    private int port;

    private String hostname="127.0.0.1";

    private volatile  static  Server server;

    private Server(int port) {
        this.port = port;
    }

    private Server(String hostname,int port){
        this.hostname=hostname;
        this.port=port;
    }

    //双重检验锁
    public static Server getServer(int port){
        logger.info("==============生成服务器实例==============");
        if(server==null){
            synchronized (Server.class){
                if(server==null){
                    server=new Server(port);
                }
            }
        }
        return server;
    }

    //双重检验锁
    public static Server getServer(String hostname,int port){
        logger.info("==============生成服务器实例==============");
        if(server==null){
            synchronized (Server.class){
                if(server==null){
                    server=new Server(hostname,port);
                }
            }
        }
        return server;
    }




	public void start() {
		logger.info("==============绑定ip地址:"+hostname+"==============");
        logger.info("==============绑定端口："+port+"==============");
		// Boss线程：由这个线程池提供的线程是boss种类的，用于创建、连接、绑定socket， （有点像门卫）然后把这些socket传给worker线程池。
		//NioEventLoopGroup 和NioEventLoop 都可以.但是前者使用的是线程池. 其实bossgroup如果服务端开启的是一个端口(大部分都是一个),单线程即可.
		// 在服务器端每个监听的socket都有一个boss线程来处理。在客户端，只有一个boss线程来处理所有的socket。
		EventLoopGroup bossGroup = new NioEventLoopGroup(1);
		// Worker线程：Worker线程执行所有的异步I/O，即处理操作
		EventLoopGroup workerGroup = new NioEventLoopGroup();
		try {
			// ServerBootstrap 启动NIO服务的辅助启动类,负责初始话netty服务器，并且开始监听端口的socket请求
			// 服务端启动辅助类，用于设置TCP相关参数  
			ServerBootstrap sbs = new ServerBootstrap()
					// 设置为主从线程模型 
					.group(bossGroup, workerGroup)
					// 设置服务端NIO通信类型  
					.channel(NioServerSocketChannel.class)
					//打印日志（日志级别为info）
					.handler(new LoggingHandler(LogLevel.INFO))
					//设置本地端口
					.localAddress(new InetSocketAddress(hostname,port))
					// ChildChannelHandler 对出入的数据进行的业务操作,其继承ChannelInitializer
					/*.childHandler(new HeartBeatServerFilter())*/
					.childHandler(new ServerChannelInitializer())
					// bootstrap 还可以设置TCP参数，根据需要可以分别设置主线程池和从线程池参数，来优化服务端性能。  
			        // 其中主线程池使用option方法来设置，从线程池使用childOption方法设置。  
			        // backlog表示主线程池中在套接口排队的最大数量，队列由未连接队列（三次握手未完成的）和已连接队列  
					.option(ChannelOption.SO_BACKLOG, 128)
					// 表示连接保活，相当于心跳机制，默认为7200s 
					.childOption(ChannelOption.SO_KEEPALIVE, true);
			
			// 绑定端口，启动select线程，轮询监听channel事件，监听到事件之后就会交给从线程池处理  
			ChannelFuture future = sbs.bind(port).sync();

			future.addListener(new ChannelFutureListener() {
                @Override
                public void operationComplete(ChannelFuture channelFuture) throws Exception {
                    if(!channelFuture.isSuccess()){
                        channelFuture.cause().printStackTrace();
                        channelFuture.channel().close();
                        logger.info("==============服务器绑定尝试失败!==============");
                    }else{
                        logger.info("==============服务器绑定成功!==============");
                    }
                }
            });
            logger.info("=============="+Server.class.getName()+" 开启成功并开始监听端口：" + future.channel().localAddress()+"==============");
			// 等待服务端口关闭 
			future.channel().closeFuture().sync();
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			// 优雅退出，释放线程池资源  
			bossGroup.shutdownGracefully();
			workerGroup.shutdownGracefully();
		}
	}


}
