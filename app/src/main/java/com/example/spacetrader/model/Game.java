package com.example.spacetrader.model;

import com.example.spacetrader.entity.Difficulty;
import com.example.spacetrader.entity.Player;

public class Game{
    private final Difficulty difficulty;
    public final Player player;

    public Game(String name, int trader, int fighter, int pilot, int engineer, Difficulty difficulty) {
        this.difficulty = difficulty;
        player = new Player(name, trader, fighter, pilot, engineer);
    }

    public Difficulty getDifficulty() {
        return this.difficulty;
    }
    public Player getPlayer() {return this.player;}
}
