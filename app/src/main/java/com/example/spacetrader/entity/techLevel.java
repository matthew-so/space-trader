package com.example.spacetrader.entity;

public enum techLevel {
    ZERO("Pre-Agriculture"),
    ONE("Agriculture"),
    TWO("Medieval"),
    THREE("Renaissance"),
    FOUR("Early Industrial"),
    FIVE("Industrial"),
    SIX("Post-industrial"),
    SEVEN("Hi-tech");

    private String tech;

    techLevel(String level) { this.tech = level;

    }

    public String getTech(){
        return this.tech;
    }
}
