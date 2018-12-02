package business.entity.warn;

import business.entity.Car;
import business.entity.User;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.*;

@Entity
public class Enclosure {

    private Long id;

    private String name;

    private Long speed;

    private Date valid;

    private Date invalid;

    private Date start;

    private Date stop;

    private Date adddate;

    private User user;

    private EnclosureType enclosuretype;

    private EnclosureWarnType enclosurewarntype;

    private String shape;

    private Set<Car> cars = new HashSet<>();

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Size(max = 30)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getSpeed() {
        return speed;
    }

    public void setSpeed(Long speed) {
        this.speed = speed;
    }

    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public Date getStop() {
        return stop;
    }

    public void setStop(Date stop) {
        this.stop = stop;
    }

    public Date getAdddate() {
        return adddate;
    }

    public void setAdddate(Date adddate) {
        this.adddate = adddate;
    }

    @ManyToOne(targetEntity = User.class)
    @JoinColumn(name = "user_id",nullable = false)
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public EnclosureType getEnclosuretype() {
        return enclosuretype;
    }

    public void setEnclosuretype(EnclosureType enclosuretype) {
        this.enclosuretype = enclosuretype;
    }

    public EnclosureWarnType getEnclosurewarntype() {
        return enclosurewarntype;
    }

    public void setEnclosurewarntype(EnclosureWarnType enclosurewarntype) {
        this.enclosurewarntype = enclosurewarntype;
    }

    public Date getValid() {
        return valid;
    }

    public void setValid(Date valid) {
        this.valid = valid;
    }

    public Date getInvalid() {
        return invalid;
    }

    public void setInvalid(Date invalid) {
        this.invalid = invalid;
    }


    public String getShape() {
        return shape;
    }

    public void setShape(String shape) {
        this.shape = shape;
    }

    @ManyToMany(targetEntity = business.entity.Car.class ,fetch = FetchType.EAGER)
    public Set<Car> getCars() {
        return cars;
    }

    public void setCars(Set<Car> cars) {
        this.cars = cars;
    }
}
