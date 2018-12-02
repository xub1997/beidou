package business.entity;

import java.util.Date;


public class ActualPos {

    private Long id;

    private Long car_id;

    private Position position;

    private Date local_time;

    private Integer warn_status;

    private String warn_message;

    public ActualPos() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCar_id() { return car_id; }

    public void setCar_id(Long car_id) { this.car_id = car_id; }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Date getLocal_time() {
        return local_time;
    }

    public void setLocal_time(Date local_time) {
        this.local_time = local_time;
    }


    public Integer getWarn_status() {
        return warn_status;
    }

    public void setWarn_status(Integer warn_status) {
        this.warn_status = warn_status;
    }

    public String getWarn_message() {
        return warn_message;
    }

    public void setWarn_message(String warn_message) {
        this.warn_message = warn_message;
    }
}
