package com.example.geektrust.exception;

public class InvalidDateException extends Exception {

    private final String errorCode;

    public InvalidDateException(String message){
        super(message);
        errorCode = "INVALID_DATE";
    }

    public String getErrorCode() {
        return errorCode + " "+this.getMessage();
    }
}
