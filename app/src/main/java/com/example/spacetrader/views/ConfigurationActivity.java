package com.example.spacetrader.views;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.view.View;
import android.widget.*;
import com.example.spacetrader.R;
import com.example.spacetrader.entity.Constants;
import com.example.spacetrader.entity.Difficulty;
import com.example.spacetrader.entity.Player;
import com.example.spacetrader.model.Game;

public class ConfigurationActivity extends AppCompatActivity {
    private  Button create_player;
    private  SeekBar pilot_bar;
    private  SeekBar engineer_bar;
    private  SeekBar trader_bar;
    private  SeekBar fighter_bar;

    private TextView pilotTextView;
    private TextView engineerTextView;
    private TextView traderTextView;
    private TextView fighterTextView;
    private TextView checkerTextView;

    private EditText name_edit;

    private Spinner level_spinner;


    public static Game newGame;

    public static Player player;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_configuration);

        level_spinner = findViewById(R.id.difficulty_spinner);

        ArrayAdapter<Difficulty> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item, Difficulty.values());

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        level_spinner.setAdapter(adapter);




        /**
         * Getting name of Player
         */

        name_edit = findViewById(R.id.name_edit);






         /**
         * Allocating skill points
         */
        pilotTextView = findViewById(R.id.pilotTextView);
        engineerTextView = findViewById(R.id.engineerTextView);
        traderTextView = findViewById(R.id.traderTextView);
        fighterTextView = findViewById(R.id.fighterTextView);
        checkerTextView = findViewById(R.id.checkerTextView);

        pilot_bar = findViewById(R.id.pilot_bar);
        engineer_bar = findViewById(R.id.engineer_bar);
        trader_bar = findViewById(R.id.trader_bar);
        fighter_bar = findViewById(R.id.fighter_bar);

        create_player = findViewById(R.id.create_player);




        /**
         * Each discreet bar progress will be checked and compared. A text view will activate if the sums
         * of the progresses are more than 16 and the "Create Player" button will deactivate.
         */
        pilot_bar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                pilotTextView.setText(progress + " Pilot points allocated");
                if (trader_bar.getProgress() + pilot_bar.getProgress()
                        + fighter_bar.getProgress() + engineer_bar.getProgress() != Constants.START_SKILL) {
                    checkerTextView.setText("You must use exactly 16 Skill Points!");

                    create_player.setEnabled(false);
                } else {
                    create_player.setEnabled(true);
                    checkerTextView.setText("");
                }

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        trader_bar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                traderTextView.setText(progress + " Trader points allocated");
                if (trader_bar.getProgress() + pilot_bar.getProgress()
                        + fighter_bar.getProgress() + engineer_bar.getProgress() != Constants.START_SKILL) {
                    checkerTextView.setText("You must use exactly 16 Skill Points!");

                    create_player.setEnabled(false);
                } else {
                    create_player.setEnabled(true);
                    checkerTextView.setText("");
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        engineer_bar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                engineerTextView.setText(progress + " Engineer points allocated");
                if (trader_bar.getProgress() + pilot_bar.getProgress()
                        + fighter_bar.getProgress() + engineer_bar.getProgress() != Constants.START_SKILL) {
                    checkerTextView.setText("You must use exactly 16 Skill Points!");

                    create_player.setEnabled(false);
                } else {
                    create_player.setEnabled(true);
                    checkerTextView.setText("");
                }

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        fighter_bar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                fighterTextView.setText(progress + " Fighter points allocated");
                if (trader_bar.getProgress() + pilot_bar.getProgress()
                        + fighter_bar.getProgress() + engineer_bar.getProgress() != Constants.START_SKILL) {
                    checkerTextView.setText("You must use exactly 16 Skill Points!");
                    create_player.setEnabled(false);
                } else {
                    create_player.setEnabled(true);
                    checkerTextView.setText("");
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    }

    /**
     * Going to the next page -> Player Intro Activity
     * This is where we will verify everything about the player has been saved and calculated correctly
     * @param view
     */
    public void introPlayer(View view) {
        Editable name = name_edit.getText();
        if(TextUtils.isEmpty(name_edit.getText())) {
            name_edit.setError("You must enter a name");
            return;
        }
        Difficulty difficulty = (Difficulty) level_spinner.getSelectedItem();
        Intent intent = new Intent(this, PlayerIntroActivity.class);
        newGame = new Game(name.toString(),trader_bar.getProgress(), fighter_bar.getProgress(),
                pilot_bar.getProgress(), engineer_bar.getProgress(), difficulty);
        player = newGame.getPlayer();
        startActivity(intent);
    }
    
}
