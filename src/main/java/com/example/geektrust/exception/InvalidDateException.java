package com.example.geektrust.exception;

import com.example.geektrust.constants.Constants;

public class InvalidDateException extends Exception {

    private final String errorCode;

    public InvalidDateException(String message){
        super(message);
        errorCode = Constants.INVALID_DATE;
    }

    public String getErrorCode() {
        return errorCode + " "+this.getMessage();
    }
}
