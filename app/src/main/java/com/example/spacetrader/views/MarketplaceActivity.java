package com.example.spacetrader.views;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.example.spacetrader.R;
import com.example.spacetrader.entity.Good;
import com.example.spacetrader.entity.Player;
import com.example.spacetrader.entity.SolarSystem;
import com.example.spacetrader.viewmodels.GoodsAdapter;
import com.example.spacetrader.viewmodels.PlayerGoodsAdapter;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class MarketplaceActivity extends AppCompatActivity {

    Map<Good,Integer> mapOfPlanetGoods;
    ArrayList<Good> planetGoods;
    Map<Good,Integer> mapOfPlayerGoods;
    ArrayList<Good> playerGoods;


    public Player player;
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


        RecyclerView rvContacts = (RecyclerView) findViewById(R.id.rvContacts);
        RecyclerView playerGoodsRV = (RecyclerView) findViewById(R.id.playerGoodsRV);


        credits_TextView= (TextView) findViewById(R.id.credits_TextView);

        credits_TextView.setText("$"+player.getCredits() + "\n" + "Capacity: " + player.getInventorySpace());

        // Initialize goods for player and planet

        mapOfPlanetGoods = solarSystem.getBuyGood();
        mapOfPlayerGoods = solarSystem.getSellGood();
        Set<Good> planetGoodsSet = mapOfPlanetGoods.keySet();
        Set<Good> playerGoodsSet = mapOfPlayerGoods.keySet();
        planetGoods = new ArrayList<>();
        playerGoods = new ArrayList<>();

        for(Good g:playerGoodsSet) {
            if (solarSystem.getBuyGoodPrice(g) > 0) {
                playerGoods.add(g);
                g.setQuantity(mapOfPlayerGoods.get(g));
            }
        }
        for(Good g:planetGoodsSet) {
            if (solarSystem.getBuyGoodPrice(g) > 0) {
                planetGoods.add(g);
                g.setQuantity(mapOfPlanetGoods.get(g));
            }
        }






        //sample goods



        // Create adapter passing in the sample user data
        GoodsAdapter adapter = new GoodsAdapter(planetGoods);
        PlayerGoodsAdapter playerAdapter = new PlayerGoodsAdapter(playerGoods);




        // Attach the adapter to the recycler view to populate items
        rvContacts.setAdapter(adapter);
        playerGoodsRV.setAdapter(playerAdapter);



        // Set layout manager to position the items
        rvContacts.setLayoutManager(new LinearLayoutManager(this));
        playerGoodsRV.setLayoutManager(new LinearLayoutManager(this));
        // That's all!



    }


}