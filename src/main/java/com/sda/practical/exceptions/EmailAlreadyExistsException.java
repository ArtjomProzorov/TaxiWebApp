package com.sda.practical.exceptions;

import com.sda.practical.dto.UserDto;

public class EmailAlreadyExistsException extends RuntimeException{

        public EmailAlreadyExistsException(String email) {
            super("The email " + email + " already exist, please use different one or contact support");
        }
    }

