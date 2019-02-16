package com.example.spacetrader;


public enum Difficulty {

    BEGINNER("Beginner"),
    EASY("Easy"),
    NORMAL("Normal"),
    HARD("Hard"),
    IMPOSSIBLE("IMPOSSIBLE!");

    private final String level;

    Difficulty(String lev) {
        level = lev;
    }

    public String toString() {
        return level;
    }


}
