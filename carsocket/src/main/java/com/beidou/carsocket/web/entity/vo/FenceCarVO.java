package com.beidou.carsocket.web.entity.vo;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class FenceCarVO {
    private Integer id;

    /**
     * 围栏编号
     */
    private Integer fenceId;

    /**
     * 车辆编号
     */
    private String carId;

    /**
     * 创建人编号
     */
    private Integer creatorId;

    /**
     * 是否删除（0 未删除   1 已删除）
     */
    private Integer isDel;

    /**
     * 创建时间
     */
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

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
}
