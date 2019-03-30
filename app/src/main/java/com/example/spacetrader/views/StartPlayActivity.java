package com.example.spacetrader.views;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.example.spacetrader.entity.*;
import com.example.spacetrader.model.Game;
import com.example.spacetrader.R;

public class StartPlayActivity extends AppCompatActivity {

    public static final Game game = ConfigurationActivity.newGame;
    public static Player player;

    public static int count;
    private TextView planet_textView;
    private TextView universe_textView;
    private TextView randomEventTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_play);

        //player = PlayerIntroActivity.player;


        Universe universe = UniverseActivity.universe;
        SolarSystem currentSolarSystem;


        if(count == 0) {
            currentSolarSystem = universe.getSolarSystem(0);
            player = PlayerIntroActivity.player;
            //player.setCurrentSolarSystem(currentSolarSystem);
            count++;

        } else {
            player = TravelActivity.player;
            currentSolarSystem = player.getCurrentSolarSystem();

        }

        player.setCurrentSolarSystem(currentSolarSystem);
        //String solarSystemName = currentSolarSystem.getName();
        String planetName = currentSolarSystem.getPlanet().get(0).getName();
        //player.setCurrentSolarSystem(currentSolarSystem);
        planet_textView = findViewById(R.id.planet_textView);
        universe_textView = findViewById(R.id.universe_textView);
        RandomSolarEvent solarEvent = currentSolarSystem.getSolar();
        randomEventTextView = findViewById(R.id.randomEventTextView);


        String solarSystemName = currentSolarSystem.getName();
        //////////////

        planet_textView.setText("Planet: "+ planetName);
        universe_textView.setText("Solar System: " + solarSystemName);
        solarEvent = RandomSolarEvent.getRandomSolarEvent();
        currentSolarSystem.setRandomEvent(solarEvent);
        if (solarEvent != null) {
            randomEventTextView.setText("Random Event: " + solarEvent.toString());
        }

    }
    public void goToMarketActivity(View view) {
        Intent intent = new Intent(this, MarketplaceActivity.class);
        startActivity(intent);
    }
    public void goToTravelActivity(View view) {
        Intent intent = new Intent(this, TravelActivity.class);
        startActivity(intent);
    }




}
