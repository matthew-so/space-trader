package com.example.spacetrader.entity;

public class SolarSystem {
    private String name;
    private techLevel techLev;
    private Resources resourceType;
    private int xCoor;
    private int yCoor;
    private Planet planet;


    SolarSystem(String name, techLevel techLev, Resources resourceType, int x, int y, Planet planet){
        this.name = name;
        this.techLev = techLev;
        this.resourceType = resourceType;
        this.xCoor = x;
        this.yCoor = y;
        this.planet = planet;
    }

    public int getxCoor() {
        return xCoor;
    }

    public int getyCoor() {
        return yCoor;
    }

    public Planet getPlanet() {
        return planet;
    }

    public Resources getResourceType(){
        return resourceType;
    }

    public techLevel getTechLev() {
        return techLev;
    }

    public String getName() {
        return name;
    }

}
