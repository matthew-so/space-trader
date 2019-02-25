package com.example.spacetrader.entity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SolarSystem {
    private String name;
    private TechLevel techLev;
    private Resource resourceType;
    private int xCoor;
    private int yCoor;
    private List<Planet> planet;
    private RandomSolarEvent solar;
    private Map<Good, Integer> buyGood;
    private Map<Good, Integer> sellGood;

    SolarSystem(String name, TechLevel techLev, Resource resourceType, int x, int y, List<String> planet){
        this.name = name;
        this.techLev = techLev;
        this.resourceType = resourceType;
        this.xCoor = x;
        this.yCoor = y;
        this.planet = new ArrayList<Planet>();
        for (String str: planet) {
            this.planet.add(new Planet(str, techLev, resourceType));
        }
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

    public void onEnter(int traderskill) {
        buyGood = new HashMap<Good, Integer>();
        sellGood = new HashMap<Good, Integer>();
        int price;
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
                }
            }
        }

    }

    public RandomSolarEvent getSolar() {
        return solar;
    }

    public Map<Good, Integer> getBuyGood() {
        return buyGood;
    }

    public Map<Good, Integer> getSellGood() {
        return sellGood;
    }
}