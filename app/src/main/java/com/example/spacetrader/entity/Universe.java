package com.example.spacetrader.entity;

import java.util.ArrayList;
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

    public ArrayList<String> canTravelTo(Player player, SolarSystem ss) {
        ArrayList<String> validSolarList;
        validSolarList = new ArrayList<>();
        int x1 = ss.getxCoor();
        int y1 = ss.getyCoor();
        for (int i = 0; i < this.solarSystems.size(); i++) {
            SolarSystem otherSS = this.solarSystems.get(i);
            int x2 = otherSS.getxCoor();
            int y2 = otherSS.getyCoor();
            if ((player.getShipType().getFuel() - Math.hypot(x2-x1, y2-y1)) >= 0) {
                validSolarList.add(solarSystems.get(i).getName());

            }
        }
        return validSolarList;
    }





}
