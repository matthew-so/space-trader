package com.example.spacetrader.entity;

import java.util.Random;

public enum RandomSolarEvent {
    UNEVENTFUL("Uneventful"), DROUGHT("Drought"), COLD("Cold"), CROPFAIL("Cropfail"), WAR("War"), BOREDOM("Boredom"),
    PLAGUE("Plague"), LACKOFWORKERS("Lack of Workers");

    private String val;

    RandomSolarEvent(String val) {
        this.val = val;
    }

    public String toString() {
        return val;
    }

    /**
     * Pick a random value of the BaseColor enum.
     * @return a random BaseColor.
     */
    public static RandomSolarEvent getRandomSolarEvent() {
        Random random = new Random();
        RandomSolarEvent  myRandomEvent = values()[random.nextInt(values().length)];
        return myRandomEvent;
    }
}
