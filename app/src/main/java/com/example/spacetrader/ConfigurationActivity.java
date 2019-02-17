package com.example.spacetrader;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class ConfigurationActivity extends AppCompatActivity {

    private Spinner level_spinner;
    EditText editName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_configuration);

        level_spinner = findViewById(R.id.difficulty_spinner);
        editName = findViewById(R.id.name_edit);

        ArrayAdapter<Difficulty> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item, Difficulty.values());


        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        level_spinner.setAdapter(adapter);
    }


}
