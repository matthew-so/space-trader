package com.example.spacetrader.entity;

/**
 * This class represents a planet
 */
public class Planet {
    private final String name;

    /**
     * This planet constructor
     * @param name The name of the planet
     */
    public Planet(String name) {
        this.name = name;
    }

    /**
     * Gets the name of the planet
     * @return name
     */
    public String getName() {
        return name;
    }
}
