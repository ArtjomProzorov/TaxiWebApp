package com.sda.practical.service;

import com.sda.practical.dto.DriverDto;
import com.sda.practical.dto.PassengerDto;
import com.sda.practical.dto.UserDto;
import com.sda.practical.model.User;

import java.util.List;


public interface AdminService {

    List<DriverDto> getListOfDrivers();
    List<PassengerDto> getListOfPassengers();


}
