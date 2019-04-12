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

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * This class is for testing methods in the application
 */

@SuppressWarnings("SpellCheckingInspection")
public class SpaceTraderTests {

    @Rule
    public final Timeout globalTimeout = Timeout.seconds(2);

    private Player regularPlayer;
    private Good notRandomGood;
    private Good differentGood;

    /**Sets up player*/
    @Before
    public void setUp() {
        SolarSystem currentSolarSystem;
        this.regularPlayer = new Player("Regular Player",4,4,4,4);
        Universe myUniverse = new Universe();
        regularPlayer.setCurrentSolarSystem(myUniverse.getSolarSystem(0));
        notRandomGood = Good.FIREARMS;
        differentGood = Good.FOOD;
        Map<Good, Integer> myMap = new HashMap<>();
        myMap.put(notRandomGood,4);
        regularPlayer.getCurrentSolarSystem().setBuyGood(myMap);

    }
    //Selling Tests made by Kyser Montalvo
    /**Tests player's ability to sell goods*/
    @Test
    public void testSellContainsGoodPlayer() {
        notRandomGood.setQuantity(1);
        Collection<Good> goods = regularPlayer.getPlayerGoods();
        goods.add(notRandomGood);
        Assert.assertTrue("Player should be able to sell goods " +
                "that are in inventory and have quantity > 0", regularPlayer.sell(notRandomGood));
    }

    /** Tests player's ability to sell goods when inventory is empty*/
    @Test
    public void testSellNotContainsGoodPlayer() {
        Assert.assertFalse("Player should not be able " +
                "to sell goods if he or she has none in inventory",regularPlayer.sell(notRandomGood));
    }

    /**Tests players ability to sell goods they do not have in inventory*/
    @Test
    public void testSellFakeGoodPlayer() {
        differentGood.setQuantity(1);
        Collection<Good> goods = regularPlayer.getPlayerGoods();
        goods.add(differentGood);
        Assert.assertFalse("Player should not be able to sell " +
                "good that does not match any of the goods held in inventory",regularPlayer.sell(notRandomGood));
    }

    /** This tests the player's ability to sell 0 items*/
    @Test
    public void testSellZeroQuantity() {
        notRandomGood.setQuantity(0);
        regularPlayer.addToPlayerGoods(notRandomGood);
        Assert.assertFalse("Player should not be able to " +
                "sell good with quantity of 0",regularPlayer.sell(notRandomGood));
    }

    //Buying Tests made by Fanuel Abiy

    /**Tests player's ability to buy goods*/
    @Test
    public void testBuyContainsGoodPlayer() {

        notRandomGood.setQuantity(1);
        Collection<Good> goods = regularPlayer.getPlayerGoods();
        goods.add(notRandomGood);
        Assert.assertTrue("Player should be able to buy goods " +
                "that are in inventory " +
                "and have quantity > 0", regularPlayer.buy(notRandomGood));
    }
    @Test
    public void testBuyFakeGoodPlayer() {
        differentGood.setQuantity(1);
        Collection<Good> goods = regularPlayer.getPlayerGoods();
        goods.add(differentGood);
        Assert.assertFalse("Player should not be able to buy good that does not match any of the goods held in inventory",regularPlayer.buy(notRandomGood));
    }

    /** Tests player's ability to buy goods when inventory is empty*/
    @Test
    public void testBuyNotContainsGoodPlayer() {
        Assert.assertTrue("Player should be able to buy goods if he or she has none in inventory",regularPlayer.buy(notRandomGood));
    }

    /**Tests players ability to buy goods they do not already have*/
    @Test
    public void testBuyNewGoodPlayer() {
        differentGood.setQuantity(1);
        Collection<Good> goods = regularPlayer.getPlayerGoods();
        goods.add(differentGood);
        Assert.assertTrue("Player should be able to buy " +
                "good that does not match " +
                "any of the goods held in inventory",regularPlayer.buy(notRandomGood));
    }

    /** This tests the player's ability to buy while holding 15 items*/
    @Test
    public void testMaxPlayerInventory() {
        notRandomGood.setQuantity(1);
        regularPlayer.addToPlayerGoods(notRandomGood);
        regularPlayer.buy(notRandomGood);
        Assert.assertFalse("Player should not be able " +
                "to buy good with max inventory",regularPlayer.getPlayerGoods().size() >= 15);
    }


}


