package com.example.spacetrader.entity;

import com.example.spacetrader.model.Game;
import com.example.spacetrader.views.ConfigurationActivity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Map;

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

    private Map<Good,Integer> howMuchPlayerCanBuy;



    public Player(String name, int trader, int fighter, int pilot, int engineer) {
        this.name = name;
        this.trader = trader;
        this.fighter = fighter;
        this.pilot = pilot;
        this.engineer = engineer;
        credits = 1000;
        ship = new Ship(Ship.ShipType.GNAT);
        inventorySpace = ship.getCargoCapacity();
        totalPoints = Constants.START_SKILL;
        playerGoods = new ArrayList<>();

    }


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
     * @return true if the player can false if he or she cannot
     */
    public boolean canSell(Good good) {
        return (playerGoods.contains(good));
    }

    /**
     * the player buys a good
     * @param good the good the player wishes to buy
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
     * player sells a good
     * @param good
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

    public void travel(int distance) {
        ship.travel(distance);
    }

    public int getShipFuel() { return ship.getFuel();}

    public int getXCoordinate() {
        return currentSolarSystem.getxCoor();
    }

    public int getYCoordinate() {
        return currentSolarSystem.getyCoor();
    }

    public String getSolarSystemName() {
        return currentSolarSystem.getName();
    }

    public String getName() {
        return name;
    }

    public int getCredits() {
        return credits;
    }

    public int getTrader() {
        return trader;
    }

    public int getFighter() {
        return fighter;
    }

    public int getPilot() {
        return pilot;
    }

    public int getEngineer() {
        return engineer;
    }

    public Ship getShipType() {
        return ship;
    }

    private void setCredits(int credits) {
        this.credits = credits;
    }

    public Game getGame() {return ConfigurationActivity.newGame; }

    public SolarSystem getCurrentSolarSystem() {
        return currentSolarSystem;
    }

    /**sets the current solar system of player*/
    public void setCurrentSolarSystem(SolarSystem s) {
        currentSolarSystem = s;
        howMuchPlayerCanBuy = currentSolarSystem.getQuantityBuy();
    }

    /**
     * Returns a filtered list of player goods.
     * Goods must have valid prices.
     * @return an ArrayList of Goods
     */
    public ArrayList<Good> getPlayerGoods() {
        return playerGoods;

    }



    public void addToPlayerGoods(Good good) {
        playerGoods.add(good);
    }

    /**This method is only called when the solar system is assigned to the Player**/
    private void setHowMuchPlayerCanBuy() {
        howMuchPlayerCanBuy = currentSolarSystem.getQuantityBuy();
    }

    private void setWhatPlayerCanSell() {
        Map<Good, Integer> whatPlayerCanSell = currentSolarSystem.getBuyGood();
    }

    public int getInventorySpace() {
        return inventorySpace;
    }

}

