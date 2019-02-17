package com.example.spacetrader.model;

import android.widget.Toast;
import com.example.spacetrader.entity.Difficulty;
import com.example.spacetrader.entity.Player;
import com.example.spacetrader.views.MainActivity;

public class Game {
    // De-facto Model
    private Difficulty difficulty;
    public Player player;

    public Game(String name, int trader, int fighter, int pilot, int engineer, Difficulty difficulty) {
        this.difficulty = difficulty;
        player = new Player(name, trader, fighter, pilot, engineer);
    }

    public Difficulty getDifficulty() {
        return difficulty;
    }
}
