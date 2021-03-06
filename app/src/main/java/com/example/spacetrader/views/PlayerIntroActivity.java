package com.example.spacetrader.views;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;
import com.example.spacetrader.R;
import com.example.spacetrader.entity.Player;
import com.example.spacetrader.model.Game;

public class PlayerIntroActivity extends AppCompatActivity {
    private TextView credits_TextView;
    private TextView difficulty_TextView;
    private TextView ship_TextView;
    private TextView points_TextView;
    private TextView trader_TextView;
    private TextView pilot_TextView;
    private TextView engineer_TextView;
    private TextView fighter_TextView;
    public static Player player;
    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player_intro);
        Toolbar toolbar =  findViewById(R.id.toolbar);
        player = ConfigurationActivity.newGame.getPlayer();
        toolbar.setTitle("Hi " + player.getName() + "!");
        setSupportActionBar(toolbar);

        Game newGame = ConfigurationActivity.newGame;
        Player player = newGame.player;



        credits_TextView =  findViewById(R.id.credits_TextView);
        credits_TextView.setText("Credits: " + player.getCredits());

        difficulty_TextView =  findViewById(R.id.difficulty_TextView);
        difficulty_TextView.setText("Difficulty: " + newGame.getDifficulty());

        ship_TextView =  findViewById(R.id.ship_TextView);
        ship_TextView.setText("Ship Type: " + player.getShipType());

        points_TextView =  findViewById(R.id.points_TextView);
        points_TextView.setText("Unspent Skill Points: " + player.calculatePointsLeft());

        trader_TextView =  findViewById(R.id.trader_TextView);
        trader_TextView.setText("Trader: " + player.getTrader());

        pilot_TextView =  findViewById(R.id.pilot_TextView);
        pilot_TextView.setText("Pilot: " + player.getPilot());

        engineer_TextView =  findViewById(R.id.engineer_TextView);
        engineer_TextView.setText("Engineer: " + player.getEngineer());

        fighter_TextView =  findViewById(R.id.fighter_TextView);
        fighter_TextView.setText("Fighter: " + player.getFighter());

    }
    /**
     * Going to the next page -> Player Intro Activity
     * This is where we will verify everything about the player has been saved and calculated correctly
     * @param view
     */
    public void goToUniverseActivity(View view) {
        Intent intent = new Intent(this, UniverseActivity.class);
        startActivity(intent);
    }




}
