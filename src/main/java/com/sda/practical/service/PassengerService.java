package com.sda.practical.service;

import com.sda.practical.dto.PassengerDto;
import com.sda.practical.exceptions.MobileAlreadyExistException;
import com.sda.practical.model.Passenger;

import java.util.List;

public interface PassengerService {

    Passenger isBlocked(Long id);
    Passenger Blocked(Long id);

    Passenger savePassenger(PassengerDto passengerDto) throws MobileAlreadyExistException;


}
