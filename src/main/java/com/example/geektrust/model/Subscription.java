package com.example.geektrust.model;

public class Subscription {
    private String category;
    private String plan;
    private int price;
    private int month;

    public Subscription(String category, String plan, int price, int month) {
        this.category = category;
        this.plan = plan;
        this.price = price;
        this.month = month;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getPlan() {
        return plan;
    }

    public void setPlan(String plan) {
        this.plan = plan;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }
}
