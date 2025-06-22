package com.example.InstaRide.exception;

import com.example.InstaRide.repository.DriverRepository;

public class DriverNotFoundException extends RuntimeException{

    public DriverNotFoundException(String message){
        super(message);
    }
}
