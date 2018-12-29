package com.beidou.car.entity;

public class Car {
    private Integer carid;

    private String carnum;

    private String cardescription;

    private Integer cartype;

    private String brand;

    private Integer seat;

    private Integer status;

    private String remark;

    private String createtime;

    private String updatetime;

    private Double bearweight;

    public Integer getCarid() {
        return carid;
    }

    public void setCarid(Integer carid) {
        this.carid = carid;
    }

    public String getCarnum() {
        return carnum;
    }

    public void setCarnum(String carnum) {
        this.carnum = carnum == null ? null : carnum.trim();
    }

    public String getCardescription() {
        return cardescription;
    }

    public void setCardescription(String cardescription) {
        this.cardescription = cardescription == null ? null : cardescription.trim();
    }

    public Integer getCartype() {
        return cartype;
    }

    public void setCartype(Integer cartype) {
        this.cartype = cartype;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand == null ? null : brand.trim();
    }

    public Integer getSeat() {
        return seat;
    }

    public void setSeat(Integer seat) {
        this.seat = seat;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime == null ? null : createtime.trim();
    }

    public String getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(String updatetime) {
        this.updatetime = updatetime == null ? null : updatetime.trim();
    }

    public Double getBearweight() {
        return bearweight;
    }

    public void setBearweight(Double bearweight) {
        this.bearweight = bearweight;
    }
}