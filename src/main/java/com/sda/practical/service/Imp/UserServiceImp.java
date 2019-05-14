package com.sda.practical.service.Imp;


import com.sda.practical.dto.UserDto;
import com.sda.practical.exceptions.EmailAlreadyExistsException;
import com.sda.practical.exceptions.UserNameAlreadyExistsException;
import com.sda.practical.model.User;
import com.sda.practical.repository.UserRepository;
import com.sda.practical.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImp implements UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;


    @Autowired
    public UserServiceImp(UserRepository userRepository, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }


    @Override
    public User findOne(Long id) {
     return userRepository.findById(id).filter(user -> user.getId().equals(id)).orElse(null); }


    @Override
    public UserDto register(UserDto userDto) {
        User user = modelMapper.map(userDto, User.class);
        if(userRepository.findUserByEmail(user.getEmail()) == null){
        if (userRepository.findUserByUsername(user.getUserName()) == null) {

            return modelMapper.map(userRepository.save(user), UserDto.class);

        } else throw new UserNameAlreadyExistsException(user.getUserName());
        } else throw new EmailAlreadyExistsException(user.getEmail());
    }

    @Override
    public ResponseEntity logout(HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null) {
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return new ResponseEntity(HttpStatus.OK);

    }


    @Override
    public List<UserDto> getUserList() {
        List<User> listOfRoles = userRepository.findAll();
        return listOfRoles.stream().map(user -> modelMapper.map(user, UserDto.class)).collect(Collectors.toList());
    }


    @Override
    public User getUser(Long id) {
        return userRepository.findById(id).filter(user -> user.getId().equals(id)).orElse(null); }



}
