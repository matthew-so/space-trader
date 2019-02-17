package com.example.spacetrader.model;

import com.example.spacetrader.entity.Difficulty;
import com.example.spacetrader.entity.Player;

public class Game {
    // De-facto Model
    private Difficulty difficulty;
    private Player player;

    public Game(String name, int trader, int fighter, int pilot, int engineer, Difficulty difficulty) {
        this.difficulty = difficulty;
        player = new Player(name, trader, fighter, pilot, engineer);
    }
}