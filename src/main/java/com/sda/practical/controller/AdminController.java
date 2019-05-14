package com.sda.practical.controller;

import com.sda.practical.dto.*;
import com.sda.practical.model.User;
import com.sda.practical.service.AdminService;
import com.sda.practical.service.FoundService;
import com.sda.practical.service.LostService;
import com.sda.practical.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/admin")
@PreAuthorize("hasRole('ROLE_ADMIN')")
public class AdminController {


    final private UserService userService;
    final private AdminService adminService;
    final private ModelMapper modelMapper;
    final private LostService lostService;
    final private FoundService foundService;

    @Autowired
    public AdminController(UserService userService, AdminService adminService, ModelMapper modelMapper, LostService lostService, FoundService foundService) {
        this.userService = userService;
        this.adminService = adminService;
        this.modelMapper = modelMapper;
        this.lostService = lostService;
        this.foundService = foundService;
    }


    @RequestMapping(value ="/list/drivers",  method = RequestMethod.GET)
    public List<DriverDto> getDriverList() {
        return  adminService.getListOfDrivers();
    }

    @RequestMapping(value = "/list/passenger", method = RequestMethod.GET)
    public List<PassengerDto> listOfPassengers() {
        return adminService.getListOfPassengers();
    }


    @RequestMapping(value ="/list-lostitems", method = RequestMethod.GET)
    public List<LostItemDto> getPassengerLostItem(){
        return lostService.getLostItem();
    }

    @RequestMapping(value ="/list-founditems", method = RequestMethod.GET)
    public List<FoundItemDto> getPassengerFoundItem(){
        return foundService.getFoundItem();
    }

    @RequestMapping(value ="/user-list", method = RequestMethod.GET)
    public List<UserDto> getUserList() {
        return userService.getUserList();
    }

    @RequestMapping(value ="/user-list/{id}", method = RequestMethod.GET)
    public User getUser(@PathVariable final long id) { return userService.getUser(id);}



}
