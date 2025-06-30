package com.example.geektrust.model;

import com.example.geektrust.exception.InvalidDateException;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Map;

public class User {

   public static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

    String subscriptionStart;
    Map<String, Subscription> subscriptions;
    TopUp topUp;

    public String getSubscriptionStart() {
        return subscriptionStart;
    }

    public void setSubscriptionStart(String subscriptionStart) throws InvalidDateException {
        try {
            LocalDate date = LocalDate.parse(subscriptionStart, formatter);
        } catch (DateTimeParseException e) {
            throw new InvalidDateException("");
        }
        this.subscriptionStart = subscriptionStart;
    }

    public Map<String, Subscription> getSubscriptions() {
        return subscriptions;
    }

    public void addSubscriptions(Subscription subscription) {
        subscriptions.put(subscription.getCategory(), subscription);
    }

    public TopUp getTopUp() {
        return topUp;
    }

    public void setTopUp(TopUp topUp) {
        this.topUp = topUp;
    }
}
