package com.example.spacetrader.views;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.widget.LinearLayout;
import com.example.spacetrader.R;
import com.example.spacetrader.entity.Good;
import com.example.spacetrader.viewmodels.GoodsAdapter;
import com.example.spacetrader.viewmodels.PlayerGoodsAdapter;

import java.util.ArrayList;

public class MarketplaceActivity extends AppCompatActivity {

    ArrayList<Good> planetGoods;
    ArrayList<Good> playerGoods;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // ...
        // Lookup the recycler view in activity layout
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_marketplace);

        RecyclerView rvContacts = (RecyclerView) findViewById(R.id.rvContacts);
        RecyclerView playerGoodsRV = (RecyclerView) findViewById(R.id.playerGoodsRV);


        // Initialize goods for player and planet

        planetGoods = new ArrayList<>();
        playerGoods = new ArrayList<>();

        //sample goods
        planetGoods.add(Good.FOOD);
        planetGoods.add(Good.FIREARMS);

        playerGoods.add(Good.FURS);
        playerGoods.add(Good.GAMES);

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
