package com.example.spacetrader.views;

        import android.content.Intent;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.util.Log;
        import android.view.View;
        import android.widget.Toast;
        import com.example.spacetrader.R;
        import com.example.spacetrader.entity.Universe;
        import com.example.spacetrader.model.Game;
        import com.example.spacetrader.views.ConfigurationActivity;
        import com.google.gson.Gson;

        import java.io.BufferedReader;
        import java.io.File;
        import java.io.FileReader;
        import java.io.IOException;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void goToConfigurationScreen(View view) {
        Intent intent = new Intent(this, ConfigurationActivity.class);
        startActivity(intent);
    }
    public void loadGame(View view) {
        File uf = new File(this.getFilesDir(), "ufile.json");
        File gf = new File(this.getFilesDir(), "gfile.json");

        try {
            BufferedReader input = new BufferedReader(new FileReader(uf));
            String inString = input.readLine();
            Gson gson = new Gson();
            UniverseActivity.universe = gson.fromJson(inString, Universe.class);

            input = new BufferedReader(new FileReader(gf));
            inString = input.readLine();
            gson = new Gson();
            ConfigurationActivity.newGame = gson.fromJson(inString, Game.class);

            ConfigurationActivity.player = ConfigurationActivity.newGame.player;

            PlayerIntroActivity.player = ConfigurationActivity.newGame.player;

            TravelActivity.player = ConfigurationActivity.newGame.player;

            Intent intent = new Intent(this, StartPlayActivity.class);
            startActivity(intent);
        } catch (IOException e) {
            Toast.makeText(getApplicationContext(), "No saved files!",
                    Toast.LENGTH_LONG).show();
            Log.e("Main", "fail");
        }
    }
}