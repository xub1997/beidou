package com.beidou.server.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;
import javax.persistence.*;

@Table(name = "tb_car_position")
public class CarPosition {
    /**
     * 主键
     */
    @Id
    @Column(name = "car_pos_id")
    private Integer carPosId;

    /**
     * 车辆编号
     */
    @Column(name = "car_id")
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
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "receive_time")
    private Date receiveTime;

    /**
     * UTC时间
     */
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "utc_time")
    private Date utcTime;

    /**
     * SIM编号
     */
    @Column(name = "sim_no")
    private String simNo;

    /**
     * 获取主键
     *
     * @return car_pos_id - 主键
     */
    public Integer getCarPosId() {
        return carPosId;
    }

    /**
     * 设置主键
     *
     * @param carPosId 主键
     */
    public void setCarPosId(Integer carPosId) {
        this.carPosId = carPosId;
    }

    /**
     * 获取车辆编号
     *
     * @return car_id - 车辆编号
     */
    public String getCarId() {
        return carId;
    }

    /**
     * 设置车辆编号
     *
     * @param carId 车辆编号
     */
    public void setCarId(String carId) {
        this.carId = carId;
    }

    /**
     * 获取经度
     *
     * @return lon - 经度
     */
    public String getLon() {
        return lon;
    }

    /**
     * 设置经度
     *
     * @param lon 经度
     */
    public void setLon(String lon) {
        this.lon = lon;
    }

    /**
     * 获取纬度
     *
     * @return lat - 纬度
     */
    public String getLat() {
        return lat;
    }

    /**
     * 设置纬度
     *
     * @param lat 纬度
     */
    public void setLat(String lat) {
        this.lat = lat;
    }

    /**
     * 获取创建时间
     *
     * @return receive_time - 创建时间
     */
    public Date getReceiveTime() {
        return receiveTime;
    }

    /**
     * 设置创建时间
     *
     * @param receiveTime 创建时间
     */
    public void setReceiveTime(Date receiveTime) {
        this.receiveTime = receiveTime;
    }

    /**
     * 获取UTC时间
     *
     * @return utc_time - UTC时间
     */
    public Date getUtcTime() {
        return utcTime;
    }

    /**
     * 设置UTC时间
     *
     * @param utcTime UTC时间
     */
    public void setUtcTime(Date utcTime) {
        this.utcTime = utcTime;
    }

    /**
     * 获取SIM编号
     *
     * @return sim_no - SIM编号
     */
    public String getSimNo() {
        return simNo;
    }

    /**
     * 设置SIM编号
     *
     * @param simNo SIM编号
     */
    public void setSimNo(String simNo) {
        this.simNo = simNo;
    }
}