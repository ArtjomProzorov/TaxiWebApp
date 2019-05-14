package com.sda.practical.order.OrderDto;

import com.sda.practical.order.domain.OrderStatus;
import java.util.Date;

public class OrderDto {

    private Long id;
    private Long orderID;
    private String description;
    private Date dateAndTime;
    private OrderStatus status;
    private Double fixedPrice;

    public OrderDto(Long orderID, String description, Date dateAndTime, OrderStatus status, Double fixedPrice) {
        this.orderID = orderID;
        this.description = description;
        this.dateAndTime = dateAndTime;
        this.status = status;
        this.fixedPrice = fixedPrice;
    }

    public OrderDto(){

    }

    public Long getOrderID() {
        return orderID;
    }

    public void setOrderID(Long orderID) {
        this.orderID = orderID;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDateAndTime() {
        return dateAndTime;
    }

    public void setDateAndTime(Date dateAndTime) {
        this.dateAndTime = dateAndTime;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public Double getFixedPrice() {
        return fixedPrice;
    }

    public void setFixedPrice(Double fixedPrice) {
        this.fixedPrice = fixedPrice;
    }
}
