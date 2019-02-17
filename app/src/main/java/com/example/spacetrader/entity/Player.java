package com.example.spacetrader.entity;

import java.io.Serializable;

public class Player implements Serializable {
    private String name;

    private int credits;

    private int trader;

    private int fighter;

    private int pilot;

    private int engineer;

    private Ship ship;

    public Player(String name, int trader, int fighter, int pilot, int engineer) {
        this.name = name;
        this.trader = trader;
        this.fighter = fighter;
        this.pilot = pilot;
        this.engineer = engineer;
        credits = 1000;
        ship = Ship.GNAT;
    }

    public String getName() {
        return name;
    }

    public int getCredits() {
        return credits;
    }

    public int getTrader() {
        return trader;
    }

    public int getFighter() {
        return fighter;
    }

    public int getPilot() {
        return pilot;
    }

    public int getEngineer() {
        return engineer;
    }

    public Ship getShip() {
        return ship;
    }
}
