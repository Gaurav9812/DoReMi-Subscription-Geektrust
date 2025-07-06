package com.example.geektrust.exception;

public class AddSubscriptionFailedException extends Exception {
    private final String errorCode;
    public AddSubscriptionFailedException(String message) {
        super(message);
        errorCode="ADD_SUBSCRIPTION_FAILED";
    }

    public String getErrorCode() {
        return errorCode + " "+this.getMessage();
    }

}
