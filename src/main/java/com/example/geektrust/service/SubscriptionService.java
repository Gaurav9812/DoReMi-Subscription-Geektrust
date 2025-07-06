package com.example.geektrust.service;

import com.example.geektrust.exception.AddSubscriptionFailedException;
import com.example.geektrust.exception.AddTopUpFailedException;
import com.example.geektrust.exception.InvalidDateException;
import com.example.geektrust.model.Subscription;
import com.example.geektrust.model.TopUp;
import com.example.geektrust.model.User;
import com.example.geektrust.model.enums.SubscriptionEnum;
import com.example.geektrust.registery.SubscriptionRegistry;
import com.example.geektrust.registery.TopUpRegistry;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class SubscriptionService {

    public static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    private final User user = new User();
    public SubscriptionService() {}

    public void startSubscription(String date) {
        try {
            user.setSubscriptionStart(date);
            getLocaleDate(date);
        } catch (InvalidDateException e) {
            System.out.println(e.getMessage());
        }
    }

    public void addSubscription(String category, String plan) {
        try {
            Subscription subscription = user.getSubscription(category, plan);
            if(subscription != null) throw new AddSubscriptionFailedException(SubscriptionEnum.DUPLICATE_CATEGORY.getMessage());
            Subscription subscription1 = SubscriptionRegistry.getPlan(category, plan);
            user.addSubscription(category, plan, subscription1);
            System.out.println(SubscriptionEnum.RENEWAL_REMINDER+" "+subscription1.getCategory()+" "+ getReminderDate(user.getSubscriptionStart(), subscription1.getMonth()));
        } catch (InvalidDateException e) {
            System.out.println(SubscriptionEnum.ADD_SUBSCRIPTION_FAILED +" " + e.getMessage());
        } catch (AddSubscriptionFailedException e){
            System.out.println(e.getMessage());
        }
    }

    private LocalDate getLocaleDate(String subscriptionStart) throws InvalidDateException {
        LocalDate date;
        try {
            date = LocalDate.parse(subscriptionStart, formatter);
        } catch (DateTimeParseException e) {
            throw new InvalidDateException("");
        }
        return date;
    }

    private String getReminderDate(String startDateStr, int monthsToRenew) throws InvalidDateException {
        LocalDate startDate = getLocaleDate(startDateStr);
        LocalDate reminderDate = startDate.plusMonths(monthsToRenew).minusDays(10);
        return reminderDate.format(formatter);
    }

    public void addTopUp(String topUpPlan, int months) {
        try {
            if(user.getSubscriptions() == null) throw  new AddTopUpFailedException(SubscriptionEnum.SUBSCRIPTIONS_NOT_FOUND.getMessage());
            if(user.getTopUp() != null) throw  new AddTopUpFailedException(SubscriptionEnum.DUPLICATE_TOPUP.getMessage());
            TopUp topUp = TopUpRegistry.getPlan(topUpPlan);
            user.setTopUp(topUp);
            user.setTopUpForMonths(months);
        } catch (AddTopUpFailedException e) {
            System.out.println(e.getMessage());
        }
    }

    public void printRenewalDetails() {
        try {
            if(user.getSubscriptions() == null) throw  new AddTopUpFailedException(SubscriptionEnum.SUBSCRIPTIONS_NOT_FOUND.getMessage());
            int totalPrice = user.getSubscriptions().values().stream()
                    .mapToInt(Subscription::getPrice)
                    .sum();
            TopUp topUp = user.getTopUp();
            if(topUp != null) {
                totalPrice += topUp.getAmount()*user.getTopUpForMonths();
            }
            System.out.println(SubscriptionEnum.RENEWAL_AMOUNT+" " +totalPrice);
        } catch (AddTopUpFailedException e) {
            System.out.println(e.getMessage());
        }

    }

}
