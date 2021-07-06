package com.example.tp4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Registro extends AppCompatActivity {
   EditText correo;
   EditText contrasenia;
   EditText nombre;
   Button grabar, btn_Login;

    SharedPreferences preferencia;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        correo=findViewById(R.id.txt_correo);
        contrasenia=findViewById(R.id.txt_contrasenia);
        nombre=findViewById(R.id.txt_nombre);
        grabar=findViewById(R.id.btn_Grabar);
        btn_Login = findViewById(R.id.btn_Login);
        preferencia= getSharedPreferences("pref", Context.MODE_PRIVATE);

        grabar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor=preferencia.edit();
                String usuario = correo.getText().toString();
                String contra= contrasenia.getText().toString();
                String nom= nombre.getText().toString();

                editor.putString("usuario",usuario);
                editor.putString("contrasenia",contra);
                editor.putString("nombreCompleto",nom);
               editor.commit();
               finish();
            }
        });

        btn_Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent inicio = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(inicio);
            }
        });
    }
    public void inicio(View v ){
        btn_Login=findViewById(R.id.btnsesion);
        btn_Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent inc = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(inc);
            }
        });
    }
}