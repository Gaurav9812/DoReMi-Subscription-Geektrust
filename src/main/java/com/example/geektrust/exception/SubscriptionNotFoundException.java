package com.example.geektrust.exception;

public class SubscriptionNotFoundException extends Exception {
    private final String errorCode;
    public SubscriptionNotFoundException(String message) {
        super(message);
        errorCode="SUBSCRIPTIONS_NOT_FOUND";
    }

    public String getErrorCode() {
        return errorCode + " "+this.getMessage();
    }

}
