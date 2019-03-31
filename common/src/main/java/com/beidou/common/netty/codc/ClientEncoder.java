package com.beidou.common.netty.codc;

import com.beidou.common.netty.model.ConstantValue;
import com.beidou.common.netty.model.Request;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

public class ClientEncoder extends MessageToByteEncoder<Object>  {
    @Override
    protected void encode(ChannelHandlerContext channelHandlerContext, Object in, ByteBuf out) throws Exception {
        Request request = (Request)(in);

        //包头
        out.writeInt(ConstantValue.FLAG);
        //module
        out.writeShort(request.getModule());
        //cmd
        out.writeShort(request.getCmd());
        //长度
        out.writeInt(request.getDataLength());
        //data
        if(request.getData() != null){
            out.writeBytes(request.getData());
        }
    }
}
