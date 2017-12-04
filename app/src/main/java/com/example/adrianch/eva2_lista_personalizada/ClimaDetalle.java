package com.example.adrianch.eva2_lista_personalizada;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.itchii.mario.eva2_10_lista_restaurantes.R;

public class ClimaDetalle extends AppCompatActivity {


    ImageView imgVwDet;
    TextView txtVwRestDet, txtVwDescDet, txtVwTelDet, txtVwUbicDet;
    String tel="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clima_detalle);

        imgVwDet = (ImageView) findViewById(R.id.imgVwDet);
        txtVwRestDet = (TextView) findViewById(R.id.txtVwRestDet);
        txtVwDescDet = (TextView) findViewById(R.id.txtVwDescDet);
        txtVwTelDet = (TextView) findViewById(R.id.txtVwTelDet);
        txtVwUbicDet = (TextView) findViewById(R.id.txtVwUbicDet);

        //Recuperar el intento que genero detalle
        Intent datos = getIntent();
        //Acceder al bundle
        Bundle bundleDatos = datos.getExtras();
        //Leer los datos
        imgVwDet.setImageResource(bundleDatos.getInt("imagen"));
        txtVwRestDet.setText(bundleDatos.getString("nombreRest"));
        txtVwDescDet.setText(bundleDatos.getString("descripcion"));
        txtVwTelDet.setText("Telefono: "+bundleDatos.getString("telefono"));
        txtVwUbicDet.setText(bundleDatos.getString("ubicacion"));
        tel = bundleDatos.getString("telefono");
    }

    public void enClick(View view) {
        finish();
    }

    @SuppressLint("MissingPermission")
    public void clickTelefono(View v) {
        String uriTel = "tel:"+tel;
        Intent llamadaDirecta = new Intent(Intent.ACTION_CALL, Uri.parse(uriTel));
        startActivity(llamadaDirecta);
    }
}
