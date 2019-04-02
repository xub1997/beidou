package com.beidou.server.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Table(name = "tb_car")
public class Car {
    /**
     * 车辆编号
     */
    @Id
    @Column(name = "car_id")
    private String carId;

    /**
     * 车辆别名
     */
    @Column(name = "car_name")
    private String carName;

    /**
     * 车辆类型编号
     */
    @Column(name = "car_type_id")
    private String carTypeId;

    /**
     * 车牌号
     */
    @Column(name = "car_num")
    private String carNum;

    /**
     * 用户编号（司机编号）
     */
    @Column(name = "user_id")
    private Integer userId;


    /**
     * 公司编号
     */
    @Column(name = "com_id")
    private Integer comId;

    /**
     * SIM编号
     */
    @Column(name = "sim_no")
    private String simNo;

    /**
     * 车辆状态（ 1 上线  2 离线）
     */
    @Column(name = "car_status")
    private Integer carStatus;

    /**
     * 车辆最后一次位置
     */
    @Column(name = "car_last_position")
    private String carLastPosition;

    /**
     * 车辆最后在线时间
     */
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "last_stop_time")
    private Date lastStopTime;

    /**
     * 车辆显示名称
     */
    @Column(name = "display_name")
    private String displayName;

    /**
     * 显示图标
     */
    @Column(name = "display_icon")
    private String displayIcon;

    /**
     * 创建时间
     */
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "create_time")
    private Date createTime;

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
     * 获取车辆别名
     *
     * @return car_name - 车辆别名
     */
    public String getCarName() {
        return carName;
    }

    /**
     * 设置车辆别名
     *
     * @param carName 车辆别名
     */
    public void setCarName(String carName) {
        this.carName = carName;
    }

    /**
     * 获取车辆类型编号
     *
     * @return car_type_id - 车辆类型编号
     */
    public String getCarTypeId() {
        return carTypeId;
    }

    /**
     * 设置车辆类型编号
     *
     * @param carTypeId 车辆类型编号
     */
    public void setCarTypeId(String carTypeId) {
        this.carTypeId = carTypeId;
    }

    /**
     * 获取车牌号
     *
     * @return car_num - 车牌号
     */
    public String getCarNum() {
        return carNum;
    }

    /**
     * 设置车牌号
     *
     * @param carNum 车牌号
     */
    public void setCarNum(String carNum) {
        this.carNum = carNum;
    }

    /**
     * 获取用户编号（司机编号）
     *
     * @return user_id - 用户编号（司机编号）
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * 设置用户编号（司机编号）
     *
     * @param userId 用户编号（司机编号）
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
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

    /**
     * 获取车辆状态（ 1 正常  2 故障   3 维修中）
     *
     * @return car_status - 车辆状态（ 1 正常  2 故障   3 维修中）
     */
    public Integer getCarStatus() {
        return carStatus;
    }

    /**
     * 设置车辆状态（ 1 正常  2 故障   3 维修中）
     *
     * @param carStatus 车辆状态（ 1 正常  2 故障   3 维修中）
     */
    public void setCarStatus(Integer carStatus) {
        this.carStatus = carStatus;
    }

    /**
     * 获取车辆最后一次位置
     *
     * @return car_last_position - 车辆最后一次位置
     */
    public String getCarLastPosition() {
        return carLastPosition;
    }

    /**
     * 设置车辆最后一次位置
     *
     * @param carLastPosition 车辆最后一次位置
     */
    public void setCarLastPosition(String carLastPosition) {
        this.carLastPosition = carLastPosition;
    }

    /**
     * 获取车辆最后在线时间
     *
     * @return last_stop_time - 车辆最后在线时间
     */
    public Date getLastStopTime() {
        return lastStopTime;
    }

    /**
     * 设置车辆最后在线时间
     *
     * @param lastStopTime 车辆最后在线时间
     */
    public void setLastStopTime(Date lastStopTime) {
        this.lastStopTime = lastStopTime;
    }

    /**
     * 获取车辆显示名称
     *
     * @return display_name - 车辆显示名称
     */
    public String getDisplayName() {
        return displayName;
    }

    /**
     * 设置车辆显示名称
     *
     * @param displayName 车辆显示名称
     */
    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    /**
     * 获取显示图标
     *
     * @return display_icon - 显示图标
     */
    public String getDisplayIcon() {
        return displayIcon;
    }

    /**
     * 设置显示图标
     *
     * @param displayIcon 显示图标
     */
    public void setDisplayIcon(String displayIcon) {
        this.displayIcon = displayIcon;
    }

    /**
     * 获取创建时间
     *
     * @return create_time - 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置创建时间
     *
     * @param createTime 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getComId() {
        return comId;
    }

    public void setComId(Integer comId) {
        this.comId = comId;
    }
}