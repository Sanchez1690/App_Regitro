package com.example.iqa_registro;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.Objects;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Registro_2 extends AppCompatActivity {

    private EditText nombre;
    private EditText empresa;
    private EditText email;
    private EditText telefono;
    private ImageView img1;


    String correo;
    String contrasena;

    //String file_path="";
    //String name;
    // File file;
    //private String carpeta="/prueba/";
    // private  String archivo="queso";
    Session session;
    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_2);

        Objects.requireNonNull(getSupportActionBar()).hide();

        nombre = findViewById(R.id.etx_nombre);
        empresa =  findViewById(R.id.etx_empresa);
        email = findViewById(R.id.etx_email);
        telefono =  findViewById(R.id.etx_telefono);
        img1 = findViewById(R.id.imageView);

        if (ContextCompat.checkSelfPermission(Registro_2.this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(Registro_2.this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(Registro_2.this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.CAMERA}, 1000);
        }

        correo = "pp095401@gmail.com";
        contrasena="7CKWhuV6P38Cs6j";
    }

    public void enviarMail(View view)
    {
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        Properties properties = new Properties();
        properties.put("mail.smtp.host","smtp.googlemail.com");
        properties.put("mail.smtp.socketFactory.port","465");
        properties.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");
        properties.put("mail.smtp.auth","true");
        properties.put("mail.smtp.port","465");

        try
        {
            session= Session.getDefaultInstance(properties, new Authenticator() {
                @Override
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(correo,contrasena);
                }
            });

            if(session!=null) {
                Message message = new MimeMessage(session);
                message.setFrom(new InternetAddress(correo));
                message.setSubject("Nuevo registro");
                message.setRecipients(Message.RecipientType.TO,InternetAddress.parse("l.sanchezc@outlook.es"));
                message.setContent("Nombre: "+nombre.getText().toString()+"<br>Empresa: "+empresa.getText().toString()+"<br>Correo: "+email.getText().toString()+"<br>Telefono: "+telefono.getText().toString(),"text/html; charset=utf-8");
                Transport.send(message);
            }
        }
        catch (Exception e){e.printStackTrace();}

        nombre.setText("");
        empresa.setText("");
        email.setText("");
        telefono.setText("");
        Toast.makeText(this,"Registro Exitoso",Toast.LENGTH_LONG).show();
    }
}
