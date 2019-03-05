package com.example.spacetrader.entity;

import com.example.spacetrader.model.Game;
import com.example.spacetrader.viewmodels.PlayerGoodsAdapter;
import com.example.spacetrader.views.ConfigurationActivity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Player implements Serializable {

    private Game game;

    private String name;

    private int credits;

    private int trader;

    private int fighter;

    private int pilot;

    private int engineer;

    private int totalPoints;

    private Ship ship;

    private SolarSystem currentSolarSystem;

    private ArrayList<Good> playerGoods;

    private int inventorySpace;

    private Map<Good,Integer> howMuchPlayerCanBuy;

    private Map<Good,Integer> whatPlayerCanSell;

    public Player(String name, int trader, int fighter, int pilot, int engineer) {
        this.name = name;
        this.trader = trader;
        this.fighter = fighter;
        this.pilot = pilot;
        this.engineer = engineer;
        credits = 1000;
        ship = new Ship(Ship.ShipType.GNAT);
        inventorySpace = ship.getCargoCapacity();
        totalPoints = 16;
        game = ConfigurationActivity.newGame;
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
     * @return true if the player can buy the good, fasle if not
     */
    public boolean canBuy(Good good) {
        if (this.getCredits() <= 0 || this.getCredits() < this.getCredits() - currentSolarSystem.getBuyGoodPrice(good)
                || inventorySpace == 0) {
            return false;
        } else {
            return true;
        }
    }

    /**
     * The buttons on the marketplace are activated or deactivated based on this value
     * checks if the player can sell a good
     * @param good the good the player wants to sell
     * @return true if the player can false if he or she cannot
     */
    public boolean canSell(Good good) {
        if (!playerGoods.contains(good) || !whatPlayerCanSell.containsKey(good)){
           return false;
        } else {
            return true;
        }
    }

    /**
     * the player buys a good
     * @param good the good the player wishes to buy
     */
    public void buy(Good good) {
        this.setCredits(this.credits -= currentSolarSystem.getBuyGoodPrice(good));
        if (!playerGoods.contains(good)) {
            playerGoods.add(good);
        }

        this.inventorySpace--;
        good.setQuantity(good.getQuantity() - 1);
        if (howMuchPlayerCanBuy == null) {
            howMuchPlayerCanBuy = currentSolarSystem.getQuantityBuy();
        }
        howMuchPlayerCanBuy.put(good, howMuchPlayerCanBuy.get(good) - 1);
        if(whatPlayerCanSell == null) {
            this.setWhatPlayerCanSell();
        }
        whatPlayerCanSell.put(good,whatPlayerCanSell.getOrDefault(good,0) + 1);


    }

    /**
     * player sells a good
     * @param good
     */
    public void sell(Good good) {
        this.setCredits(credits += currentSolarSystem.getSellGoodPrice(good));
        inventorySpace++;
        good.setQuantity(good.getQuantity() - 1);
        if (howMuchPlayerCanBuy == null) {
            howMuchPlayerCanBuy = currentSolarSystem.getQuantityBuy();
        }
        howMuchPlayerCanBuy.put(good, howMuchPlayerCanBuy.getOrDefault(good, 0) + 1);
        whatPlayerCanSell.put(good,whatPlayerCanSell.getOrDefault(good,0) - 1);
        if (whatPlayerCanSell.get(good) == 0) {
            playerGoods.remove(good);
        }



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

    public void setCredits(int credits) {
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
        whatPlayerCanSell = currentSolarSystem.getBuyGood();
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public int getInventorySpace() {
        return inventorySpace;
    }

}

