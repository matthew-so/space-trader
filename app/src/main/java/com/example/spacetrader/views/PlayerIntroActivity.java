package com.example.spacetrader.views;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;
import com.example.spacetrader.R;
import com.example.spacetrader.entity.Player;
import com.example.spacetrader.model.Game;
import com.example.spacetrader.views.ConfigurationActivity;

public class PlayerIntroActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player_intro);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Hi " + ConfigurationActivity.newGame.player.getName() + "!");
        setSupportActionBar(toolbar);

        Game newGame = ConfigurationActivity.newGame;
        Player player = newGame.player;

        TextView credits_TextView;
        TextView difficulty_TextView;
        TextView ship_TextView;
        TextView points_TextView;
        TextView trader_TextView;
        TextView pilot_TextView;
        TextView engineer_TextView;
        TextView fighter_TextView;

        credits_TextView = (TextView) findViewById(R.id.credits_TextView);
        credits_TextView.setText("Credits: " + player.getCredits());

        difficulty_TextView = (TextView) findViewById(R.id.difficulty_TextView);
        difficulty_TextView.setText("Difficulty: " + newGame.getDifficulty());

        ship_TextView = (TextView) findViewById(R.id.ship_TextView);
        ship_TextView.setText("Ship Type: " + player.getShip());

        points_TextView = (TextView) findViewById(R.id.points_TextView);
        points_TextView.setText("Unspent Skill Points: " + player.calculatePointsLeft());

        trader_TextView = (TextView) findViewById(R.id.trader_TextView);
        trader_TextView.setText("Trader: " + player.getTrader());

        pilot_TextView = (TextView) findViewById(R.id.pilot_TextView);
        pilot_TextView.setText("Pilot: " + player.getPilot());

        engineer_TextView = (TextView) findViewById(R.id.engineer_TextView);
        engineer_TextView.setText("Engineer: " + player.getEngineer());

        fighter_TextView = (TextView) findViewById(R.id.fighter_TextView);
        fighter_TextView.setText("Fighter: " + player.getFighter());

    }

}
