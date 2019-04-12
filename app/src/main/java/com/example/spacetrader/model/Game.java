package com.example.spacetrader.model;

import com.example.spacetrader.entity.Difficulty;
import com.example.spacetrader.entity.Player;

/**
 * This class represents the game
 */
public class Game{
    private final Difficulty difficulty;
    private final Player player;

    /**
     * This is the constructor for the game
     * @param name The name of the player
     * @param trader The number of trader points
     * @param fighter The number of fighter points
     * @param pilot The number of pilot points
     * @param engineer The number of engineer points
     * @param difficulty The difficulty of the game
     */
    public Game(String name, int trader, int fighter, int pilot, int engineer, Difficulty difficulty) {
        this.difficulty = difficulty;
        player = new Player(name, trader, fighter, pilot, engineer);
    }

    /**
     * This method returns the difficulty of the game
     * @return The difficulty
     */
    public Difficulty getDifficulty() {
        return this.difficulty;
    }

    /**
     * This method returns the player of the game
     * @return The player
     */
    public Player getPlayer() {return this.player;}
}
