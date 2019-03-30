package com.beidou.car.web.entity.vo;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class CarVO {
    /**
     * 车辆编号
     */
    private String carId;

    /**
     * 车辆别名
     */
    private String carName;

    /**
     * 车辆类型编号
     */
    private String carTypeId;


    /**
     * 车辆类型
     */
    private String typeDesc;

    /**
     * 车牌号
     */
    private Integer carNum;

    /**
     * 用户编号（司机编号）
     */
    private Integer userId;

    /**
     * 司机名称
     */
    private String driver;

    /**
     * SIM编号
     */
    private String simNo;

    /**
     * 车辆状态（ 1 正常  2 故障   3 维修中）
     */
    private Integer carStatus;

    /**
     * 车辆最后一次位置
     */
    private String carLastPosition;

    /**
     * 车辆最后在线时间
     */
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date lastStopTime;

    /**
     * 车辆显示名称
     */
    private String displayName;

    /**
     * 显示图标
     */
    private String displayIcon;

    /**
     * 创建时间
     */
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    public String getCarId() {
        return carId;
    }

    public void setCarId(String carId) {
        this.carId = carId;
    }

    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    public String getCarTypeId() {
        return carTypeId;
    }

    public void setCarTypeId(String carTypeId) {
        this.carTypeId = carTypeId;
    }

    public String getTypeDesc() {
        return typeDesc;
    }

    public void setTypeDesc(String typeDesc) {
        this.typeDesc = typeDesc;
    }

    public Integer getCarNum() {
        return carNum;
    }

    public void setCarNum(Integer carNum) {
        this.carNum = carNum;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public String getSimNo() {
        return simNo;
    }

    public void setSimNo(String simNo) {
        this.simNo = simNo;
    }

    public Integer getCarStatus() {
        return carStatus;
    }

    public void setCarStatus(Integer carStatus) {
        this.carStatus = carStatus;
    }

    public String getCarLastPosition() {
        return carLastPosition;
    }

    public void setCarLastPosition(String carLastPosition) {
        this.carLastPosition = carLastPosition;
    }

    public Date getLastStopTime() {
        return lastStopTime;
    }

    public void setLastStopTime(Date lastStopTime) {
        this.lastStopTime = lastStopTime;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayIcon() {
        return displayIcon;
    }

    public void setDisplayIcon(String displayIcon) {
        this.displayIcon = displayIcon;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
