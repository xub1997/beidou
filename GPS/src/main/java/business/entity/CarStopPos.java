package business.entity;

import javax.persistence.*;

@Entity
public class CarStopPos {

    public CarStopPos(){

    }

    public CarStopPos(Car car){
        this.car = car;
    }

    private Long id;

    private Car car;

    private Position position;

    @Id
    @GeneratedValue
    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    @OneToOne(targetEntity = Car.class,cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    public Car getCar() { return car; }

    public void setCar(Car car) { this.car = car; }

    public Position getPosition() { return position; }

    public void setPosition(Position position) { this.position = position; }

    @Override
    public String toString() { return this.position.toString(); }

}
