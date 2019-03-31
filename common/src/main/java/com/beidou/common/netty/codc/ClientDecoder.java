package com.beidou.common.netty.codc;

import com.beidou.common.netty.model.ConstantValue;
import com.beidou.common.netty.model.Response;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;

import java.util.List;

public class ClientDecoder extends ByteToMessageDecoder {
    /**
     * 数据包基本长度
     */
    public static int BASE_LENTH = 4 + 2 + 2 + 4;

    @Override
    protected void decode(ChannelHandlerContext channelHandlerContext, ByteBuf in, List<Object> out) throws Exception {
        //可读长度必须大于基本长度
        if(in.readableBytes() >= BASE_LENTH){

            //记录包头开始的index
            int beginReader = in.readerIndex();

            while(true){
                if(in.readInt() == ConstantValue.FLAG){
                    break;
                }
            }

            //模块号
            short module = in.readShort();
            //命令号
            short cmd = in.readShort();
            //状态码
            int stateCode = in.readInt();
            //长度
            int length = in.readInt();

            if(in.readableBytes() < length){
                //还原读指针
                in.readerIndex(beginReader);
                out.add(null);
            }

            byte[] data = new byte[length];
            in.readBytes(data);

            Response response = new Response();
            response.setModule(module);
            response.setCmd(cmd);
            response.setStateCode(stateCode);
            response.setData(data);

            //继续往下传递
            out.add(response);

        }
    }
}
