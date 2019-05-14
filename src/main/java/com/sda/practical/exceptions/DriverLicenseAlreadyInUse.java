package com.sda.practical.exceptions;

public class DriverLicenseAlreadyInUse extends Exception {

    public DriverLicenseAlreadyInUse(String license){
        super("Entered driving license + " + license + " already in use");
    }


}
