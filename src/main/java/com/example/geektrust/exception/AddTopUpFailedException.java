package com.example.geektrust.exception;

import com.example.geektrust.constants.Constants;

public class AddTopUpFailedException extends Exception {
    private final String errorCode;
    public AddTopUpFailedException(String message) {
        super(message);
        errorCode = Constants.ADD_TOPUP_FAILED;
    }

    public String getErrorCode() {
        return errorCode +" "+ this.getMessage();
    }

}
