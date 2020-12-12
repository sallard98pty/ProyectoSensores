package com.example.proyectosensores;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btntemp = findViewById(R.id.btntemp);
        Button btnproximity = findViewById(R.id.btnproximity);
        Button btnluz = findViewById(R.id.btnLuz);

        btntemp.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent TempIntent = new Intent(MainActivity.this, TemperaturaActivity.class);
                startActivity(TempIntent);
            }
        });
        btnproximity.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent ProxIntent = new Intent(MainActivity.this, ProximityActivity.class);
                startActivity(ProxIntent);

            }
        });

        btnluz.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent LumiIntent = new Intent(MainActivity.this, IluminacionActivity.class);
                startActivity(LumiIntent);

            }
        });

    }
}