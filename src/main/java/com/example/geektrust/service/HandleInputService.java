package com.example.geektrust.service;

import com.example.geektrust.constants.Constants;
import com.example.geektrust.model.User;

import java.util.Arrays;

public class HandleInputService {

    private final ISubscriptionService subscriptionService;

    public HandleInputService() {
        this.subscriptionService = new SubscriptionService(new User());
    }

    public void processInput(String input) {
        String[] inputs = input.split(" ");
        try {
            if (inputs.length > Constants.ZERO) {
                switch (inputs[Constants.ZERO]) {
                    case Constants.START_SUBSCRIPTION:
                        if (inputs.length > Constants.ONE) subscriptionService.startSubscription(inputs[Constants.ONE]);
                        break;
                    case Constants.ADD_SUBSCRIPTION:
                        if (inputs.length > Constants.TWO) subscriptionService.addSubscription(inputs[Constants.ONE], inputs[Constants.TWO]);
                        break;
                    case Constants.ADD_TOPUP:
                        if (inputs.length > Constants.TWO) {
                            subscriptionService.addTopUp(inputs[Constants.ONE], Integer.parseInt(inputs[Constants.TWO]));
                        }
                        break;
                    case Constants.PRINT_RENEWAL_DETAILS:
                        subscriptionService.printRenewalDetails();
                        break;
                }
            }
        } catch (Exception e) {
            System.out.println(Arrays.toString(e.getStackTrace()));
        }

    }
}
