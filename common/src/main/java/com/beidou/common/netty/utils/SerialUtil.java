package com.beidou.common.netty.utils;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;

import java.io.*;

public class SerialUtil {

    public static byte[] encodes(Object obj)  {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(out);
            oos.writeObject(obj);
            oos.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                oos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        byte[] bytes = out.toByteArray();
        return bytes;
    }

    public static Object decode(byte[] bytes) {
        // 对象返序列化
        ByteArrayInputStream in = new ByteArrayInputStream(bytes);
        ObjectInputStream inn = null;
        Object obj=null;
        try {
            inn = new ObjectInputStream(in);
            obj = inn.readObject();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return obj;
    }

    /**
     * byte to buf
     *
     * @param bytes
     * @return
     */
    public static ByteBuf getBufFromByte(byte[] bytes) {
        ByteBuf buf = Unpooled.copiedBuffer(bytes);
        return buf;
    }

    /**
     * buf to byte
     *
     * @param buf
     * @return
     */
    public static byte[] getByteFromBuf(ByteBuf buf) {
        int size = buf.readableBytes();
        byte[] bytes = new byte[size];
        buf.readBytes(bytes);
        return bytes;
    }

}
