package com.sda.practical.dto;

import com.sda.practical.model.Driver;
import com.sda.practical.model.ItemStatus;
import com.sda.practical.model.Passenger;

import java.io.Serializable;

public class LostItemDto implements Serializable {

    private Long id;
    private String description;
    private ItemStatus itemStatus;
    private Long passengerID;

    public LostItemDto(String description, ItemStatus itemStatus) {
        this.description = description;
        this.itemStatus = itemStatus;
    }

    public LostItemDto(){

    }

    public Long getPassengerID() {
        return passengerID;
    }

    public void setPassengerID(Long passengerID) {
        this.passengerID = passengerID;
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
