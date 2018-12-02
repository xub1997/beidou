package business.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;


@Entity
public class Car {

    private Long card = null;

    private String name = null;

    private CarType cartype = CarType.SEDAN;

    private CarStatus status = CarStatus.OFFLINE;

    private Protocol protocol = Protocol.JT808;

    private Unit unit = null;

    private User user = null;

    private CarStopPos carStopPos;

    private Date joindate;

    private Date adddate;

    @Id
    @NotNull
    public Long getCard() {
        return card;
    }

    public void setCard(Long card) {
        this.card = card;
    }

    @NotNull
    @Size(min = 2,max = 30)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "car_type")
    public CarType getCartype() {
        return cartype;
    }

    public void setCartype(CarType cartype) {
        this.cartype = cartype;
    }

    public CarStatus getStatus() {
        return status;
    }

    public void setStatus(CarStatus status) {
        this.status = status;
    }

    public Protocol getProtocol() {
        return protocol;
    }

    public void setProtocol(Protocol protocol) {
        this.protocol = protocol;
    }

    @ManyToOne(targetEntity = User.class)
    @JoinColumn(name = "user_id",nullable = true)
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Car [idCard =" + this.card + ", name =" + this.name + ", user =" +
                this.user + ", unit =" +
                this.unit + "]";
    }

    @ManyToOne(targetEntity = Unit.class)
    @JoinColumn(name = "unit_id",nullable = true)
    public Unit getUnit(){ return this.unit; }

    public void setUnit(Unit unit) { this.unit = unit; }

    @OneToOne(targetEntity = CarStopPos.class,cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "car_stop_pos", nullable = true)
    public CarStopPos getCarStopPos() {
        return carStopPos;
    }

    public void setCarStopPos(CarStopPos carStopPos) {
        this.carStopPos = carStopPos;
    }

    public Date getJoindate() { return joindate; }

    public void setJoindate(Date joindate) { this.joindate = joindate; }

    public Date getAdddate() { return adddate; }

    public void setAdddate(Date adddate) { this.adddate = adddate; }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Car) {
            Car car = (Car) obj;
            return this.getCard().equals(car.getCard());
        }
        return super.equals(obj);
    }
}
