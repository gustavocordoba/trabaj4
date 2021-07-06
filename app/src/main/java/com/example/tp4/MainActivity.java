package com.example.tp4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button btn_ingresar,btn_regris;
    private EditText ingrese_correo,ingrese_contraseña;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ingrese_correo=(EditText)findViewById(R.id.editTextTextPersonName);
        ingrese_contraseña=(EditText)findViewById(R.id.editTextTextPassword);
        String usuario="alumno";
        String contrasenia="123456";
        btn_ingresar = findViewById(R.id.btn_Ingresar);
        btn_ingresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String nombre= String.valueOf(ingrese_correo.getText());
                String clave= String.valueOf(ingrese_contraseña.getText());
                clave = clave.toLowerCase();
                nombre= nombre.toLowerCase();
                btn_ingresar = findViewById(R.id.btn_Ingresar);
                Intent inicio =new Intent(getApplicationContext(),Inicio.class);
                if (nombre.equals(usuario) && clave.equals(contrasenia))  {

                    startActivity(inicio);

                }else{ Toast.makeText(getApplicationContext(),"ERROR",Toast.LENGTH_LONG).show();}
            }
        });
            btn_regris = findViewById(R.id.btn_Registrar);
        btn_regris.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent registro =new Intent(getApplicationContext(),Registro.class);
                    startActivity(registro);
                }
            });





    }


}