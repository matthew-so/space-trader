package com.example.spacetrader.entity;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.Map;

/**
 * This class represents the player
 */
public class Player implements Serializable {

    private final String name;

    private int credits;

    private final int trader;

    private final int fighter;

    private final int pilot;

    private final int engineer;

    private int totalPoints;

    private final Ship ship;

    private SolarSystem currentSolarSystem;

    private final ArrayList<Good> playerGoods;

    private int inventorySpace;




    /**
     * The constructor for the player
     * @param name The name of the player
     * @param trader The number of trader skill points
     * @param fighter The number of fighter skill points
     * @param pilot The number of pilot skill points
     * @param engineer The number of engineer skill points
     */
    public Player(String name, int trader, int fighter, int pilot, int engineer) {
        this.name = name;
        this.trader = trader;
        this.fighter = fighter;
        this.pilot = pilot;
        this.engineer = engineer;
        credits = 1000;
        ship = new Ship(Ship.ShipType.GNAT);
        inventorySpace = ship.getCargoCapacity();
        totalPoints = Constants.START_SKILL.getValue();
        playerGoods = new ArrayList<>();

    }

    /**
     * Calculates the amount of skill points player can purchase
     * @return total points
     */
    public int calculatePointsLeft() {
        totalPoints -= trader;
        totalPoints -= fighter;
        totalPoints -= pilot;
        totalPoints -= engineer;
        return totalPoints;
    }

    /**
     * The buttons on the marketplace are activated or deactivated based on this value
     * determines whether or not the player can buy the good
     * @param good the good the player wishes to buy
     * @return true if the player can buy the good, false if not
     */
    private boolean canBuy(Good good) {

        return !((((this.getCredits() <= 0)
                || (inventorySpace == 0))
                || (currentSolarSystem.getBuyGoodPrice(good) > credits)));
    }

    /**
     * The buttons on the marketplace are activated or deactivated based on this value
     * checks if the player can sell a good
     * @param good the good the player wants to sell
     * @return true if the player can false if they cannot
     */
    public boolean canSell(Good good) {
        return (playerGoods.contains(good));
    }

    /**
     * The player buys a good
     * @param good the good the player wishes to buy
     * @return true if the player can false if they cannot
     */
    public boolean buy(Good good) {
        if (!canBuy(good)) {
            return false;
        } else {
            this.setCredits(good.buyAndReturnMoney(credits));
            if (!playerGoods.contains(good)) {
                playerGoods.add(good);
            }
            this.inventorySpace--;
            return true;
        }

    }

    /**
     * The player sells a good
     * @param good The good the player sells
     * @return true if the player can false if they cannot
     */
    public boolean sell(Good good) {
        if ((!canSell(good)) || (good.getQuantity() == 0)) {
            return false;
        } else {
            this.setCredits(good.sellAndReturnMoney(credits));
            this.inventorySpace++;
            return true;
        }



    }

    /**
     * The distance traveled by the ship
     * @param distance The distance
     */
    public void travel(int distance) {
        ship.travel(distance);
    }

    /**
     * Gets the current fuel of the ship
     * @return The fuel
     */
    public int getShipFuel() { return ship.getFuel();}

    /**
     * Gets the x-coordinate of the solar system
     * @return x-coordinate
     */
    public int getXCoordinate() {
        return currentSolarSystem.getXCoordinate();
    }

    /**
     * Gets the y-coordinate of the solar system
     * @return y-coordinate
     */
    public int getYCoordinate() {
        return currentSolarSystem.getYCoordinate();
    }

    /**
     * Gets the current solar system name
     * @return The name of the current solar system
     */
    public String getSolarSystemName() {
        return currentSolarSystem.getName();
    }

    /**
     * Gets the name of the player
     * @return The name of the player
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the credits of the player
     * @return credits
     */
    public int getCredits() {
        return credits;
    }

    /**
     * Gets the player's trader skill points
     * @return trader skill points
     */
    public int getTrader() {
        return trader;
    }
    /**
     * Gets the player's fighter skill points
     * @return fighter skill points
     */
    public int getFighter() {
        return fighter;
    }
    /**
     * Gets the player's pilot skill points
     * @return pilot skill points
     */
    public int getPilot() {
        return pilot;
    }
    /**
     * Gets the player's engineer skill points
     * @return engineer skill points
     */
    public int getEngineer() {
        return engineer;
    }

    /**
     * Gets the player's ship type
     * @return ship type
     */
    public Ship getShipType() {
        return ship;
    }

    private void setCredits(int credits) {
        this.credits = credits;
    }

    /**
     * Gets the current solar system of the player
     * @return current solar system
     */
    public SolarSystem getCurrentSolarSystem() {
        return currentSolarSystem;
    }

    /**
     * Sets the current solar system
     * @param s The current solar system
     */
    public void setCurrentSolarSystem(SolarSystem s) {
        currentSolarSystem = s;
    }

    /**
     * Returns a filtered list of player goods.
     * Goods must have valid prices.
     * @return an ArrayList of Goods
     */
    public ArrayList<Good> getPlayerGoods() {
        return this.playerGoods;

    }


    /**
     * Adds good to player inventory
     * @param good The good to add
     */
    public void addToPlayerGoods(Good good) {
        playerGoods.add(good);
    }


    /**
     * Gets the current inventory space
     * @return inventory space
     */
    public int getInventorySpace() {
        return inventorySpace;
    }

}

