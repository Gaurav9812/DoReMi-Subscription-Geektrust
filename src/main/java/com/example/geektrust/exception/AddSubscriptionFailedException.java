package com.example.geektrust.exception;

public class AddSubscriptionFailedException extends Exception {
    private final String errorCode;
    public AddSubscriptionFailedException(String message) {
        super(message);
        errorCode="SUBSCRIPTIONS_NOT_FOUND";
    }

    public String getErrorCode() {
        return errorCode + " "+this.getMessage();
    }

}
