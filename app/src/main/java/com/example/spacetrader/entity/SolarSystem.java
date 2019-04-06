package com.example.spacetrader.entity;


import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SolarSystem {
    private final String name;
    private final TechLevel techLev;
    private final Resource resourceType;
    private final int xCoor;
    private final int yCoor;
    private final List<Planet> planet;
    private RandomSolarEvent solar;
    private Map<Good, Integer> buyGood;
    private Map<Good, Integer> sellGood;
    private Map<Good, Integer> quantityBuy;
    private ArrayList<Good> goodsForSale;
    private int startcountdown;

    public SolarSystem(String name, TechLevel techLev, Resource resourceType, int x, int y, Planet planet){
        this.name = name;
        this.techLev = techLev;
        this.resourceType = resourceType;
        this.xCoor = x;
        this.yCoor = y;
        this.planet = new ArrayList<>();
        this.planet.add(planet);
    }


    public SolarSystem(String name, TechLevel techLev, Resource resourceType, int x, int y, Collection<Planet> planet){
        this.name = name;
        this.techLev = techLev;
        this.resourceType = resourceType;
        this.xCoor = x;
        this.yCoor = y;
        this.planet = new ArrayList<>();
        this.planet.addAll(planet);
    }

    public int getxCoor() {
        return xCoor;
    }

    public int getyCoor() {
        return yCoor;
    }

    public List<Planet> getPlanet() {
        return planet;
    }

    public Resource getResourceType(){
        return resourceType;
    }

    public TechLevel getTechLev() {
        return techLev;
    }

    public String getName() {
        return name;
    }

    /**
     * when you enter a planet this method calculates the goods that the solarsystem
     * can buy or sell
     * @param traderskill the amount of skill points the player has for "trader"
     */
    public void onEnter(int traderskill) {
        /*maps that have goods as keys and prices as values*/
        buyGood = new HashMap<>();
        sellGood = new HashMap<>();
        quantityBuy = new HashMap<>();
        int price;
        int quantity;
        goodsForSale = new ArrayList<>();
        for (Good i: Good.values()) {
            price = i.getBasePrice(techLev);
            price *= (100 - planet.size()) / 100;
            price = i.specialResources(resourceType, price);
            price = i.specialEvent(solar, price);
            price = i.randomizePrice(price);
            if (i.canBuy(techLev)) {
                buyGood.put(i, price);
                if (i.canSell(techLev)) {
                    sellGood.put(i, i.sellPrice(price, traderskill));
                    if (this.getBuyGoodPrice(i) > 0) {
                        goodsForSale.add(i);
                    }
                }
            }
        }
        /**
         * Sets up the quantity that can be bought for each good from a planet/SS
         */
        if (startcountdown == 0) {
            for (Good i: Good.values()) {
                quantityBuy.put(i, i.calculateQuantity(techLev,planet.size(),resourceType,solar));
            }
            startcountdown = Constants.COUNTDOWN;
        } else {
            startcountdown--;
        }
    }

    public RandomSolarEvent getSolar() {
        return solar;
    }


    /** use these to set market price*/
    public Integer getBuyGoodPrice(Good good) {
        return buyGood.getOrDefault(good, -1);
    }

    public Integer getSellGoodPrice(Good good) {
        return sellGood.getOrDefault(good, -1);
    }

    public Integer getSellGoodQuantity(Good good) {
        return quantityBuy.getOrDefault(good, good.getQuantity());
    }

    public Map<Good, Integer> getBuyGood() {
        return buyGood;
    }

    public Map<Good, Integer> getQuantityBuy() {
        return quantityBuy;
    }

    public Map<Good, Integer> getSellGood() {
        return sellGood;
    }

    public int getStartcountdown() {
        return startcountdown;
    }

    public ArrayList<Good> getGoodsForSale() {
        return goodsForSale;
    }

    public void setQuantityBuy(Map<Good, Integer> quantityBuy) {
        this.quantityBuy = quantityBuy;
    }

    public void setRandomEvent(RandomSolarEvent solar) {
        this.solar = solar;
    }
}
