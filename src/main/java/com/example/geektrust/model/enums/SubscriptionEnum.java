package com.example.geektrust.model.enums;

public enum SubscriptionEnum {
    ADD_SUBSCRIPTION_FAILED("ADD_SUBSCRIPTION_FAILED"),
    DUPLICATE_CATEGORY("DUPLICATE_CATEGORY"),
    RENEWAL_REMINDER("RENEWAL_REMINDER"),
    SUBSCRIPTIONS_NOT_FOUND("SUBSCRIPTIONS_NOT_FOUND"),
    DUPLICATE_TOPUP("DUPLICATE_TOPUP"),
    RENEWAL_AMOUNT("RENEWAL_AMOUNT"),
    INVALID_TOPUP("INVALID_TOPUP"),
    INVALID_CATEGORY_OR_PLAN("INVALID_CATEGORY_OR_PLAN"),
    ;

    private final String message;

    SubscriptionEnum(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
