package com.example.spacetrader.entity;

import java.util.ArrayList;

public class Universe {

    private String name;
    private ArrayList<SolarSystem> solarSystems;

    private Planet Earth;
    private Planet Mars;
    private Planet Saturn;
    private Planet Mercury;
    private Planet Venus;
    private Planet Uranus;
    private Planet Pluto;
    private Planet Ares;
    private Planet Gelo;
    private Planet Vulcan;
    private Planet Swirl;

    public Universe(String name, ArrayList<SolarSystem> solars) {
        this.name = name;
        Saturn = new Planet("Saturn");
        Mars = new Planet("Mars");
        Earth = new Planet("Earth");
        Mercury = new Planet("Mercury");
        Uranus = new Planet("Uranus");
        Venus = new Planet("Venus");
        Pluto = new Planet("Pluto");
        Ares = new Planet("Ares");
        Vulcan = new Planet("Vulcan");
        Gelo = new Planet("Gelo");
        Swirl = new Planet("Swirl");
        this.solarSystems = populateUniverse(solars);
    }

    private ArrayList<SolarSystem> populateUniverse(ArrayList<SolarSystem> solarSystemsList) {
        SolarSystem milkyWay = new SolarSystem("Milky Way", techLevel.FIVE, Resources.ONE, 0, 0, Earth);
        SolarSystem rockyWay = new SolarSystem("Rocky Way", techLevel.FOUR, Resources.THREE, 20, 10, Mars);
        SolarSystem silkyWay = new SolarSystem("Silky Way", techLevel.THREE, Resources.EIGHT, 40, 30, Saturn);
        SolarSystem almondWay = new SolarSystem("Almond Way", techLevel.TWO, Resources.SEVEN, 60, 50, Mercury);
        SolarSystem crunchyWay = new SolarSystem("Crunchy Way", techLevel.ONE, Resources.ELEVEN, 80, 70, Venus);
        SolarSystem saucyWay = new SolarSystem("Saucy Way", techLevel.SIX, Resources.FOUR, 100, 90, Uranus);
        SolarSystem creamyWay = new SolarSystem("Creamy Way", techLevel.SEVEN, Resources.NINE, 120, 100, Pluto);
        SolarSystem sourWay = new SolarSystem("Sour Way", techLevel.ZERO, Resources.TWO, 100, 85, Ares);
        SolarSystem saltyWay = new SolarSystem("Salty Way", techLevel.FIVE, Resources.TWELVE, 140, 65, Gelo);
        SolarSystem theWay = new SolarSystem("The Way", techLevel.FOUR, Resources.TEN, 150, 44, Vulcan);
        SolarSystem vanillaWay = new SolarSystem("Vanilla Way",techLevel.TWO,Resources.EIGHT, 70,70,Swirl);

        solarSystemsList.add(milkyWay);
        solarSystemsList.add(rockyWay);
        solarSystemsList.add(silkyWay);
        solarSystemsList.add(saltyWay);
        solarSystemsList.add(almondWay);
        solarSystemsList.add(crunchyWay);
        solarSystemsList.add(saucyWay);
        solarSystemsList.add(creamyWay);
        solarSystemsList.add(sourWay);
        solarSystemsList.add(theWay);
        solarSystemsList.add(vanillaWay);

        return solarSystemsList;
    }


    public SolarSystem getSolarSystem(int i) {
        return solarSystems.get(i);
    }

}
