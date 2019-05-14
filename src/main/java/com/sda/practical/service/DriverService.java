package com.sda.practical.service;

import com.sda.practical.dto.DriverDto;
import com.sda.practical.exceptions.DriverLicenseAlreadyInUse;
import com.sda.practical.model.Driver;
import com.sda.practical.model.Passenger;

import java.util.Optional;

public interface DriverService {

    Driver isActive(Long id);  // DRIVER NEED TO BE CHANGED TO DTO !
    Driver deActive(Long id);

    Driver saveDriver(DriverDto driverDto) throws DriverLicenseAlreadyInUse;


}
