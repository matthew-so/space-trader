package com.example.spacetrader.entity;

public enum Difficulty {
    BEGINNER("Beginner"), EASY("Easy"), NORMAL("Normal"), HARD("Hard"), IMPOSSIBLE("Impossible");

    private String val;

    Difficulty(String val) {
        this.val = val;
    }

    @Override
    public String toString() {
        return val;
    }
}
