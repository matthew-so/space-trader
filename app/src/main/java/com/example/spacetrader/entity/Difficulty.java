package com.example.spacetrader.entity;

/**
 * This class represents the game difficulty
 */
public enum Difficulty {
    BEGINNER("Beginner"), EASY("Easy"), NORMAL("Normal"), HARD("Hard"), IMPOSSIBLE("Impossible");

    private final String val;

    Difficulty(String val) {
        this.val = val;
    }

    @Override
    public String toString() {
        return val;
    }
}
