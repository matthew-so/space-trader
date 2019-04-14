package com.example.spacetrader.entity;

import android.support.annotation.NonNull;

/**
 * This class represents the game difficulty
 */
public enum Difficulty {
    BEGINNER("Beginner"), EASY("Easy"), NORMAL("Normal"), HARD("Hard"), IMPOSSIBLE("Impossible");

    private final String val;

    Difficulty(String val) {
        this.val = val;
    }


    @Override@NonNull
    public String toString() {
        return val;
    }
}
