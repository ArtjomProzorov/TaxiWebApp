package com.sda.practical.dto;

import com.sda.practical.model.Driver;
import com.sda.practical.model.ItemStatus;
import com.sda.practical.model.Passenger;

import java.io.Serializable;

public class FoundItemDto implements Serializable {

    private Long id;
    private String description;
    private ItemStatus itemStatus;
    private Long driverID;


    public FoundItemDto(){

     }

    public Long getDriverID() {
        return driverID;
    }

    public void setDriverID(Long driverID) {
        this.driverID = driverID;
    }

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public String getDescription() { return description; }

    public void setDescription(String description) {
        this.description = description;
    }

    public ItemStatus getItemStatus() {
        return itemStatus;
    }

    public void setItemStatus(ItemStatus itemStatus) {
        this.itemStatus = itemStatus;
    }
}
