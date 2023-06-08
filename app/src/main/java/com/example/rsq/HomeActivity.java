package com.example.rsq;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class HomeActivity extends AppCompatActivity {
    private Button buttonDefibrillator;
    private Button buttonPump;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        buttonDefibrillator = findViewById(R.id.button_defibrillator);
        buttonPump = findViewById(R.id.button_pump);

        buttonDefibrillator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Commencez l'activité pour le défibrillateur
                Intent intent = new Intent(HomeActivity.this, DefibrillatorActivity.class);
                startActivity(intent);
            }
        });

        buttonPump.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Commencez l'activité pour la pompe
                Intent intent = new Intent(HomeActivity.this, PumpActivity.class);
                startActivity(intent);
            }
        });
    }
}
