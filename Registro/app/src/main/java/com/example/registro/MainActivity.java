package com.example.registro;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

public class MainActivity extends AppCompatActivity {

    private EditText nombre;
    private EditText empresa;
    private EditText email;
    private EditText telefono;

    String file_path="";
    File file;
    private String carpeta="/prueba/";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nombre = (EditText) findViewById(R.id.etx_nombre);
        empresa = (EditText) findViewById(R.id.etx_empresa);
        email = (EditText) findViewById(R.id.etx_email);
        telefono = (EditText) findViewById(R.id.etx_telefono);

        this.file_path = (Environment.getExternalStorageDirectory() + this.carpeta);
        File localfile = new File(this.file_path);
        if (!localfile.exists()) {
            localfile.mkdir();
        }
        this.file = new File(localfile, "queso.txt");

        try {
            this.file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    public void Registrar(View view){
        FileWriter fichero = null;
        PrintWriter pw = null;

        try
        {
            fichero=new FileWriter(file);
            pw=new PrintWriter(fichero);
            pw.println(nombre.getText().toString()+","+empresa.getText().toString()+","+email.getText().toString()+","+telefono.getText().toString());
            pw.flush();
            pw.close();
        }catch (Exception e){e.printStackTrace();}
        finally {
            try {
                if(null!=fichero){fichero.close();}
            }catch (Exception e2){e2.printStackTrace();}
        }


        }
        /*
            try{
            OutputStreamWriter archivo = new OutputStreamWriter(openFileOutput("Queso.txt", Activity.MODE_PRIVATE));
            archivo.write("Hola mundo");
            //archivo.write(nombre.getText().toString()+","+empresa.getText().toString()+","+email.getText().toString()+","+telefono.getText().toString());
            archivo.flush();
            archivo.close();
        }catch (IOException e){}
        Toast.makeText(this,"Registro guardado",Toast.LENGTH_SHORT).show();
        nombre.setText("");
        empresa.setText("");
        email.setText("");
        telefono.setText("");
        */



}
