package com.example.proyectosensores;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;

public class IluminacionActivity extends AppCompatActivity {
    private SensorManager sensorManager;
    private TextView txtluminity;
    private Sensor luminity;

    //Se inicializan trodas las variables
    //Se crean los objetos para manejar los sensores

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_iluminacion);
        txtluminity = findViewById(R.id.txtluminity);
        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        luminity = sensorManager.getDefaultSensor(Sensor.TYPE_LIGHT);
        txtluminity.setText("");
    }

    //Registro el Listener
    public void onResume() {
        super.onResume();
        sensorManager.registerListener(luminityListener, luminity, SensorManager.SENSOR_DELAY_NORMAL);
    }
    //Quita el Registro el Listener
    public void onStop() {
        super.onStop();
        sensorManager.unregisterListener(luminityListener);
    }


    //Crea el Listener
    public SensorEventListener luminityListener = new SensorEventListener() {
        @Override
        public void onAccuracyChanged(Sensor sensor, int i) {

        }

        //Escucha las variaciones del sensor
        @Override
        public void onSensorChanged(SensorEvent sensorEvent) {
            String temptext = String.valueOf((int) sensorEvent.values[0] + " lx");
            txtluminity.setText(temptext);
        }
    };




}