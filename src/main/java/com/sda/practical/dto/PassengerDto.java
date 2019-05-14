package com.sda.practical.dto;
import com.sun.org.apache.xpath.internal.operations.Bool;

import java.io.Serializable;
import java.util.Date;

public class PassengerDto implements Serializable {

    private Long id;
    private Date dateOfBirth;
    private String mobile;
    private String location;
    private Boolean isBlocked;


    public PassengerDto(Date dateOfBirth, String mobile, String location) {
        this.dateOfBirth = dateOfBirth;
        this.mobile = mobile;
        this.location = location;
        this.isBlocked = false;
    }


    public PassengerDto(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Boolean getBlocked() {
        return isBlocked;
    }

    public void setBlocked(Boolean blocked) {
        isBlocked = blocked;
    }

}
