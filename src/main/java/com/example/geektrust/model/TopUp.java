package com.example.geektrust.model;

public class TopUp {

    int device;
    int month;
    int amount;

    public TopUp(int device, int month, int amount) {
        this.device = device;
        this.month = month;
        this.amount = amount;
    }

    public int getDevice() {
        return device;
    }

    public void setDevice(int device) {
        this.device = device;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
