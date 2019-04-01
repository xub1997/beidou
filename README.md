# 这是一个基于SpringCloud的微服务平台

1、现有功能：

注册中心（register）、配置中心（config）、监控中心（monitor）、操作日志管理（logger）、网关（集成shiro、用户管理）

2、数据格式
/**
 * 
 * 发送数据---数据包格式
 * +——----——+——-----——+——----——+——----——+——-----——+
 * | 包头          | 模块号        | 命令号      |  长度        |   数据       |   
 * +——----——+——-----——+——----——+——----——+——-----——+
 * </pre>
 * 包头4字节
 * 模块号2字节short
 * 命令号2字节short
 * 长度4字节(描述数据部分字节长度)
 /**
 * 服务器编码器
 * <pre>
 * 返回数据--数据包格式
 * +——----——+——-----——+——----——+——----——+——-----——+——-----——+
 * | 包头          | 模块号        | 命令号       |  状态码    |  长度          |   数据       |  
 * +——----——+——-----——+——----——+——----——+——-----——+——-----——+
 * </pre>
 * 包头4字节
 * 模块号2字节short
 * 命令号2字节short
 * 长度4字节(描述数据部分字节长度)
 */
eg：
发送数据
组装位置数据
CarPosition carPosition=new CarPosition();
carPosition.setCarId("123");
carPosition.setLat("116.1245325");
carPosition.setLon("23.124366");

Request request = new Request();
request.setModule((short) 1);//模块号默认：1
request.setCmd((short) 1);//命令默认1
request.setData(SerialUtil.encodes(carPosition));//调用SerialUtil.encodes()
//发送请求
future.channel().writeAndFlush(request);//管道writeAndFlush
返回数据：
Response response = new Response();
response.setModule((short) 1);
response.setCmd((short) 1);
response.setStateCode(StateCode.SUCCESS);
response.setData(SerialUtil.encodes(carPosition));
ctx.channel().writeAndFlush(response);
