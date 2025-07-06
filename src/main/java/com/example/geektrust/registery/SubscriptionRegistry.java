package com.example.geektrust.registery;

import com.example.geektrust.exception.AddSubscriptionFailedException;
import com.example.geektrust.model.Subscription;
import com.example.geektrust.model.enums.SubscriptionEnum;

import java.util.HashMap;
import java.util.Map;

public class SubscriptionRegistry {

    private static final Map<String, Subscription> subscriptionMap = new HashMap<>();
    static {
        subscriptionMap.put("MUSIC_FREE", new Subscription("MUSIC", "FREE", 0, 1));
        subscriptionMap.put("MUSIC_PERSONAL", new Subscription("MUSIC", "PERSONAL", 100, 1));
        subscriptionMap.put("MUSIC_PREMIUM", new Subscription("MUSIC", "PREMIUM", 250, 3));

        subscriptionMap.put("VIDEO_FREE", new Subscription("VIDEO", "FREE", 0, 1));
        subscriptionMap.put("VIDEO_PERSONAL", new Subscription("VIDEO", "PERSONAL", 200, 1));
        subscriptionMap.put("VIDEO_PREMIUM", new Subscription("VIDEO", "PREMIUM", 500, 3));

        subscriptionMap.put("PODCAST_FREE", new Subscription("PODCAST", "FREE", 0, 1));
        subscriptionMap.put("PODCAST_PERSONAL", new Subscription("PODCAST", "PERSONAL", 100, 1));
        subscriptionMap.put("PODCAST_PREMIUM", new Subscription("PODCAST", "PREMIUM", 300, 3));

    }

    public static Subscription getPlan(String category, String planName) throws AddSubscriptionFailedException {
        String key = category.toUpperCase() + "_" + planName.toUpperCase();
        if (!subscriptionMap.containsKey(key)) {
            throw new AddSubscriptionFailedException(SubscriptionEnum.INVALID_CATEGORY_OR_PLAN.getMessage());
        }
        return subscriptionMap.get(key);
    }
}
