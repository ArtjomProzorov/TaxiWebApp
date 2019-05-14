package com.sda.practical.model;



import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.Set;

@Entity
@Table
public class Passenger {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    private Date dateOfBirth;

    @NotNull
    private String mobile;

    @NotNull
    private Boolean isActive;

    @NotNull
    private String location;

    @OneToOne(targetEntity = User.class, mappedBy = "passenger")
    private User user;

   @OneToMany(targetEntity = LostItem.class,mappedBy = "passenger")
   private Set<LostItem> lostItem;

//   @OneToMany(targetEntity = Order.class,mappedBy = "passenger")
//   private Set<Order> orders;


    public String getMobile() { return mobile; }

    public void setMobile(String mobile) { this.mobile = mobile; }

    public Boolean getActive() { return isActive; }

    public void setActive(Boolean active) { isActive = active; }

    public String getLocation() { return location; }

    public void setLocation(String location) { this.location = location; }

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public Date getDateOfBirth() { return dateOfBirth; }

    public void setDateOfBirth(Date dateOfBirth) { this.dateOfBirth = dateOfBirth; }


    public User getUser() { return user; }

    public void setUser(User user) { this.user = user;
    }
}



