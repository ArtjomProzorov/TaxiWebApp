package com.sda.practical.service.Imp;

import com.sda.practical.dto.PassengerDto;
import com.sda.practical.dto.UserDto;
import com.sda.practical.exceptions.MobileAlreadyExistException;
import com.sda.practical.model.Passenger;
import com.sda.practical.repository.PassengerRepository;
import com.sda.practical.service.PassengerService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PassengerServiceImp implements PassengerService {

    private final PassengerRepository passengerRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public PassengerServiceImp(PassengerRepository passengerRepository, ModelMapper modelMapper) {
        this.passengerRepository = passengerRepository;
        this.modelMapper = modelMapper;
    }


    @Override
    public Passenger isBlocked(Long id) {
        Passenger passenger = passengerRepository.getOne(id);
        passenger.setActive(true);
        return passengerRepository.save(passenger);
    }

    @Override
    public Passenger Blocked(Long id) {
        Passenger passenger = passengerRepository.getOne(id);
        passenger.setActive(false);
        return passengerRepository.save(passenger);
    }

    @Override
    public Passenger savePassenger(PassengerDto passengerDto) throws MobileAlreadyExistException {
        Passenger passenger1 = passengerRepository.findByMobileNumber(passengerDto.getMobile());

        if(passenger1 == null){
            Passenger passenger = modelMapper.map(passengerDto, Passenger.class);
            return passengerRepository.save(passenger);

        }else throw new MobileAlreadyExistException();



    }


}
