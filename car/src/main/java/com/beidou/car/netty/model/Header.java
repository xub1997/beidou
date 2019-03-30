package com.beidou.car.netty.model;

import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
* 消息头
*/
public abstract class Header {
    /**
     * 消息类型
     */
    public abstract Integer getType();

    /**
     * 消息头长度
     */
    public abstract Integer getHeaderLength();

    /**
     * 消息体长度
     */
    public abstract Integer getBodyLength();

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }
}
