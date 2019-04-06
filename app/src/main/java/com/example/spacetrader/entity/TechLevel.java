package com.example.spacetrader.entity;

/**
 * This enum class represents the tech level
 */
public enum TechLevel {
    ZERO("Pre-Agriculture"),
    ONE("Agriculture"),
    TWO("Medieval"),
    THREE("Renaissance"),
    FOUR("Early Industrial"),
    FIVE("Industrial"),
    SIX("Post-industrial"),
    SEVEN("Hi-tech");

    private final String tech;

    TechLevel(String tech) { this.tech = tech; }

    /**
     * Gets the tech level
     * @return tech level
     */
    public String getTech(){
        return this.tech;
    }
}
