package com.example.spacetrader.model;

import android.widget.Toast;
import com.example.spacetrader.entity.Difficulty;
import com.example.spacetrader.entity.Player;
import com.example.spacetrader.views.MainActivity;

public class GameSingleton {

    private static Difficulty difficulty;
    private static Player player;

    private static GameSingleton single_instance = new GameSingleton();

    private GameSingleton() { }

    public static GameSingleton getInstance() {
        if (single_instance == null) {
            single_instance = new GameSingleton();
        }
        return single_instance;
    }

    public static Player getPlayer() {
        return player;
    }

    public static Difficulty getDifficulty() {
        return difficulty;
    }

    public static void set(String name, int trader, int fighter, int pilot, int engineer, Difficulty difficult) {
        difficulty = difficult;
        player = new Player(name, trader, fighter, pilot, engineer);
    }
}