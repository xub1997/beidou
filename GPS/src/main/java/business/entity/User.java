package business.entity;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;


@Entity
public class User {

    private Long id ;

    private String name = null;

    private String psw = null;

    private UserType userType = UserType.STANDARD;

    private Set<Car> cars = new HashSet<Car>();

    private Set<SysLog> operation = new HashSet<SysLog>();


    @NotNull
    @Size(min = 2,max = 30)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @NotNull
    @Size(min = 6,max = 30)
    public String getPsw() {
        return psw;
    }

    public void setPsw(String psw) {
        this.psw = psw;
    }

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "user_type")
    public UserType getUserType() {
        return userType;
    }

    public void setUserType(final UserType userType) {
        this.userType = userType;
    }

    @Override
    public String toString(){
        return "User [name =" + this.name + "]";
    }

    @OneToMany(targetEntity = Car.class ,cascade = CascadeType.ALL,mappedBy = "user")
    public Set<Car> getCars() {
        return cars;
    }

    public void setCars(Set<Car> cars) {
        this.cars = cars;
    }

    @OneToMany(targetEntity = business.entity.SysLog.class ,cascade = CascadeType.ALL,mappedBy = "user")
    public Set<SysLog> getOperation() {
        return operation;
    }

    public void setOperation(Set<SysLog> operation) {
        this.operation = operation;
    }
}
