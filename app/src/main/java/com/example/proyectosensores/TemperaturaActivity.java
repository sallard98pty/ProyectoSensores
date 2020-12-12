package com.example.proyectosensores;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;

public class TemperaturaActivity extends AppCompatActivity  {
    private SensorManager sensorManager;
    private  TextView txtTemp;
    private Sensor temperature;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_temperatura);
        txtTemp = findViewById(R.id.txttemp);
        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        temperature = sensorManager.getDefaultSensor(Sensor.TYPE_AMBIENT_TEMPERATURE);
        txtTemp.setText("");
    }
    public void onResume() {
        super.onResume();
        sensorManager.registerListener(temperatureListener, temperature, SensorManager.SENSOR_DELAY_NORMAL);
    }

    public void onStop() {
        super.onStop();
        sensorManager.unregisterListener(temperatureListener);
    }

    public SensorEventListener temperatureListener = new SensorEventListener() {
        @Override
        public void onAccuracyChanged(Sensor sensor, int i) {

        }


        @Override
        public void onSensorChanged(SensorEvent sensorEvent) {
            String temptext = String.valueOf((int) sensorEvent.values[0] + "°C");
            txtTemp.setText(temptext);
        }
    };




}