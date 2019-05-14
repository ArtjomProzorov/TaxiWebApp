package com.sda.practical.exceptions;

public class CarPlateAlreadyRegistered extends RuntimeException {

    public CarPlateAlreadyRegistered(String carplate){
        super("I am sorry but car with the following plate number " + carplate + " already registered ");
    }

}
