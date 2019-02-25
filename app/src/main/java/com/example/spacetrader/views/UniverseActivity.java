package com.example.spacetrader.views;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import com.example.spacetrader.entity.Universe;
import com.example.spacetrader.R;


public class UniverseActivity extends AppCompatActivity {
    /**
     * Text views for each solarsystem generated
     */
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
    private TextView SolarSystemView10;
    private Universe universe;






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_universe);

        /**
         * finding text views in the activity and binding them to the textviews in the code
         */
        SolarSystemView0 = (TextView) findViewById(R.id.SolarSystemView0);
        SolarSystemView1 = (TextView) findViewById(R.id.SolarSystemView1);
        SolarSystemView2 = (TextView) findViewById(R.id.SolarSystemView2);
        SolarSystemView3 = (TextView) findViewById(R.id.SolarSystemView3);
        SolarSystemView4 = (TextView) findViewById(R.id.SolarSystemView4);
        SolarSystemView5 = (TextView) findViewById(R.id.SolarSystemView5);
        SolarSystemView6 = (TextView) findViewById(R.id.SolarSystemView6);
        SolarSystemView7 = (TextView) findViewById(R.id.SolarSystemView7);
        SolarSystemView8 = (TextView) findViewById(R.id.SolarSystemView8);
        SolarSystemView9 = (TextView) findViewById(R.id.SolarSystemView9);
        SolarSystemView10 = (TextView) findViewById(R.id.SolarSystemView10);


        /**
         * Instantiate universe here
         */

        /**
         *Having each text view display a solar system and description
         */

        SolarSystemView0.setText();

    }
}
