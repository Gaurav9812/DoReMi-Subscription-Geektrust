package com.example.geektrust.exception;

import com.example.geektrust.constants.Constants;

public class SubscriptionNotFoundException extends Exception {
    private final String errorCode;
    public SubscriptionNotFoundException(String message) {
        super(message);
        errorCode = Constants.SUBSCRIPTIONS_NOT_FOUND;
    }

    public String getErrorCode() {
        return errorCode + " "+this.getMessage();
    }

}
