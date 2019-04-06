package com.example.spacetrader.entity;

import java.util.Random;

/**
 * This class represents the random solar events
 */
@SuppressWarnings("SpellCheckingInspection")
public enum RandomSolarEvent {
    UNEVENTFUL("Uneventful"), DROUGHT("Drought"), COLD("Cold"), CROPFAIL("Crop fail"), WAR("War"), BOREDOM("Boredom"),
    PLAGUE("Plague"), LACKOFWORKERS("Lack of Workers");

    private final String val;

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
        return  values()[random.nextInt(values().length)];

    }
}
