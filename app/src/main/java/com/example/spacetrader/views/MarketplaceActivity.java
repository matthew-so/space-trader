package com.example.spacetrader.views;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;
import com.example.spacetrader.R;
import com.example.spacetrader.entity.Good;
import com.example.spacetrader.entity.Player;
import com.example.spacetrader.entity.SolarSystem;
import com.example.spacetrader.viewmodels.GoodsAdapter;
import com.example.spacetrader.viewmodels.PlayerGoodsAdapter;

import java.util.ArrayList;
import java.util.Map;
import java.util.Set;

public class MarketplaceActivity extends AppCompatActivity {

    /**
     * The maps contain the goods and they're respective prices
     * But since maps cannot go into a recycler view, the keys will be put in ArrayLists
     */
    public static Map<Good,Integer> mapOfPlanetGoods;
    public static ArrayList<Good> planetGoods;
    public static Map<Good,Integer> mapOfSellableGoods;
    public static ArrayList<Good> playerGoods;

    /**
     * These adapters are made static so when a button is pressed in @code GoodsAdapter,
     * GoodsAdapter can notify playerAdapter to update via this class
     */
    public static GoodsAdapter adapter;
    public static PlayerGoodsAdapter playerAdapter;

    //public Player player;
    public static Player player;
    public SolarSystem solarSystem;
    public static TextView credits_TextView;






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // ...
        // Lookup the recycler view in activity layout
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_marketplace);

        player = ConfigurationActivity.newGame.getPlayer();
        solarSystem = player.getCurrentSolarSystem();
        solarSystem.onEnter(player.getTrader());


        /**
         * These two recycler views are sideby side inside of MarketPlaceActivity
         */
        RecyclerView rvContacts = (RecyclerView) findViewById(R.id.rvContacts);
        RecyclerView playerGoodsRV = (RecyclerView) findViewById(R.id.playerGoodsRV);


        credits_TextView= (TextView) findViewById(R.id.credits_TextView);

        /**
         * We will be updating the cargo capacity and credits in real time,
         * showing them to the player as he or she buys/sells
         */
        credits_TextView.setText("$"+player.getCredits() + "\n" + "Capacity: " + player.getInventorySpace());

        // Initialize goods for player and planet

        mapOfPlanetGoods = solarSystem.getBuyGood();
        mapOfSellableGoods = solarSystem.getSellGood();
        Set<Good> planetGoodsSet = mapOfPlanetGoods.keySet();
        /**
         * The player's goods start off as empty in the very beginning
         */
        planetGoods = new ArrayList<>();
        playerGoods = player.getPlayerGoods();

        /**
         * Assigning the price to each good.
         * Note: price is an instance variable in the @code Good class
         */
        for(Good g:playerGoods) {
            if (!mapOfSellableGoods.isEmpty()
                    &&solarSystem.getBuyGoodPrice(g) > 0 && !playerGoods.isEmpty()) {
                g.setPrice(mapOfSellableGoods.get(g));
            }
        }
        for(Good g:planetGoodsSet) {
            if (solarSystem.getBuyGoodPrice(g) > 0) {
                planetGoods.add(g);
                g.setPrice(mapOfPlanetGoods.get(g));
            }
        }






        //sample goods



        // Create adapter passing in the sample user data
        adapter = new GoodsAdapter(planetGoods);
        playerAdapter = new PlayerGoodsAdapter(playerGoods);




        // Attach the adapter to the recycler view to populate items
        rvContacts.setAdapter(adapter);
        playerGoodsRV.setAdapter(playerAdapter);



        // Set layout manager to position the items
        rvContacts.setLayoutManager(new LinearLayoutManager(this));
        playerGoodsRV.setLayoutManager(new LinearLayoutManager(this));
        



    }


}
