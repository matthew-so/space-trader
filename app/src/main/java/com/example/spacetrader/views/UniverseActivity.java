package com.example.spacetrader.views;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import com.example.spacetrader.entity.*;
import com.example.spacetrader.R;

import java.lang.reflect.Array;
import java.util.ArrayList;


public class UniverseActivity extends AppCompatActivity {

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
    private TextView SolarSystemView10;
    private Universe universe;






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
         * Make arraylist with two planets
         */
        ArrayList<Planet> twoPlanets = new ArrayList<>();
        twoPlanets.add(Gelo);
        twoPlanets.add(Swirl);

        /**
         * Instantiate solar Systems
         */

        SolarSystem milkyWay = new SolarSystem("Milky Way", techLevel.FIVE, Resources.ONE, 0, 0, Earth);
        SolarSystem rockyWay = new SolarSystem("Rocky Way", techLevel.FOUR, Resources.THREE, 20, 10, Mars);
        SolarSystem silkyWay = new SolarSystem("Silky Way", techLevel.THREE, Resources.EIGHT, 40, 30, Saturn);
        SolarSystem almondWay = new SolarSystem("Almond Way", techLevel.TWO, Resources.SEVEN, 60, 50, Mercury);
        SolarSystem crunchyWay = new SolarSystem("Crunchy Way", techLevel.ONE, Resources.ELEVEN, 80, 70, Venus);
        SolarSystem saucyWay = new SolarSystem("Saucy Way", techLevel.SIX, Resources.FOUR, 100, 90, Uranus);
        SolarSystem creamyWay = new SolarSystem("Creamy Way", techLevel.SEVEN, Resources.NINE, 120, 100, Pluto);
        SolarSystem sourWay = new SolarSystem("Sour Way", techLevel.ZERO, Resources.TWO, 100, 85, Ares);
        SolarSystem saltyWay = new SolarSystem("Salty Way", techLevel.FIVE, Resources.TWELVE, 140, 65, twoPlanets);
        SolarSystem theWay = new SolarSystem("The Way", techLevel.FOUR, Resources.TEN, 150, 44, Vulcan);







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
        solarSystemsList.add(theWay);

        universe = new Universe("Georgia", solarSystemsList);





        /**
         *Having each text view display a solar system and description
         */

        SolarSystemView0.setText("Solar system: " + solarSystemsList.get(0).getName() + " Tech Level: " + solarSystemsList.get(0).getTechLev()
        + " Resources Level: " + solarSystemsList.get(0).getResourceType() + " Coordinates: " + "("+solarSystemsList.get(0).getxCoor() + "," +
                solarSystemsList.get(0).getyCoor()+")");

        SolarSystemView1.setText("Solar system: " + solarSystemsList.get(1).getName() + " Tech Level: " + solarSystemsList.get(1).getTechLev()
                + " Resources Level: " + solarSystemsList.get(1).getResourceType() + " Coordinates: " + "("+solarSystemsList.get(1).getxCoor() + "," +
                solarSystemsList.get(1).getyCoor()+")");

        SolarSystemView2.setText("Solar system: " + solarSystemsList.get(2).getName() + " Tech Level: " + solarSystemsList.get(2).getTechLev()
                + " Resources Level: " + solarSystemsList.get(2).getResourceType() + " Coordinates: " + "("+solarSystemsList.get(2).getxCoor() + "," +
                solarSystemsList.get(2).getyCoor()+")");

        SolarSystemView3.setText("Solar system: " + solarSystemsList.get(3).getName() + " Tech Level: " + solarSystemsList.get(3).getTechLev()
                + " Resources Level: " + solarSystemsList.get(3).getResourceType() + " Coordinates: " + "("+solarSystemsList.get(3).getxCoor() + "," +
                solarSystemsList.get(3).getyCoor()+")");

        SolarSystemView4.setText("Solar system: " + solarSystemsList.get(4).getName() + " Tech Level: " + solarSystemsList.get(4).getTechLev()
                + " Resources Level: " + solarSystemsList.get(4).getResourceType() + " Coordinates: " + "("+solarSystemsList.get(4).getxCoor() + "," +
                solarSystemsList.get(4).getyCoor()+")");

        SolarSystemView5.setText("Solar system: " + solarSystemsList.get(5).getName() + " Tech Level: " + solarSystemsList.get(5).getTechLev()
                + " Resources Level: " + solarSystemsList.get(5).getResourceType() + " Coordinates: " + "("+solarSystemsList.get(5).getxCoor() + "," +
                solarSystemsList.get(5).getyCoor()+")");

        SolarSystemView6.setText("Solar system: " + solarSystemsList.get(6).getName() + " Tech Level: " + solarSystemsList.get(6).getTechLev()
                + " Resources Level: " + solarSystemsList.get(6).getResourceType() + " Coordinates: " + "("+solarSystemsList.get(6).getxCoor() + "," +
                solarSystemsList.get(6).getyCoor()+")");

        SolarSystemView7.setText("Solar system: " + solarSystemsList.get(7).getName() + " Tech Level: " + solarSystemsList.get(7).getTechLev()
                + " Resources Level: " + solarSystemsList.get(7).getResourceType() + " Coordinates: " + "("+solarSystemsList.get(7).getxCoor() + "," +
                solarSystemsList.get(7).getyCoor()+")");

        SolarSystemView8.setText("Solar system: " + solarSystemsList.get(8).getName() + " Tech Level: " + solarSystemsList.get(8).getTechLev()
                + " Resources Level: " + solarSystemsList.get(8).getResourceType() + " Coordinates: " + "("+solarSystemsList.get(8).getxCoor() + "," +
                solarSystemsList.get(8).getyCoor()+")");

        SolarSystemView9.setText("Solar system: " + solarSystemsList.get(9).getName() + " Tech Level: " + solarSystemsList.get(9).getTechLev()
                + " Resources Level: " + solarSystemsList.get(9).getResourceType() + " Coordinates: " + "("+solarSystemsList.get(9).getxCoor() + "," +
                solarSystemsList.get(9).getyCoor()+")");


    }
}
