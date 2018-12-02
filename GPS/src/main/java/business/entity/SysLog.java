package business.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
public class SysLog {

    private Long id;

    private Date date;

    private User user;

    private String operation;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public Date getDate() { return date; }

    public void setDate(Date date) { this.date = date; }

    @ManyToOne
    @JoinColumn(name = "user_id",nullable = true)
    public User getUser() { return user; }

    public void setUser(User user) { this.user = user; }

    public String getOperation() { return operation; }

    public void setOperation(String operation) { this.operation = operation; }

    @Override
    public String toString() {
        return this.operation;
    }

}
