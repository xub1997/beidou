package com.beidou.server.tcp_server;

import io.netty.channel.Channel;

public class Session {
    private String carId;
    private Channel channel;

    public String getCarId() {
        return carId;
    }

    public void setCarId(String carId) {
        this.carId = carId;
    }

    public Channel getChannel() {
        return channel;
    }

    public void setChannel(Channel channel) {
        this.channel = channel;
    }

    private Session() {
    }

    public static Session buildSession(String carId,Channel channel){
        Session session=new Session();
        session.setCarId(carId);
        session.setChannel(channel);
        return session;
    }

}
