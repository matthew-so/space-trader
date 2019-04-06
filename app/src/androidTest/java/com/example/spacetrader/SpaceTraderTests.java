package com.example.spacetrader;

import com.example.spacetrader.entity.Constants;
import com.example.spacetrader.entity.Good;
import com.example.spacetrader.entity.Planet;
import com.example.spacetrader.entity.Player;
import com.example.spacetrader.entity.Resource;
import com.example.spacetrader.entity.SolarSystem;
import com.example.spacetrader.entity.TechLevel;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

import java.util.Collection;

/**
 * This class is for testing methods in the application
 */

@SuppressWarnings("SpellCheckingInspection")
public class SpaceTraderTests {
    //Selling Tests made by Kyser Montalvo
    @Rule
    public Timeout globalTimeout = Timeout.seconds(2);

    private Player regularPlayer;
    private Good notRandomGood;
    private Good differentGood;

    /**Sets up player*/
    @Before
    public void setUp() {
        SolarSystem currentSolarSystem;
        this.regularPlayer = new Player("Regular Player",4,4,4,4);
        currentSolarSystem = new SolarSystem("Dat Way",TechLevel.FIVE,Resource.EIGHT,Constants.TWENTY,Constants.TWENTY,new Planet("Uranus"));
        regularPlayer.setCurrentSolarSystem(currentSolarSystem);
        notRandomGood = Good.FIREARMS;
        differentGood = Good.FOOD;

    }
    /**Tests player's ability to sell goods*/
    @Test
    public void testSellContainsGoodPlayer() {
        notRandomGood.setQuantity(1);
        Collection<Good> goods = regularPlayer.getPlayerGoods();
        goods.add(notRandomGood);
        Assert.assertTrue("Player should be able to sell goods that are in inventory and have quantity > 0", regularPlayer.sell(notRandomGood));
    }

    /** Tests player's ability to sell goods they do not have*/
    @Test
    public void testSellNotContainsGoodPlayer() {
        Assert.assertFalse("Player should not be able to sell goods if he or she has none in inventory",regularPlayer.sell(notRandomGood));
    }

    /**Tests players ability to sell goods they do not have*/
    @Test
    public void testSellFakeGoodPlayer() {
        differentGood.setQuantity(1);
        Collection<Good> goods = regularPlayer.getPlayerGoods();
        goods.add(differentGood);
        Assert.assertFalse("Player should not be able to sell good that does not match any of the goods held in inventory",regularPlayer.sell(notRandomGood));
    }

    /** This tests the player's ability to sell 0 items*/
    @Test
    public void testSellZeroQuantity() {
        notRandomGood.setQuantity(0);
        regularPlayer.addToPlayerGoods(notRandomGood);
        Assert.assertFalse("Player should not be able to sell good with quantity of 0",regularPlayer.sell(notRandomGood));
    }



}


