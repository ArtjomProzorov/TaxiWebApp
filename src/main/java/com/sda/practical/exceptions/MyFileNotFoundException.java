package com.sda.practical.exceptions;

import java.lang.reflect.Executable;

public class MyFileNotFoundException extends Exception {

    public MyFileNotFoundException(String myFileNotFound){
        super(myFileNotFound);
    }
}
