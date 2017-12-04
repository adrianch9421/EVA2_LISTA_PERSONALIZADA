package com.example.adrianch.eva2_lista_personalizada;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.itchii.mario.eva2_10_lista_restaurantes.R;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    ListView lstVwLista;
    Context contexto;

    DatosRestaurante[] arregloRestaurantes = {
            new DatosRestaurante(R.drawable.barrafina, "Barrafina", "Excelente", "4195408", "Chihuahua"),
            new DatosRestaurante(R.drawable.bourkestreetbakery, "Bourke Street Bakery", "Excelente", "4195408", "Chihuahua"),
            new DatosRestaurante(R.drawable.cafedeadend, "Cafe Dead End", "Excelente", "4195408", "Chihuahua"),
            new DatosRestaurante(R.drawable.cafeloisl, "Cafe Loisl", "Excelente", "4195408", "Chihuahua"),
            new DatosRestaurante(R.drawable.cafelore, "Cafe Lore", "Excelente", "4195408", "Chihuahua"),
            new DatosRestaurante(R.drawable.confessional, "Confessional", "Excelente", "4195408", "Chihuahua"),
            new DatosRestaurante(R.drawable.donostia, "Don Ostia", "Excelente", "4195408", "Chihuahua"),
            new DatosRestaurante(R.drawable.fiveleaves, "Five Leaves", "Excelente", "4195408", "Chihuahua"),
            new DatosRestaurante(R.drawable.forkeerestaurant, "Forkee Restaurant", "Excelente", "4195408", "Chihuahua"),
            new DatosRestaurante(R.drawable.grahamavenuemeats, "Graham Avenue Meats", "Excelente", "4195408", "Chihuahua"),
            new DatosRestaurante(R.drawable.haighschocolate, "Haighs Chocolate", "Excelente", "4847344", "Chihuahua"),
            new DatosRestaurante(R.drawable.homei, "Homei", "Original", "4847344", "Chihuahua"),
            new DatosRestaurante(R.drawable.palominoespresso, "Palomino Espresso", "Original", "4847344", "Chihuahua"),
            new DatosRestaurante(R.drawable.petiteoyster, "Petite Oyster", "Original", "4847344", "Chihuahua"),
            new DatosRestaurante(R.drawable.posatelier, "Posatelier", "Original", "4847344", "Chihuahua"),
            new DatosRestaurante(R.drawable.royaloak, "Royal Oak", "Original", "4847344", "Chihuahua"),
            new DatosRestaurante(R.drawable.teakha, "Tea Kha", "Original", "4847344", "Chihuahua"),
            new DatosRestaurante(R.drawable.thaicafe, "Thai Cafe", "Bien", "4847344", "Chihuahua"),
            new DatosRestaurante(R.drawable.traif, "Traif", "Bien", "4847344", "Chihuahua"),
            new DatosRestaurante(R.drawable.upstate, "Up Sate", "Bien", "4847344", "Chihuahua"),
            new DatosRestaurante(R.drawable.wafflewolf, "Waffle Wolf", "Bien", "4847344", "Chihuahua")
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lstVwLista = (ListView) findViewById(R.id.lstVwLista);
        lstVwLista.setAdapter(new ClimaAdapter(this, R.layout.clima_layout, arregloRestaurantes));
        lstVwLista.setOnItemClickListener(this);
        contexto = getApplicationContext();
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        final int pos = position;
        final Dialog dialogoPers = new Dialog(this);
        dialogoPers.setContentView(R.layout.dialogo_personalizado);

        TextView txtVwDialogo;
        ImageView imgVwDialogo;
        Button btnCancelarDialogo, btnDetallesDialogo;

        txtVwDialogo = (TextView) dialogoPers.findViewById(R.id.txtVwDialogo);
        imgVwDialogo = (ImageView) dialogoPers.findViewById(R.id.imgVwDialogo);
        btnCancelarDialogo = (Button) dialogoPers.findViewById(R.id.btnCancelarDialogo);
        btnDetallesDialogo = (Button) dialogoPers.findViewById(R.id.btnDetallesDialogo);
        Log.e("nombre", arregloRestaurantes[position].nombreRest);
        txtVwDialogo.setText(arregloRestaurantes[position].nombreRest);
        imgVwDialogo.setImageResource(arregloRestaurantes[position].imagenClima);
        btnCancelarDialogo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialogoPers.dismiss();
            }
        });
        btnDetallesDialogo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mostrarDet = new Intent(MainActivity.this, ClimaDetalle.class);
                Bundle bundleDatos = new Bundle();
                bundleDatos.putInt("imagen", arregloRestaurantes[pos].imagenClima);
                bundleDatos.putString("nombreRest", arregloRestaurantes[pos].nombreRest);
                bundleDatos.putString("telefono", arregloRestaurantes[pos].telefono);
                bundleDatos.putString("descripcion", arregloRestaurantes[pos].descripcion);
                bundleDatos.putString("ubicacion", arregloRestaurantes[pos].ubicacion);
                mostrarDet.putExtras(bundleDatos);
                startActivity(mostrarDet);
                dialogoPers.dismiss();
            }
        });
        dialogoPers.show();
    }
}
