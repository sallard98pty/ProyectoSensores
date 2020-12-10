package com.example.proyectosensores;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // se inicia el mensaje de bienvenida que notifica al ususario que debe elegir una de las opciones de la lista que se le muestra


        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        tv4=findViewById(R.id.tv4);
// Configura el titulo.
        alertDialogBuilder.setTitle("Proyecto 2");
// Configura el mensaje.
        alertDialogBuilder
                .setMessage("Por favor, escoja una de las 3 opciones que se le muestra :)")
                .setPositiveButton("OK",new DialogInterface.OnClickListener()
                {
                    public void onClick(DialogInterface dialog,int id) {
                        img1.setVisibility(View.VISIBLE);
                    }).create().show();
    }
}