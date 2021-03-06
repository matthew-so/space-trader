package com.example.spacetrader.views;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.spacetrader.R;
import com.example.spacetrader.entity.Constants;
import com.example.spacetrader.entity.Planet;
import com.example.spacetrader.entity.Resource;
import com.example.spacetrader.entity.SolarSystem;
import com.example.spacetrader.entity.TechLevel;
import com.example.spacetrader.entity.Universe;


import java.util.ArrayList;


public class UniverseActivity extends AppCompatActivity {

    //TODO: Put all this creation stuff in universe constructor and just call constructor with no params
    /**
     * planets
     */
    private Planet Earth;
    private Planet Mars;
    private Planet Saturn;
    private Planet Mercury;
    private Planet Venus;
    private Planet Uranus;
    private Planet Pluto;
    private Planet Ares;
    private Planet Gelo;
    private Planet Vulcan;
    private Planet Swirl;

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
    public static Universe universe;






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_universe);

        /**
         * instantiate planets
         */
        Saturn = new Planet("Saturn");
        Mars = new Planet("Mars");
        Earth = new Planet("Earth");
        Mercury = new Planet("Mercury");
        Uranus = new Planet("Uranus");
        Venus = new Planet("Venus");
        Pluto = new Planet("Pluto");
        Ares = new Planet("Ares");
        Vulcan = new Planet("Vulcan");
        Gelo = new Planet("Gelo");
        Swirl = new Planet("Swirl");

        /**
         * finding text views in the activity and binding them to the textviews in the code
         */
        SolarSystemView0 =  findViewById(R.id.SolarSystemView0);
        SolarSystemView1 =  findViewById(R.id.SolarSystemView1);
        SolarSystemView2 =  findViewById(R.id.SolarSystemView2);
        SolarSystemView3 =  findViewById(R.id.SolarSystemView3);
        SolarSystemView4 =  findViewById(R.id.SolarSystemView4);
        SolarSystemView5 =  findViewById(R.id.SolarSystemView5);
        SolarSystemView6 =  findViewById(R.id.SolarSystemView6);
        SolarSystemView7 =  findViewById(R.id.SolarSystemView7);
        SolarSystemView8 =  findViewById(R.id.SolarSystemView8);
        SolarSystemView9 =  findViewById(R.id.SolarSystemView9);


        /**
         * Make ArrayList with two planets
         */
        ArrayList<Planet> twoPlanets = new ArrayList<>();
        twoPlanets.add(Gelo);
        twoPlanets.add(Swirl);

        /**
         * Instantiate solar Systems
         */

        SolarSystem milkyWay = new SolarSystem("Milky Way", TechLevel.FIVE, Resource.ONE, 0, 0, Earth);
        SolarSystem rockyWay = new SolarSystem("Rocky Way", TechLevel.FOUR, Resource.THREE, Constants.TWENTY, 10, Mars);
        SolarSystem silkyWay = new SolarSystem("Silky Way", TechLevel.THREE, Resource.EIGHT, Constants.FOURTY, Constants.THIRTY, Saturn);
        SolarSystem almondWay = new SolarSystem("Almond Way", TechLevel.TWO, Resource.SEVEN, Constants.SIXTY, Constants.FIFTY, Mercury);
        SolarSystem crunchyWay = new SolarSystem("Crunchy Way", TechLevel.ONE, Resource.ELEVEN, Constants.EIGHTY, Constants.SEVENTY, Venus);
        SolarSystem saucyWay = new SolarSystem("Saucy Way", TechLevel.SIX, Resource.FOUR, 100, Constants.NINETY, Uranus);
        SolarSystem creamyWay = new SolarSystem("Creamy Way", TechLevel.SEVEN, Resource.NINE, Constants.ONETWENTY, 100, Pluto);
        SolarSystem sourWay = new SolarSystem("Sour Way", TechLevel.ZERO, Resource.TWO, 100, Constants.EIGHTYFIVE, Ares);
        SolarSystem saltyWay = new SolarSystem("Salty Way", TechLevel.FIVE, Resource.TWELVE, Constants.ONEFOURTY, Constants.SIXTYFIVE, twoPlanets);
        SolarSystem datWay = new SolarSystem("Dat Way", TechLevel.FOUR, Resource.TEN, Constants.ONEFIFTY, Constants.FOURTYFOUR, Vulcan);


        /**
         * Instantiate universe here
         */
        ArrayList<SolarSystem> solarSystemsList = new ArrayList<>();
        solarSystemsList.add(milkyWay);
        solarSystemsList.add(rockyWay);
        solarSystemsList.add(silkyWay);
        solarSystemsList.add(saltyWay);
        solarSystemsList.add(almondWay);
        solarSystemsList.add(crunchyWay);
        solarSystemsList.add(saucyWay);
        solarSystemsList.add(creamyWay);
        solarSystemsList.add(sourWay);
        solarSystemsList.add(datWay);

        universe = new Universe("Georgia", solarSystemsList);

        /**
         *Having each text view display a solar system and description
         */

        SolarSystemView0.setText("Solar system: " + solarSystemsList.get(0).getName() + " Tech Level: " +
                solarSystemsList.get(0).getTechLev().getTech()
        + " Resource Level: " + solarSystemsList.get(0).getResourceType().getResource() + " Coordinates: " +
                "("+solarSystemsList.get(0).getxCoor() + "," +
                solarSystemsList.get(0).getyCoor()+")");

        SolarSystemView1.setText("Solar system: " + solarSystemsList.get(1).getName() + " Tech Level: "
                + solarSystemsList.get(1).getTechLev().getTech()
                + " Resource Level: " + solarSystemsList.get(1).getResourceType().getResource() + " Coordinates: " +
                "("+solarSystemsList.get(1).getxCoor() + "," +
                solarSystemsList.get(1).getyCoor()+")");

        SolarSystemView2.setText("Solar system: " + solarSystemsList.get(2).getName() + " Tech Level: " +
                solarSystemsList.get(2).getTechLev().getTech()
                + " Resource Level: " + solarSystemsList.get(2).getResourceType().getResource() + " Coordinates: " +
                "("+solarSystemsList.get(2).getxCoor() + "," +
                solarSystemsList.get(2).getyCoor()+")");

        SolarSystemView3.setText("Solar system: " + solarSystemsList.get(3).getName() + " Tech Level: " +
                solarSystemsList.get(3).getTechLev().getTech()
                + " Resource Level: " + solarSystemsList.get(3).getResourceType().getResource() + " Coordinates: " +
                "("+solarSystemsList.get(3).getxCoor() + "," +
                solarSystemsList.get(3).getyCoor()+")");

        SolarSystemView4.setText("Solar system: " + solarSystemsList.get(4).getName() + " Tech Level: " +
                solarSystemsList.get(4).getTechLev().getTech()
                + " Resource Level: " + solarSystemsList.get(4).getResourceType().getResource() + " Coordinates: " +
                "("+solarSystemsList.get(4).getxCoor() + "," +
                solarSystemsList.get(4).getyCoor()+")");

        SolarSystemView5.setText("Solar system: " + solarSystemsList.get(5).getName() + " Tech Level: " +
                solarSystemsList.get(5).getTechLev().getTech()
                + " Resource Level: " + solarSystemsList.get(5).getResourceType().getResource() + " Coordinates: " +
                "("+solarSystemsList.get(5).getxCoor() + "," +
                solarSystemsList.get(5).getyCoor()+")");

        SolarSystemView6.setText("Solar system: " + solarSystemsList.get(6).getName() + " Tech Level: " +
                solarSystemsList.get(6).getTechLev().getTech()
                + " Resource Level: " + solarSystemsList.get(6).getResourceType().getResource() + " Coordinates: " +
                "("+solarSystemsList.get(6).getxCoor() + "," +
                solarSystemsList.get(6).getyCoor()+")");

        SolarSystemView7.setText("Solar system: " + solarSystemsList.get(7).getName() + " Tech Level: " +
                solarSystemsList.get(7).getTechLev().getTech()
                + " Resource Level: " + solarSystemsList.get(7).getResourceType().getResource() + " Coordinates: " +
                "("+solarSystemsList.get(7).getxCoor() + "," +
                solarSystemsList.get(7).getyCoor()+")");

        SolarSystemView8.setText("Solar system: " + solarSystemsList.get(8).getName() + " Tech Level: " +
                solarSystemsList.get(8).getTechLev().getTech()
                + " Resource Level: " + solarSystemsList.get(8).getResourceType().getResource() + " Coordinates: " +
                "("+solarSystemsList.get(8).getxCoor() + "," +
                solarSystemsList.get(8).getyCoor()+")");

        SolarSystemView9.setText("Solar system: " + solarSystemsList.get(9).getName() + " Tech Level: " +
                solarSystemsList.get(9).getTechLev().getTech()
                + " Resource Level: " + solarSystemsList.get(9).getResourceType().getResource() + " Coordinates: " +
                "("+solarSystemsList.get(9).getxCoor() + "," +
                solarSystemsList.get(9).getyCoor()+")");

    }

    /**
     * The player will start playing the game
     * @param view will be the new view to go to -- @code StartPlayActivity
     */
    public void goToPlayActivity(View view) {
        Intent intent = new Intent(this, StartPlayActivity.class);
        startActivity(intent);
    }
}
