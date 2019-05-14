package com.sda.practical.service.Imp;

import com.sda.practical.dto.DriverDto;
import com.sda.practical.dto.PassengerDto;
import com.sda.practical.dto.UserDto;
import com.sda.practical.model.Passenger;
import com.sda.practical.model.User;
import com.sda.practical.repository.AdminRepository;
import com.sda.practical.service.AdminService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class AdminServiceImp implements AdminService {

    private final AdminRepository adminRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public AdminServiceImp(AdminRepository adminRepository, ModelMapper modelMapper) {
        this.adminRepository = adminRepository;
        this.modelMapper = modelMapper;
    }


    @Override
    public List<PassengerDto> getListOfPassengers() {
        return adminRepository.ListOfPassengers().stream().map
                (user -> modelMapper.map(user, PassengerDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<DriverDto> getListOfDrivers() {
        return adminRepository.ListOfDrivers().stream().map
                (user -> modelMapper.map(user, DriverDto.class)).
                collect(Collectors.toList());
    }




}
