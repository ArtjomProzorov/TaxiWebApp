package com.sda.practical.exceptions;

import com.sda.practical.dto.UserDto;

public class UserNameAlreadyExistsException extends RuntimeException {

    public UserNameAlreadyExistsException(String userName){
        super("Our apologies but the username " + userName + " already exist");
    }
}
