package com.example.spacetrader.entity;
public enum TechLevel implements Comparable<TechLevel> {
    ZERO("Pre-Agriculture"),
    ONE("Agriculture"),
    TWO("Medieval"),
    THREE("Renaissance"),
    FOUR("Early Industrial"),
    FIVE("Industrial"),
    SIX("Post-industrial"),
    SEVEN("Hi-tech");

    private String tech;

    TechLevel(String tech) { this.tech = tech; }

    public String getTech(){
        return this.tech;
    }
}
