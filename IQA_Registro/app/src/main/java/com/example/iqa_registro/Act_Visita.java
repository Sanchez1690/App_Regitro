package com.example.iqa_registro;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;

public class Act_Visita extends AppCompatActivity {

    Spinner opciones;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act__visita);
        opciones = (Spinner) findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.Motivo,android.R.layout.simple_spinner_item);
        opciones.setAdapter(adapter);
    }
}
