package com.sda.practical.model;

import com.sda.practical.order.domain.Order;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Entity
@Table
public class Driver {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    private String car;

    @NotNull
    private String license;

    @NotNull
    private String carModel;

    @NotNull
    private String carColor;

    @NotNull
    private Byte[] licencePic;

    @NotNull
    private Boolean isActive;

    @OneToOne(targetEntity = User.class, mappedBy = "driver")
    private User user;

    @OneToMany(targetEntity = FoundItem.class,mappedBy = "driver")
    private Set<FoundItem> foundItems;

//    @OneToMany(targetEntity = Order.class,mappedBy = "driver")
//    private Set<Order> orders;

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public String getCar() { return car; }

    public void setCar(String car) { this.car = car; }

    public String getLicense() { return license; }

    public void setLicense(String license) { this.license = license; }

    public String getCarModel() { return carModel; }

    public void setCarModel(String carModel) { this.carModel = carModel; }

    public String getCarColor() { return carColor; }

    public void setCarColor(String carColor) { this.carColor = carColor; }

    public Byte[] getLicencePic() {
        return licencePic;
    }

    public void setLicencePic(Byte[] licencePic) {
        this.licencePic = licencePic;
    }


    public Set<FoundItem> getFoundItems() {
        return foundItems;
    }

    public void setFoundItems(Set<FoundItem> foundItems) {
        this.foundItems = foundItems;
    }

    public User getUser() { return user; }

    public void setUser(User user) { this.user = user; }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }
}
