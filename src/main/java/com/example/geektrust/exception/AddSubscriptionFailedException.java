package com.example.geektrust.exception;

import com.example.geektrust.constants.Constants;

public class AddSubscriptionFailedException extends Exception {
    private final String errorCode;
    public AddSubscriptionFailedException(String message) {
        super(message);
        errorCode = Constants.ADD_SUBSCRIPTION_FAILED;
    }

    public String getErrorCode() {
        return errorCode + " " + this.getMessage();
    }

}
