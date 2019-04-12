package com.example.spacetrader.views;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.spacetrader.R;
import com.example.spacetrader.entity.Universe;


/**
 * This class represents the universe display screen
 */

public class UniverseActivity extends AppCompatActivity {

    static Universe universe;

    private TextView SolarSystemView0;
    private TextView SolarSystemView1;
    private TextView SolarSystemView2;
    private TextView SolarSystemView3;
    private TextView SolarSystemView4;
    private TextView SolarSystemView5;
    private TextView SolarSystemView6;
    private TextView SolarSystemView7;
    private TextView SolarSystemView8;
    private TextView SolarSystemView9;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_universe);

        instantiateTextViews();
        universe = new Universe();

        SolarSystemView0.setText(universe.toString(0));

        SolarSystemView1.setText(universe.toString(1));

        SolarSystemView2.setText(universe.toString(2));

        SolarSystemView3.setText(universe.toString(3));

        SolarSystemView4.setText(universe.toString(4));

        SolarSystemView5.setText(universe.toString(5));

        SolarSystemView6.setText(universe.toString(6));

        SolarSystemView7.setText(universe.toString(7));

        SolarSystemView8.setText(universe.toString(8));

        SolarSystemView9.setText(universe.toString(9));
    }

    /**
     * The player will start playing the game
     * @param view will be the new view to go to -- @code StartPlayActivity
     */
    public void goToPlayActivity(View view) {
        Intent intent = new Intent(this, StartPlayActivity.class);
        startActivity(intent);
    }

    private void instantiateTextViews() {

        SolarSystemView0 = findViewById(R.id.SolarSystemView0);
        SolarSystemView1 = findViewById(R.id.SolarSystemView1);
        SolarSystemView2 = findViewById(R.id.SolarSystemView2);
        SolarSystemView3 = findViewById(R.id.SolarSystemView3);
        SolarSystemView4 = findViewById(R.id.SolarSystemView4);
        SolarSystemView5 = findViewById(R.id.SolarSystemView5);
        SolarSystemView6 = findViewById(R.id.SolarSystemView6);
        SolarSystemView7 = findViewById(R.id.SolarSystemView7);
        SolarSystemView8 = findViewById(R.id.SolarSystemView8);
        SolarSystemView9 = findViewById(R.id.SolarSystemView9);

    }
}
