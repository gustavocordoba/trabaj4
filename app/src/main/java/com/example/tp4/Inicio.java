package com.example.tp4;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

public class Inicio extends AppCompatActivity {

    String pagina="https://github.com/";
    private Button btn_sesion;

    private ImageButton botonCorreo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);

        botonCorreo = findViewById(R.id.btnCorreo);
        botonCorreo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String[] destinatarios = {"gustavo@ites","gustavo1@gustavo"};
                enviarEmail(destinatarios,"Prueba");

            }
        });

        btn_sesion=findViewById(R.id.btnsesion);
        btn_sesion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent main = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(main);
            }
        });

    }

    public void onClickLlamada(View v) {

        Intent i = new Intent(Intent.ACTION_DIAL);
        i.setData(Uri.parse("tel:123456789"));
        startActivity(i);

    }

    public void onClickurl(View v){
        Uri destino= Uri.parse(pagina);
        Intent a=new Intent(Intent.ACTION_VIEW,destino);
        startActivity(a);
    }

    public void enviarEmail(String[] correo, String asunto) {
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:"));
        intent.putExtra(Intent.EXTRA_EMAIL, "gustavo@ites");
        intent.putExtra(Intent.EXTRA_SUBJECT, "Practico4");
        intent.putExtra(Intent.EXTRA_TEXT, "Hola");
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }

    }

     public void sesion(View v ){
        btn_sesion=findViewById(R.id.btnsesion);
        btn_sesion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent registro = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(registro);
            }
        });
     }

}

