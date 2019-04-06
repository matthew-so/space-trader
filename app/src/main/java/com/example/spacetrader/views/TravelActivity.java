package com.example.spacetrader.views;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import com.example.spacetrader.R;
import com.example.spacetrader.entity.Player;
import com.example.spacetrader.entity.Ship;
import com.example.spacetrader.entity.SolarSystem;
import com.example.spacetrader.entity.Universe;

import java.util.ArrayList;
import java.util.List;

public class TravelActivity extends AppCompatActivity {

    private Spinner solar_spinner;

    public static Player player;
    private SolarSystem solarSystem;
    private static TextView fuel_textview;
    private static TextView solar_s_textview;
    private static Universe universe;
    private ArrayList<String> validSolarList;
    private List<SolarSystem> allSolarList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        validSolarList = new ArrayList<>();
        // ...
        // Lookup the recycler view in activity layout

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_travel);
        player = ConfigurationActivity.newGame.getPlayer();
        universe = UniverseActivity.universe;
        solarSystem = player.getCurrentSolarSystem();
        fuel_textview = findViewById(R.id.fuel_textview);
        Ship myShip = player.getShipType();
        fuel_textview.setText("fuel "+ myShip.getFuel());
        solar_s_textview = findViewById(R.id.curr_solar_s_textview);

        solar_s_textview.setText("the current ss is " + solarSystem.getName());

        int x2 = player.getCurrentSolarSystem().getxCoor();
        int y2 = player.getCurrentSolarSystem().getyCoor();

        allSolarList = universe.getSolarList();

        for (int i = 0; i < allSolarList.size(); i++) {

            int x1 = allSolarList.get(i).getxCoor();
            int y1 = universe.getSolarSystem(i).getyCoor();
            if ((player.getShipType().getFuel() - Math.hypot(x2-x1, y2-y1)) >= 0){
                validSolarList.add(universe.getSolarSystem(i).getName());
            }

        }

        solar_spinner = findViewById(R.id.solar_s_spinner);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, validSolarList);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        solar_spinner.setAdapter(adapter);

        Button goButton =  findViewById(R.id.go_button);
        goButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //update fuel
                //up
                String newSS = (String) solar_spinner.getSelectedItem();
                int x2 = player.getCurrentSolarSystem().getxCoor();
                int y2 = player.getCurrentSolarSystem().getyCoor();

                for (SolarSystem ss:allSolarList) {
                    //
                    if (ss.getName().equals(newSS) ){
                        //calc
                        int x1 = ss.getxCoor();
                        int y1 = ss.getyCoor();
                        double distance = Math.hypot(x2-x1, y2-y1);
                        player.getShipType().travel((int)distance);
                        player.setCurrentSolarSystem(ss);

                    }
                }


                Intent intent = new Intent(v.getContext(), StartPlayActivity.class);
                startActivity(intent);


            }
        });




    }






}
