package com.example.iqa_registro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Registro_1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_1);
    }

    public void Cliente(View view)
    {
        Intent cliente = new Intent(this,Act_Cliente.class);
        startActivity(cliente);
    }

    public void Proveedor(View view)
    {
        Intent proveedor = new Intent(this,Act_Proveedor.class);
        startActivity(proveedor);
    }

    public void Visita(View view)
    {
        Intent visita = new Intent(this,Act_Visita.class);
        startActivity(visita);
    }
}
