package business.entity;

import javax.persistence.Embeddable;
import javax.validation.constraints.Size;
import java.util.Date;
@Embeddable
public class Position {

    public Position(){

    }
    public Position(String lon , String lat){
        this.lon = lon;
        this.lat = lat;
    }
    @Size(max = 30)
    private String lon;
    @Size(max = 30)
    private String lat;

    private Date utc;

    private Integer speed;

    private GpsStatus gpsStatus;

    private Integer sat_num;

    private Double dop;

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

    public Date getUtc() {
        return utc;
    }

    public void setUtc(Date utc) {
        this.utc = utc;
    }

    public Integer getSpeed() { return speed; }

    public void setSpeed(Integer speed) { this.speed = speed; }

    public GpsStatus getGpsStatus() {
        return gpsStatus;
    }

    public void setGpsStatus(GpsStatus gpsStatus) {
        this.gpsStatus = gpsStatus;
    }

    public Integer getSat_num() {
        return sat_num;
    }

    public void setSat_num(Integer sat_num) {
        this.sat_num = sat_num;
    }

    public Double getDop() {
        return dop;
    }

    public void setDop(Double dop) {
        this.dop = dop;
    }

    @Override
    public String toString() {
        return "Position [lon =" + this.lon + ", lat =" + this.lat + ", utc =" + this.utc
        + ", speed =" + this.speed + ", dop =" + this.dop + ", gpsStatus=" + this.gpsStatus
        + ", Satellite number=" + this.sat_num + "]";
    }
}
