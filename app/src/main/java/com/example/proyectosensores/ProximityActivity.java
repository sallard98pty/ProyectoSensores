package com.example.proyectosensores;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;

public class ProximityActivity extends AppCompatActivity {

    private SensorManager sensorManager;
    private TextView txtProxy;
    private Sensor proximity;

    //Se inicializan trodas las variables
    //Se crean los objetos para manejar los sensores
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_proximity);
        txtProxy = findViewById(R.id.txtproxi);
        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        proximity = sensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY);
        txtProxy.setText("");
    }

    //Registro el Listener
    public void onResume() {
        super.onResume();
        sensorManager.registerListener(ProximityListener, proximity, SensorManager.SENSOR_DELAY_NORMAL);
    }
    //Quita el Registro el Listener
    public void onStop() {
        super.onStop();
        sensorManager.unregisterListener(ProximityListener);
    }
    //Crea el Listener
    public SensorEventListener ProximityListener = new SensorEventListener() {
        @Override
        public void onAccuracyChanged(Sensor sensor, int i) {

        }

        //Escucha las variaciones del sensor
        @Override
        public void onSensorChanged(SensorEvent sensorEvent) {
            String proxytext = String.valueOf((int) sensorEvent.values[0] + "cm");
            txtProxy.setText(proxytext);
        }
    };




}