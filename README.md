# 这是一个基于SpringCloud的微服务平台

1、现有功能：

注册中心（register）、配置中心（config）、监控中心（monitor）、操作日志管理（logger）、网关（集成shiro、用户管理）

2、数据格式
/**
 * 

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


```Request request = new Request();
eg：
//发送数据
//组装位置数据
carPosition.setCarId("123");
carPosition.setLat("116.1245325");
carPosition.setLon("23.124366");
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
```



3、命令格式2

明文传输：tcp*设备ID$GNGGA......

```
Global Positioning System Fix Data（GGA）GPS定位信息

$GPGGA,<1>,<2>,<3>,<4>,<5>,<6>,<7>,<8>,<9>,M,<10>,M,<11>,<12>*hh<CR><LF>

<1> UTC时间，hhmmss（时分秒）格式 
<2> 纬度ddmm.mmmm（度分）格式（前面的0也将被传输） 
<3> 纬度半球N（北半球）或S（南半球） 
<4> 经度dddmm.mmmm（度分）格式（前面的0也将被传输） 
<5> 经度半球E（东经）或W（西经） 
<6> GPS状态：0=未定位，1=非差分定位，2=差分定位，6=正在估算 
<7> 正在使用解算位置的卫星数量（00~12）（前面的0也将被传输） 
<8> HDOP水平精度因子（0.5~99.9） 
<9> 海拔高度（-9999.9~99999.9） 
<10> 地球椭球面相对大地水准面的高度 
<11> 差分时间（从最近一次接收到差分信号开始的秒数，如果不是差分定位将为空） 
<12> 差分站ID号0000~1023（前面的0也将被传输，如果不是差分定位将为空）
```



```
tcp*1$GNGGA,023224.00,2306.068948,N,11328.388006,E,5,20,0.9,4.387,M,0.0,M,1.0,6F
```

