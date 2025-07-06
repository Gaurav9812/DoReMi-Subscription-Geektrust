package com.example.geektrust.model;

import com.example.geektrust.exception.InvalidDateException;
import java.util.Map;

public class User {


    String subscriptionStart;
    Map<String, Subscription> subscriptions;
    TopUp topUp;
    int topUpForMonths;

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
        return null;
    }

    public void setTopUp(TopUp topUp) {
        this.topUp = topUp;
    }

    public void isValid() throws InvalidDateException {
        if(this.subscriptionStart == null) throw new InvalidDateException("");

    }

    public Subscription getSubscription(String category, String plan) {
        String key = this.getSubscriptionKey(category, plan);
        return this.getSubscriptions().get(key);
    }

    private String getSubscriptionKey(String category, String plan) {
        return category + "_" + plan;
    }
    public void addSubscription(String category, String plan, Subscription subscription) {
        String key = this.getSubscriptionKey(category, plan);
        subscriptions.put(key, subscription);
    }
}
