package com.example.spacetrader.entity;

import java.util.List;

public class Universe {

    private final String name;
    private final List<SolarSystem> solarSystems;


    public Universe(String name, List<SolarSystem> solars) {
        this.name = name;

        this.solarSystems = solars;
    }

    public List<SolarSystem> getSolarList() {return this.solarSystems;}

    public SolarSystem getSolarSystem(int i) {
        return solarSystems.get(i);
    }

    public String getName() {
        return name;
    }

    public String getSolarSystemName(int i) {
        return solarSystems.get(i).getName();
    }
}
