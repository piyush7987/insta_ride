package com.example.InstaRide.exception;

public class CabUnavailableException extends RuntimeException{

    public  CabUnavailableException(String message){
        super(message);
    }
}
