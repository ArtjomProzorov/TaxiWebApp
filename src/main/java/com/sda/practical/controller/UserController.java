package com.sda.practical.controller;


import com.sda.practical.dto.UserDto;
import com.sda.practical.model.User;
import com.sda.practical.repository.UserRepository;
import com.sda.practical.service.DriverService;
import com.sda.practical.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;


@RestController
@RequestMapping("/user")
public class UserController {

   private  final UserService userService;

    @Autowired
    public UserController( UserService userService) {
        this.userService = userService;

    }

    @GetMapping({"/", "/welcome"})
    public String welcome() {
        return "index";
    }

    @PostMapping("/register" )
    public UserDto register(@RequestBody UserDto userDto) {
        return userService.register(userDto);
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public ResponseEntity logout(HttpServletRequest request, HttpServletResponse response) {
        return userService.logout(request, response);
    }



}