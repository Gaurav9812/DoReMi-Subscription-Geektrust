package com.example.geektrust.exception;

public class AddTopUpFailedException extends Exception {
    private final String errorCode;
    public AddTopUpFailedException(String message) {
        super(message);
        errorCode="ADD_TOPUP_FAILED";
    }

    public String getErrorCode() {
        return errorCode +" "+ this.getMessage();
    }

}
