package com.beidou.common.netty.model;

import java.io.Serializable;
import java.util.Date;


public class CarPosition implements Serializable {

    private static final long serialVersionUID = -7033707301911915196L;
    /**
     * 主键
     */
    private Integer carPosId;

    /**
     * 车辆编号
     */
    private String carId;

    /**
     * 经度
     */
    private String lon;

    /**
     * 纬度
     */
    private String lat;

    /**
     * 创建时间
     */
    private Date receiveTime;

    /**
     * UTC时间
     */
    private Date utcTime;

    /**
     * SIM编号
     */
    private String simNo;


    public Integer getCarPosId() {
        return carPosId;
    }

    public void setCarPosId(Integer carPosId) {
        this.carPosId = carPosId;
    }

    public String getCarId() {
        return carId;
    }

    public void setCarId(String carId) {
        this.carId = carId;
    }

    public String getLon() {
        return lon;
    }

    public void setLon(String lon) {
        this.lon = lon;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public Date getReceiveTime() {
        return receiveTime;
    }

    public void setReceiveTime(Date receiveTime) {
        this.receiveTime = receiveTime;
    }

    public Date getUtcTime() {
        return utcTime;
    }

    public void setUtcTime(Date utcTime) {
        this.utcTime = utcTime;
    }

    public String getSimNo() {
        return simNo;
    }

    public void setSimNo(String simNo) {
        this.simNo = simNo;
    }

    @Override
    public String toString() {
        return "CarPosition{" +
                "carPosId=" + carPosId +
                ", carId='" + carId + '\'' +
                ", lon='" + lon + '\'' +
                ", lat='" + lat + '\'' +
                ", receiveTime=" + receiveTime +
                ", utcTime=" + utcTime +
                ", simNo='" + simNo + '\'' +
                '}';
    }
}