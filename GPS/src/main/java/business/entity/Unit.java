package business.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Unit {

    private Long id;

    private String name;

    private String contacts;

    private String province;

    private String city;

    private String phone;

    private Set<Car> cars = new HashSet<Car>();

    private Date joindate;

    private Date adddate;

    @GeneratedValue(strategy= GenerationType.AUTO)
    @Id
    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    @NotNull
    @Size(min = 2,max = 30)
    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public String getContacts() { return contacts; }

    public void setContacts(String contacts) { this.contacts = contacts; }

    @Size(max = 30)
    public String getProvince() { return province; }

    public void setProvince(String province) { this.province = province; }

    @Size(max = 30)
    public String getCity() { return city; }

    public void setCity(String city) { this.city = city; }

    @NotNull
    @Size(min = 2,max = 30)
    public String getPhone() { return phone; }

    public void setPhone(String phone) { this.phone = phone; }

    @OneToMany(targetEntity = business.entity.Car.class ,cascade = CascadeType.ALL,mappedBy = "unit")
    public Set<Car> getCars() { return cars; }

    public void setCars(Set<Car> cars) { this.cars = cars; }

    @Override
    public String toString() {
        return "Unit [name =" + this.name+ ", province =" + this.province + ", city =" +
                this.city + ", phone =" + this.phone+"]";
    }

    public Date getJoindate() { return joindate; }

    public void setJoindate(Date joindate) { this.joindate = joindate; }

    public Date getAdddate() { return adddate; }

    public void setAdddate(Date adddate) { this.adddate = adddate; }
}
