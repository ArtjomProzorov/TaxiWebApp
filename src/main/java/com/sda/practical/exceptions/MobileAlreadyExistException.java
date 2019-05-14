package com.sda.practical.exceptions;

public class MobileAlreadyExistException extends Exception {

    public MobileAlreadyExistException(){
        super("Mobile already in the system, please contact support for further resolution");
    }
}
