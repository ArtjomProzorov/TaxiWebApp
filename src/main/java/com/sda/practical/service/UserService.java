package com.sda.practical.service;

import com.sda.practical.dto.UserDto;
import com.sda.practical.model.User;
import org.springframework.http.ResponseEntity;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public interface UserService {

    User getUser(Long id);

    UserDto register(UserDto userDto);

    List<UserDto> getUserList();

    User findOne(Long id);


    ResponseEntity logout(HttpServletRequest request, HttpServletResponse response);


}
