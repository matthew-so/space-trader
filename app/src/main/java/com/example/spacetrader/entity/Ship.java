package com.example.spacetrader.entity;

public enum Ship {
    GNAT("Gnat");

    private String val;

    Ship(String val) {
        this.val = val;
    }

    public String toString() {
        return val;
    }
}
