package com.example.geektrust.service;

import com.example.geektrust.constants.Constants;
import com.example.geektrust.exception.AddSubscriptionFailedException;
import com.example.geektrust.exception.AddTopUpFailedException;
import com.example.geektrust.exception.InvalidDateException;
import com.example.geektrust.exception.SubscriptionNotFoundException;
import com.example.geektrust.model.Subscription;
import com.example.geektrust.model.TopUp;
import com.example.geektrust.model.User;
import com.example.geektrust.model.enums.SubscriptionMessageType;
import com.example.geektrust.registery.SubscriptionRegistry;
import com.example.geektrust.registery.TopUpRegistry;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class SubscriptionService implements ISubscriptionService{

    public static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern(Constants.SUBSCRIPTION_START_DATE_FORMAT);
    private final User user;

    public SubscriptionService(User user) {
        this.user = user;
    }

    public void startSubscription(String date) {
        try {
            getLocaleDate(date);
            user.setSubscriptionStart(date);
        } catch (InvalidDateException e) {
            System.out.println(e.getMessage());
        }
    }

    public void addSubscription(String category, String plan) {
        try {
            Subscription subscription = user.getSubscription(category);
            if (!user.isSubscriptionStarted()) throw new InvalidDateException(Constants.INVALID_DATE);
            if (subscription != null)
                throw new AddSubscriptionFailedException(SubscriptionMessageType.DUPLICATE_CATEGORY.toString());
            Subscription subscription1 = SubscriptionRegistry.getPlan(category, plan);
            user.addSubscription(category, plan, subscription1);
            System.out.println(SubscriptionMessageType.RENEWAL_REMINDER+ " " + subscription1.getCategory() + " " + getReminderDate(user.getSubscriptionStart(), subscription1.getMonth()));
        } catch (InvalidDateException e) {
            System.out.println(SubscriptionMessageType.ADD_SUBSCRIPTION_FAILED + " " + e.getMessage());
        } catch (AddSubscriptionFailedException e) {
            System.out.println(e.getErrorCode());
        }
    }

    private LocalDate getLocaleDate(String subscriptionStart) throws InvalidDateException {
        LocalDate date;
        try {
            date = LocalDate.parse(subscriptionStart, formatter);
        } catch (DateTimeParseException e) {
            throw new InvalidDateException(Constants.INVALID_DATE);
        }
        return date;
    }

    private String getReminderDate(String startDateStr, int monthsToRenew) throws InvalidDateException {
        LocalDate startDate = getLocaleDate(startDateStr);
        LocalDate reminderDate = startDate.plusMonths(monthsToRenew);
        LocalDate reminderDate1 = reminderDate.minusDays(10);
        return reminderDate1.format(formatter);
    }

    public void addTopUp(String topUpPlan, int months) {
        try {
            if (!user.isSubscriptionStarted()) throw new InvalidDateException(Constants.INVALID_DATE);
            if (user.getSubscriptions().isEmpty())
                throw new AddTopUpFailedException(SubscriptionMessageType.SUBSCRIPTIONS_NOT_FOUND.toString());
            if (user.getTopUp() != null)
                throw new AddTopUpFailedException(SubscriptionMessageType.DUPLICATE_TOPUP.toString());
            TopUp topUp = TopUpRegistry.getPlan(topUpPlan);
            user.setTopUp(topUp);
            user.setTopUpForMonths(months);
        } catch (InvalidDateException e) {
            System.out.println(SubscriptionMessageType.ADD_TOPUP_FAILED + " " + e.getMessage());
        } catch (AddTopUpFailedException e) {
            System.out.println(e.getErrorCode());
        }
    }

    public void printRenewalDetails() {
        try {
            if (user.getSubscriptions().isEmpty()) throw new SubscriptionNotFoundException("");
            int totalPrice = user.getSubscriptions().values().stream()
                    .mapToInt(Subscription::getPrice)
                    .sum();

            TopUp topUp = user.getTopUp();
            if (topUp != null) {
                totalPrice += topUp.getAmount() * user.getTopUpForMonths();
            }
            System.out.println(SubscriptionMessageType.RENEWAL_AMOUNT + " " + totalPrice);
        } catch (SubscriptionNotFoundException e) {
            System.out.println(e.getErrorCode());
        }

    }

}
