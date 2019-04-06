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
import com.example.spacetrader.entity.SolarSystem;
import com.example.spacetrader.entity.Universe;

import java.util.ArrayList;
import java.util.List;

/**
 * This class represents the travel screen
 */
public class TravelActivity extends AppCompatActivity {

    private Spinner solar_spinner;
    static Player player;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        SolarSystem solarSystem;
        TextView fuel_textView;
        TextView solar_s_textView;
        Universe universe;
        ArrayList<String> validSolarList;
        final List<SolarSystem> allSolarList;
        validSolarList = new ArrayList<>();
        // ...
        // Lookup the recycler view in activity layout
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_travel);
        player = ConfigurationActivity.newGame.getPlayer();
        universe = UniverseActivity.universe;
        solarSystem = player.getCurrentSolarSystem();
        fuel_textView = findViewById(R.id.fuel_textview);
        fuel_textView.setText("Fuel: "+ player.getShipFuel());
        solar_s_textView = findViewById(R.id.curr_solar_s_textview);
        solar_s_textView.setText("Current Solar System: " + player.getSolarSystemName());
        int x2 = player.getXCoordinate();
        int y2 = player.getYCoordinate();
        allSolarList = universe.getSolarList();
        for (int i = 0; i < allSolarList.size(); i++) {
            SolarSystem ss = allSolarList.get(i);
            int x1 = ss.getXCoordinate();
            ss = universe.getSolarSystem(i);
            int y1 = ss.getYCoordinate();
            if ((player.getShipFuel() - Math.hypot(x2-x1, y2-y1)) >= 0){
                validSolarList.add(universe.getSolarSystemName(i));
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
                int x2 = player.getXCoordinate();
                int y2 = player.getYCoordinate();

                for (SolarSystem ss:allSolarList) {
                    //
                    if (ss.getName().equals(newSS) ){
                        //calc
                        int x1 = ss.getXCoordinate();
                        int y1 = ss.getYCoordinate();
                        double distance = Math.hypot(x2-x1, y2-y1);
                        player.travel((int)distance);
                        player.setCurrentSolarSystem(ss);

                    }
                }


                Intent intent = new Intent(v.getContext(), StartPlayActivity.class);
                startActivity(intent);


            }
        });




    }






}
