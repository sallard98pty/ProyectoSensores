package com.example.proyectosensores;

import androidx.appcompat.app.AppCompatActivity;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.widget.TextView;
import java.util.List;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CharSequence[] choices = {"Choice1", "Choice2", "Choice3"};
        boolean[] choicesInitial = {false, true, false};
        AlertDialog.Builder alertDialogBuilder = new MaterialAlertDialogBuilder(getContext())
                .setTitle(title)
                .setPositiveButton("Accept", null)
                .setNeutralButton("Cancel", null)
                .setMultiChoiceItems(choices, choicesInitial, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which, boolean isChecked) {

                    }
                });
        alertDialogBuilder.show();
    }
}