package com.sda.practical.exceptions;

public class OrderNotFoundException extends Exception {

    public OrderNotFoundException(Long orderNotFound){
        super(String.valueOf(orderNotFound));
    }
}


