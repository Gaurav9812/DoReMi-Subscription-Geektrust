package com.example.geektrust.service;

import com.example.geektrust.model.User;

import java.util.Arrays;

public class HandleInputService {

    private final SubscriptionService subscriptionService;

    public HandleInputService() {
        this.subscriptionService = new SubscriptionService(new User());
    }

    public void processInput(String input) {
        String[] inputs = input.split(" ");
        try {
            if (inputs.length > 0) {
                switch (inputs[0]) {
                    case "START_SUBSCRIPTION":
                        if (inputs.length > 1) subscriptionService.startSubscription(inputs[1]);
                        break;
                    case "ADD_SUBSCRIPTION":
                        if (inputs.length > 2) subscriptionService.addSubscription(inputs[1], inputs[2]);
                        break;
                    case "ADD_TOPUP":
                        if (inputs.length > 2) {
                            subscriptionService.addTopUp(inputs[1], Integer.parseInt(inputs[2]));
                        }
                        break;
                    case "PRINT_RENEWAL_DETAILS":
                        subscriptionService.printRenewalDetails();
                        break;
                }
            }
        } catch (Exception e) {
            System.out.println(Arrays.toString(e.getStackTrace()));
        }

    }
}
