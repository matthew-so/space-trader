package com.example.spacetrader.entity;

import java.util.ArrayList;

public class SolarSystem {
    private String name;
    private techLevel techLev;
    private Resources resourceType;
    private int xCoor;
    private int yCoor;
    private ArrayList<Planet> planet;
    private Planet planetOne;


    public SolarSystem(String name, techLevel techLev, Resources resourceType, int x, int y, ArrayList<Planet> planet){
        this.name = name;
        this.techLev = techLev;
        this.resourceType = resourceType;
        this.xCoor = x;
        this.yCoor = y;
        this.planet = planet;
    }

    public SolarSystem(String name, techLevel techLev, Resources resourceType, int x, int y, Planet planetOne){
        this.name = name;
        this.techLev = techLev;
        this.resourceType = resourceType;
        this.xCoor = x;
        this.yCoor = y;
        this.planetOne = planetOne;
    }

    public int getxCoor() {
        return xCoor;
    }

    public int getyCoor() {
        return yCoor;
    }

    public ArrayList<Planet> getPlanet() {
        return planet;
    }

    public Planet getPlanetOne() {
        return planetOne;
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
