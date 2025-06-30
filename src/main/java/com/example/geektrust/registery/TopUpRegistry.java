package com.example.geektrust.registery;

import com.example.geektrust.exception.AddTopUpFailedException;
import com.example.geektrust.model.TopUp;

import java.util.HashMap;
import java.util.Map;

public class TopUpRegistry {

    private static final Map<String, TopUp> topUpMap = new HashMap<>();
    static {
        topUpMap.put("FOUR_DEVICE", new TopUp(4,1,50));
        topUpMap.put("TEN_DEVICE", new TopUp(10,1,100));
    }

    public static TopUp getPlan(String topUp) throws AddTopUpFailedException {
        String key = topUp.toUpperCase();
        if (!topUpMap.containsKey(key)) {
            throw new AddTopUpFailedException("INVALID_TOP_UP");
        }
        return topUpMap.get(key);
    }
}
