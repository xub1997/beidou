package com.beidou.carsocket.web.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;
import javax.persistence.*;

@Table(name = "tb_fence_car")
public class FenceCar {
    /**
     * 围栏车辆编号
     */
    @Id
    private Integer id;

    /**
     * 围栏编号
     */
    @Column(name = "fence_id")
    private Integer fenceId;

    /**
     * 车辆编号
     */
    @Column(name = "car_id")
    private String carId;

    /**
     * 创建人编号
     */
    @Column(name = "creator_id")
    private Integer creatorId;

    /**
     * 是否删除（0 未删除   1 已删除）
     */
    @Column(name = "is_del")
    private Integer isDel;

    /**
     * 创建时间
     */
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 获取围栏车辆编号
     *
     * @return id - 围栏车辆编号
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置围栏车辆编号
     *
     * @param id 围栏车辆编号
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取围栏编号
     *
     * @return fence_id - 围栏编号
     */
    public Integer getFenceId() {
        return fenceId;
    }

    /**
     * 设置围栏编号
     *
     * @param fenceId 围栏编号
     */
    public void setFenceId(Integer fenceId) {
        this.fenceId = fenceId;
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
     * 获取创建人编号
     *
     * @return creator_id - 创建人编号
     */
    public Integer getCreatorId() {
        return creatorId;
    }

    /**
     * 设置创建人编号
     *
     * @param creatorId 创建人编号
     */
    public void setCreatorId(Integer creatorId) {
        this.creatorId = creatorId;
    }

    /**
     * 获取是否删除（0 未删除   1 已删除）
     *
     * @return is_del - 是否删除（0 未删除   1 已删除）
     */
    public Integer getIsDel() {
        return isDel;
    }

    /**
     * 设置是否删除（0 未删除   1 已删除）
     *
     * @param isDel 是否删除（0 未删除   1 已删除）
     */
    public void setIsDel(Integer isDel) {
        this.isDel = isDel;
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
}