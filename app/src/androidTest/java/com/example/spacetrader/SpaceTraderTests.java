package com.example.spacetrader;

import com.example.spacetrader.entity.Constants;
import com.example.spacetrader.entity.Good;
import com.example.spacetrader.entity.Planet;
import com.example.spacetrader.entity.Player;
import com.example.spacetrader.entity.Resource;
import com.example.spacetrader.entity.SolarSystem;
import com.example.spacetrader.entity.TechLevel;
import com.example.spacetrader.entity.Universe;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.CoreMatchers.*;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class SpaceTraderTests {
    //Selling Tests made by Kyser Montalvo
    @Rule
    public Timeout globalTimeout = Timeout.seconds(2);

    private Player regularPlayer;
    private Good notRandomGood;
    private Good differentGood;
    private SolarSystem currentSolarSystem;
    private Universe universe;
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


    @Before
    public void setUp() {

        this.regularPlayer = new Player("Regular Player",4,4,4,4);
        currentSolarSystem = new SolarSystem("Dat Way",TechLevel.FIVE,Resource.EIGHT,Constants.TWENTY,Constants.TWENTY,new Planet("Uranus"));
        regularPlayer.setCurrentSolarSystem(currentSolarSystem);
        notRandomGood = Good.FIREARMS;
        differentGood = Good.FOOD;


        /**
         * instantiate planets
         */
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

        /**
         * Instantiate solar Systems
         */

        SolarSystem milkyWay = new SolarSystem("Milky Way", TechLevel.FIVE, Resource.ONE, 0, 0, Earth);
        SolarSystem rockyWay = new SolarSystem("Rocky Way", TechLevel.FOUR, Resource.THREE, Constants.TWENTY, 10, Mars);
        SolarSystem silkyWay = new SolarSystem("Silky Way", TechLevel.THREE, Resource.EIGHT, Constants.FOURTY, Constants.THIRTY, Saturn);
        SolarSystem almondWay = new SolarSystem("Almond Way", TechLevel.TWO, Resource.SEVEN, Constants.SIXTY, Constants.FIFTY, Mercury);
        SolarSystem crunchyWay = new SolarSystem("Crunchy Way", TechLevel.ONE, Resource.ELEVEN, Constants.EIGHTY, Constants.SEVENTY, Venus);
        SolarSystem saucyWay = new SolarSystem("Saucy Way", TechLevel.SIX, Resource.FOUR, 100, Constants.NINETY, Uranus);
        SolarSystem creamyWay = new SolarSystem("Creamy Way", TechLevel.SEVEN, Resource.NINE, Constants.ONETWENTY, 100, Pluto);
        SolarSystem sourWay = new SolarSystem("Sour Way", TechLevel.ZERO, Resource.TWO, 100, Constants.EIGHTYFIVE, Ares);
        //SolarSystem saltyWay = new SolarSystem("Salty Way", TechLevel.FIVE, Resource.TWELVE, Constants.ONEFOURTY, Constants.SIXTYFIVE, twoPlanets);
        SolarSystem datWay = new SolarSystem("Dat Way", TechLevel.FOUR, Resource.TEN, Constants.ONEFIFTY, Constants.FOURTYFOUR, Vulcan);


        /**
         * Instantiate universe here
         */
        ArrayList<SolarSystem> solarSystemsList = new ArrayList<>();
        solarSystemsList.add(milkyWay);
        solarSystemsList.add(rockyWay);
        solarSystemsList.add(silkyWay);
        //solarSystemsList.add(saltyWay);
        solarSystemsList.add(almondWay);
        solarSystemsList.add(crunchyWay);
        solarSystemsList.add(saucyWay);
        solarSystemsList.add(creamyWay);
        solarSystemsList.add(sourWay);
        solarSystemsList.add(datWay);

        universe = new Universe("Georgia", solarSystemsList);





    }
    @Test
    public void testSellContainsGoodPlayer() {
        notRandomGood.setQuantity(1);
        Collection<Good> goods = regularPlayer.getPlayerGoods();
        goods.add(notRandomGood);
        Assert.assertTrue("Player should be able to sell goods that are in inventory and have quantity > 0", regularPlayer.sell(notRandomGood));
    }

    @Test
    public void testSellNotContainsGoodPlayer() {
        Assert.assertFalse("Player should not be able to sell goods if he or she has none in inventory",regularPlayer.sell(notRandomGood));
    }

    @Test
    public void testSellFakeGoodPlayer() {
        differentGood.setQuantity(1);
        Collection<Good> goods = regularPlayer.getPlayerGoods();
        goods.add(differentGood);
        Assert.assertFalse("Player should not be able to sell good that does not match any of the goods held in inventory",regularPlayer.sell(notRandomGood));
    }

    @Test
    public void testSellZeroQuantity() {
        notRandomGood.setQuantity(0);
        regularPlayer.addToPlayerGoods(notRandomGood);
        Assert.assertFalse("Player should not be able to sell good with quantity of 0",regularPlayer.sell(notRandomGood));
    }

    //can travel to - tested by Evi
    @Test
    public void testCanTravelToNoFuel() {
        regularPlayer.getShipType().setFuel(0);
        //list of valid solar systems should be zero
        ArrayList<String> list = universe.canTravelTo(regularPlayer, currentSolarSystem);
        assertThat(list, hasSize(0));
    }

    @Test
    public void testCanTravelToAll() {
        regularPlayer.getShipType().setFuel(Integer.MAX_VALUE);
        ArrayList<String> list = universe.canTravelTo(regularPlayer, currentSolarSystem);
        List<SolarSystem> all = universe.getSolarList();
        ArrayList<String> allStr;
        allStr = new ArrayList<>();
        for (SolarSystem s : all) {
            allStr.add(s.getName());
        }
        assertThat(list, is(allStr));
    }



}


