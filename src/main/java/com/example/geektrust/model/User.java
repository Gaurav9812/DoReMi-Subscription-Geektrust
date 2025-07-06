package com.example.geektrust.model;

import com.example.geektrust.exception.InvalidDateException;

import java.util.HashMap;
import java.util.Map;

public class User {


    String subscriptionStart;
    Map<String, Subscription> subscriptions;
    TopUp topUp;
    int topUpForMonths;

    public User() {
        subscriptions = new HashMap<>();
    }

    public int getTopUpForMonths() {
        return topUpForMonths;
    }

    public void setTopUpForMonths(int topUpForMonths) {
        this.topUpForMonths = topUpForMonths;
    }

    public String getSubscriptionStart() {
        return subscriptionStart;
    }

    public void setSubscriptionStart(String subscriptionStart) throws InvalidDateException {
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

    public void isValid() throws InvalidDateException {
        if(this.subscriptionStart == null) throw new InvalidDateException("");

    }

    public Subscription getSubscription(String category) {
        String key = this.getSubscriptionKey(category);
        return this.getSubscriptions().get(key);
    }

    private String getSubscriptionKey(String category) {
        return category;
    }
    public void addSubscription(String category, String plan, Subscription subscription) {
        String key = this.getSubscriptionKey(category);
        subscriptions.put(key, subscription);
    }

    @Override
    public String toString() {
        return "User{" +
                "subscriptionStart='" + subscriptionStart + '\'' +
                ", subscriptions=" + subscriptions +
                ", topUp=" + topUp +
                ", topUpForMonths=" + topUpForMonths +
                '}';
    }
}
