package com.sda.practical.dto;

import com.sda.practical.model.User;

import java.io.Serializable;


public class DriverDto implements Serializable {


    private Long id;
    private String car;
    private String license;
    private String carModel;
    private String carColor;
    private Byte licencePic;
    private Boolean isActive;

    public DriverDto(String car, String license, String carModel, String carColor, Byte licencePic) {
        this.car = car;
        this.license = license;
        this.carModel = carModel;
        this.carColor = carColor;
        this.licencePic = licencePic;
        this.isActive = true;
    }

    public DriverDto() {
    }

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

    public Byte getLicencePic() { return licencePic; }

    public void setLicencePic(Byte licencePic) { this.licencePic = licencePic; }


    public Boolean getActive() { return isActive; }

    public void setActive(Boolean active) { isActive = active; }




}
