package com.example.spacetrader.entity;

import java.util.List;

/**
 * This class represents the universe
 */
public class Universe {

    private final String name;
    private final List<SolarSystem> solarSystems;

    /**
     * This is a constructor for universe
     * @param name The name of the universe
     * @param solars The list of solar systems in the universe
     */
    public Universe(String name, List<SolarSystem> solars) {
        this.name = name;

        this.solarSystems = solars;
    }

    /**
     * Gets the list of solar systems in the universe
     * @return list of solar systems
     */
    public List<SolarSystem> getSolarList() {return this.solarSystems;}

    /**
     * Gets a specific solar system at some index
     * @param i index
     * @return solar system at index i
     */
    public SolarSystem getSolarSystem(int i) {
        return solarSystems.get(i);
    }

    /**
     * Gets name of the universe
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the name of a specific solar system at index i
     * @param i index
     * @return name
     */
    public String getSolarSystemName(int i) {
        return solarSystems.get(i).getName();
    }
}
