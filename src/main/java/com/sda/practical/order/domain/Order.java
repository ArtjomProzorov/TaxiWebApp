package com.sda.practical.order.domain;

import com.sda.practical.model.Driver;
import com.sda.practical.model.Passenger;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "CUSTOMER_ORDER")

@NoArgsConstructor(force=true,access = AccessLevel.PROTECTED) //singelton
//you cannot create object directly > // user will be forced to use the constructor
public class Order {

    @Id
    @GeneratedValue
    private Long id;

    private String description;

    private Date dateAndTime;

    @Enumerated
    private OrderStatus status;

    private Double fixedPrice;

//    @ManyToOne(targetEntity = Passenger.class)
//    @JoinColumn(name = "passenger_id")
//    private Passenger passenger;
//
//    @ManyToOne(targetEntity = Driver.class)
//    @JoinColumn(name = "driver_id")
//    private Driver Driver;

    private Double distanceInKM;

    private String startLocationLatitude;
    private String startLocationLongitude;

    private String endLocationLatitude;
    private String endLocationLongitude;




    public static Order of(String description, OrderStatus orderStatus){ /// of )create object order based on description and status

        Order order = new Order();
        order.description = description;
        order.status = orderStatus;
        return order;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }
}
