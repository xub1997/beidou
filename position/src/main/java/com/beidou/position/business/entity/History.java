package com.beidou.position.business.entity;

import javax.persistence.*;

@Table(name = "test")
public class History {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "hisId")
    private Integer hisId;

    @Column(name = "carId")
    private Integer carId;

    @Column(name = "lng")
    private String lng;

    @Column(name = "lat")
    private String lat;

    @Column(name = "time")
    private String time;

    public Integer getHisId() {
        return hisId;
    }

    public void setHisId(Integer hisId) {
        this.hisId = hisId;
    }

    public Integer getCarId() {
        return carId;
    }

    public void setCarId(Integer carId) {
        this.carId = carId;
    }

    public String getLng() {
        return lng;
    }

    public void setLng(String lng) {
        this.lng = lng;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "History{" +
                "hisId=" + hisId +
                ", carId=" + carId +
                ", lng='" + lng + '\'' +
                ", lat='" + lat + '\'' +
                ", time='" + time + '\'' +
                '}';
    }
}
