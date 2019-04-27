package com.beidou.carsocket.web.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;
import javax.persistence.*;

@Table(name = "tb_fence")
public class Fence {
    @Id
    @Column(name = "fence_id")
    private Integer fenceId;

    @Column(name = "fence_name")
    private String fenceName;

    @Column(name = "fence_position")
    private String fencePosition;

    @Column(name = "fence_type")
    private Integer fenceType;

    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "create_time")
    private Date createTime;

    @Column(name = "createor_id")
    private Integer createorId;

    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "modify_time")
    private Date modifyTime;

    @Column(name = "modifier_id")
    private Integer modifierId;

    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "valid_time")
    private Date validTime;

    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "invalid_time")
    private Date invalidTime;

    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "begin_time")
    private Date beginTime;

    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "end_time")
    private Date endTime;

    /**
     * @return fence_id
     */
    public Integer getFenceId() {
        return fenceId;
    }

    /**
     * @param fenceId
     */
    public void setFenceId(Integer fenceId) {
        this.fenceId = fenceId;
    }

    /**
     * @return fence_name
     */
    public String getFenceName() {
        return fenceName;
    }

    /**
     * @param fenceName
     */
    public void setFenceName(String fenceName) {
        this.fenceName = fenceName;
    }

    /**
     * @return fence_position
     */
    public String getFencePosition() {
        return fencePosition;
    }

    /**
     * @param fencePosition
     */
    public void setFencePosition(String fencePosition) {
        this.fencePosition = fencePosition;
    }

    /**
     * @return fence_type
     */
    public Integer getFenceType() {
        return fenceType;
    }

    /**
     * @param fenceType
     */
    public void setFenceType(Integer fenceType) {
        this.fenceType = fenceType;
    }

    /**
     * @return create_time
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * @param createTime
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * @return createor_id
     */
    public Integer getCreateorId() {
        return createorId;
    }

    /**
     * @param createorId
     */
    public void setCreateorId(Integer createorId) {
        this.createorId = createorId;
    }

    /**
     * @return modify_time
     */
    public Date getModifyTime() {
        return modifyTime;
    }

    /**
     * @param modifyTime
     */
    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    /**
     * @return modifier_id
     */
    public Integer getModifierId() {
        return modifierId;
    }

    /**
     * @param modifierId
     */
    public void setModifierId(Integer modifierId) {
        this.modifierId = modifierId;
    }

    /**
     * @return valid_time
     */
    public Date getValidTime() {
        return validTime;
    }

    /**
     * @param validTime
     */
    public void setValidTime(Date validTime) {
        this.validTime = validTime;
    }

    /**
     * @return invalid_time
     */
    public Date getInvalidTime() {
        return invalidTime;
    }

    /**
     * @param invalidTime
     */
    public void setInvalidTime(Date invalidTime) {
        this.invalidTime = invalidTime;
    }

    /**
     * @return begin_time
     */
    public Date getBeginTime() {
        return beginTime;
    }

    /**
     * @param beginTime
     */
    public void setBeginTime(Date beginTime) {
        this.beginTime = beginTime;
    }

    /**
     * @return end_time
     */
    public Date getEndTime() {
        return endTime;
    }

    /**
     * @param endTime
     */
    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }
}