package com.example.geektrust.service;

public interface ISubscriptionService {
    public void startSubscription(String date);

    public void addSubscription(String category, String plan);

    public void addTopUp(String topUpPlan, int months);

    public void printRenewalDetails();
}
