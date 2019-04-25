package com.beidou.gateway.entity;


public class CarType {
    /**
     * 车辆类型编号
     */
    private String carTypeId;

    /**
     * 类型名称
     */
    private String typeName;

    /**
     * 类型描述
     */
    private String typeDesc;

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
     * 获取类型名称
     *
     * @return type_name - 类型名称
     */
    public String getTypeName() {
        return typeName;
    }

    /**
     * 设置类型名称
     *
     * @param typeName 类型名称
     */
    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    /**
     * 获取类型描述
     *
     * @return type_desc - 类型描述
     */
    public String getTypeDesc() {
        return typeDesc;
    }

    /**
     * 设置类型描述
     *
     * @param typeDesc 类型描述
     */
    public void setTypeDesc(String typeDesc) {
        this.typeDesc = typeDesc;
    }
}