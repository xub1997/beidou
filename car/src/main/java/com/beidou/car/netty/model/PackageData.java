package com.beidou.car.netty.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

public class PackageData<T extends Header> {
    protected T header;

    public PackageData() {
    }

    public PackageData(T header) {
        this.header = header;
    }

    @JsonIgnore
    public T getHeader() {
        return header;
    }

    public void setHeader(T header) {
        this.header = header;
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }
}
