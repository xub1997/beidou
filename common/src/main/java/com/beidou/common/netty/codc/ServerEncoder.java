package com.beidou.common.netty.codc;

import com.beidou.common.netty.model.ConstantValue;
import com.beidou.common.netty.model.Response;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

/**
 * 服务器编码器
 * <pre>
 * 数据包格式
 * +——----——+——-----——+——----——+——----——+——-----——+——-----——+
 * | 包头          | 模块号        | 命令号       |  状态码    |  长度          |   数据       |
 * +——----——+——-----——+——----——+——----——+——-----——+——-----——+
 * </pre>
 * 包头4字节
 * 模块号2字节short
 * 命令号2字节short
 * 长度4字节(描述数据部分字节长度)
 */
public class ServerEncoder extends MessageToByteEncoder<Object> {

    @Override
    protected void encode(ChannelHandlerContext channelHandlerContext, Object in, ByteBuf out) throws Exception {
        Response response = (Response)(in);
        //包头
        out.writeInt(ConstantValue.FLAG);
        //module
        out.writeShort(response.getModule());
        //cmd
        out.writeShort(response.getCmd());
        //状态码
        out.writeInt(response.getStateCode());
        //长度
        out.writeInt(response.getDataLength());
        //data
        if(response.getData() != null){
            out.writeBytes(response.getData());
        }
//        byte[] bytes = SerialUtil.encodes(in);
//        out.writeBytes(bytes);
    }
}
