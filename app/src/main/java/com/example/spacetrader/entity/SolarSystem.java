package com.example.spacetrader.entity;


import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * This class represents the solar system
 */
public class SolarSystem {
    private final String name;
    private final TechLevel techLev;
    private final Resource resourceType;
    private final int xCoordinate;
    private final int yCoordinate;
    private final List<Planet> planet;
    private RandomSolarEvent solar;
    private Map<Good, Integer> buyGood;
    private Map<Good, Integer> sellGood;
    private Map<Good, Integer> quantityBuy;
    private int startCountdown;

    /**
     * The constructor for the solar system
     * @param name The name of the solar system
     * @param techLev The techLevel of the solar system
     * @param resourceType The resource type of the solar system
     * @param x The x-coordinate of the solar system
     * @param y The y-coordinate of the solar system
     * @param planet The planet in the solar system
     */
    public SolarSystem(String name, TechLevel techLev, Resource resourceType, int x, int y, Planet planet){
        this.name = name;
        this.techLev = techLev;
        this.resourceType = resourceType;
        this.xCoordinate = x;
        this.yCoordinate = y;
        this.planet = new ArrayList<>();
        this.planet.add(planet);
    }

    /**
     * The constructor for solar systems with multiple planets
     * @param name The name of the solar system
     * @param techLev The techLevel of the solar system
     * @param resourceType The resource type of the solar system
     * @param x The x-coordinate of the solar system
     * @param y The y-coordinate of the solar system
     * @param planet The planets in the solar system
     */
    public SolarSystem(String name, TechLevel techLev, Resource resourceType, int x, int y, Collection<Planet> planet){
        this.name = name;
        this.techLev = techLev;
        this.resourceType = resourceType;
        this.xCoordinate = x;
        this.yCoordinate = y;
        this.planet = new ArrayList<>();
        this.planet.addAll(planet);
    }

    /**
     * Gets the x-coordinate of the solar system
     * @return x-coordinate
     */
    public int getXCoordinate() {
        return xCoordinate;
    }

    /**
     * Gets the y-coordinate of the solar system
     * @return y-coordinate
     */
    public int getYCoordinate() {
        return yCoordinate;
    }

    /**
     * Gets the planet(s) in the solar system
     * @return List of planet(s)
     */
    public List<Planet> getPlanet() {
        return planet;
    }

    /**
     * Gets the name of the solar system
     * @return The name
     */
    public String getName() {
        return name;
    }

    /**
     * When you enter a planet this method calculates the goods that the solar system
     * can buy or sell
     * @param traderSkill the amount of skill points the player has for "trader"
     */
    public void onEnter(int traderSkill) {
        /*maps that have goods as keys and prices as values*/
        buyGood = new HashMap<>();
        sellGood = new HashMap<>();
        quantityBuy = new HashMap<>();
        int price;
        Collection<Good> goodsForSale = new ArrayList<>();
        for (Good i: Good.values()) {
            price = i.getBasePrice(techLev);
            price *= (100 - planet.size()) / 100;
            price = i.specialResources(resourceType, price);
            price = i.specialEvent(solar, price);
            price = i.randomizePrice(price);
            if (i.canBuy(techLev)) {
                buyGood.put(i, price);
                if (i.canSell(techLev)) {
                    sellGood.put(i, i.sellPrice(price, traderSkill));
                    if (this.getBuyGoodPrice(i) > 0) {
                        goodsForSale.add(i);
                    }
                }
            }
        }

         // Sets up the quantity that can be bought for each good from a planet/SS

        if (startCountdown == 0) {
            for (Good i: Good.values()) {
                quantityBuy.put(i, i.calculateQuantity(techLev,planet.size(),resourceType,solar));
            }
            startCountdown = Constants.COUNTDOWN.getValue();
        } else {
            startCountdown--;
        }
    }

    /**
     * Sets market price of goods
     * @param good The good
     * @return The price
     */
    public Integer getBuyGoodPrice(Good good) {
        if(buyGood == null) {
            throw new NullPointerException("buy Good is Null");
        }
        return buyGood.getOrDefault(good, -1);
    }

    /**
     * Sets goods to be purchased in the market
     * @return purchasable goods
     */
    public Map<Good, Integer> getBuyGood() {
        return buyGood;
    }

    /**
     * Sets quantity of goods to be allowed for player to purchase in market
     * @return quantity of purchasable goods
     */
    public Map<Good, Integer> getQuantityBuy() {
        return quantityBuy;
    }
    /**
     * Sets quantity of goods to be allowed to sold in market
     * @return goods for sale
     */
    public Map<Good, Integer> getSellGood() {
        return sellGood;
    }

    /**
     * Sets the random event
     * @param solar random event
     */
    public void setRandomEvent(RandomSolarEvent solar) {
        this.solar = solar;
    }

    /**
     * Gets the tech level of solar system
     * @return tech level
     */
    public String getTech() {
        return techLev.getTech();
    }

    /**
     * Gets the resource type of solar system
     * @return resource type
     */
    public String getResource() {
        return resourceType.getResource();
    }

    /**
     * this is a method
     * @param buyGood the map it is setting
     */
    public void setBuyGood(Map<Good, Integer> buyGood) {
        this.buyGood = buyGood;
    }
}
