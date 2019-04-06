package com.example.spacetrader.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * This class represents the universe
 */
public class Universe {


    private List<SolarSystem> solarSystemsList;

    private SolarSystem milkyWay;
    private SolarSystem rockyWay;
    private SolarSystem silkyWay;
    private SolarSystem almondWay;
    private SolarSystem crunchyWay;
    private SolarSystem saucyWay;
    private SolarSystem creamyWay;
    private SolarSystem sourWay;
    private SolarSystem saltyWay;
    private SolarSystem datWay;

    /**
     * The Universe constructor creates the universe
     */
    public Universe() {

        this.makeSolarSystems();

        solarSystemsList.add(milkyWay);
        solarSystemsList.add(rockyWay);
        solarSystemsList.add(silkyWay);
        solarSystemsList.add(saltyWay);
        solarSystemsList.add(almondWay);
        solarSystemsList.add(crunchyWay);
        solarSystemsList.add(saucyWay);
        solarSystemsList.add(creamyWay);
        solarSystemsList.add(sourWay);
        solarSystemsList.add(datWay);
    }

    /**
     * Gets the list of solar systems in the universe
     * @return list of solar systems
     */
    public List<SolarSystem> getSolarList() {return this.solarSystemsList;}
    /**
     * Gets a specific solar system at some index
     * @param i index
     * @return solar system at index i
     */
    public SolarSystem getSolarSystem(int i) {
        return solarSystemsList.get(i);
    }

    /**
     * Gets the name of a specific solar system at index i
     * @param i index
     * @return name
     */
    public String getSolarSystemName(int i) {
        return solarSystemsList.get(i).getName();
    }

    /**
     * Print the solar system and its attributes as a string
     * @param index the position
     * @return string
     */
    public String toString(int index) {
        return "Solar system: " + solarSystemsList.get(index).getName() + " Tech Level: " +
                solarSystemsList.get(index).getTech()
                + " Resource Level: " + solarSystemsList.get(index).getResource() + " Coordinates: " +
                "("+solarSystemsList.get(index).getXCoordinate() + "," +
                solarSystemsList.get(index).getYCoordinate()+")";
    }

    private void makeSolarSystems() {
        Planet Earth;
        Planet Mars;
        Planet Saturn;
        Planet Mercury;
        Planet Venus;
        Planet Uranus;
        Planet Pluto;
        Planet Ares;
        Planet Jello;
        Planet Vulcan;
        Planet Swirl;

        Saturn = new Planet("Saturn");
        Mars = new Planet("Mars");
        Earth = new Planet("Earth");
        Mercury = new Planet("Mercury");
        Uranus = new Planet("Uranus");
        Venus = new Planet("Venus");
        Pluto = new Planet("Pluto");
        Ares = new Planet("Ares");
        Vulcan = new Planet("Vulcan");
        Jello = new Planet("Jello");
        Swirl = new Planet("Swirl");
        ArrayList<Planet> twoPlanets = new ArrayList<>();
        twoPlanets.add(Jello);
        twoPlanets.add(Swirl);

        solarSystemsList = new ArrayList<>();
         milkyWay = new SolarSystem("Milky Way", TechLevel.FIVE, Resource.ONE, 0, 0, Earth);
         rockyWay = new SolarSystem("Rocky Way", TechLevel.FOUR, Resource.THREE, Constants.TWENTY, 10, Mars);
         silkyWay = new SolarSystem("Silky Way", TechLevel.THREE, Resource.EIGHT, Constants.FOURTY, Constants.THIRTY, Saturn);
         almondWay = new SolarSystem("Almond Way", TechLevel.TWO, Resource.SEVEN, Constants.SIXTY, Constants.FIFTY, Mercury);
         crunchyWay = new SolarSystem("Crunchy Way", TechLevel.ONE, Resource.ELEVEN, Constants.EIGHTY, Constants.SEVENTY, Venus);
         saucyWay = new SolarSystem("Saucy Way", TechLevel.SIX, Resource.FOUR, 100, Constants.NINETY, Uranus);
         creamyWay = new SolarSystem("Creamy Way", TechLevel.SEVEN, Resource.NINE, Constants.ONETWENTY, 100, Pluto);
         sourWay = new SolarSystem("Sour Way", TechLevel.ZERO, Resource.TWO, 100, Constants.EIGHTYFIVE, Ares);
         saltyWay = new SolarSystem("Salty Way", TechLevel.FIVE, Resource.TWELVE, Constants.ONEFOURTY, Constants.SIXTYFIVE, twoPlanets);
         datWay = new SolarSystem("Dat Way", TechLevel.FOUR, Resource.TEN, Constants.ONEFIFTY, Constants.FOURTYFOUR, Vulcan);
    }
}
