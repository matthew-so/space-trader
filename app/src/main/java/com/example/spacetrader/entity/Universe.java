package com.example.spacetrader.entity;

import java.util.ArrayList;

public class Universe {

    private String name;
    private ArrayList<SolarSystem> solarSystems;


    public Universe(String name, ArrayList<SolarSystem> solars) {
        this.name = name;

        this.solarSystems = solars;
    }




    public SolarSystem getSolarSystem(int i) {
        return solarSystems.get(i);
    }

}
