package com.example.adrianch.eva2_lista_personalizada;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.itchii.mario.eva2_10_lista_restaurantes.R;

/**
 * Created by Adrian Ch on 23/10/17.
 */

public class ClimaAdapter extends ArrayAdapter<DatosRestaurante> {

    Context contexto;
    int iLayout;
    DatosRestaurante[] datosRestaurantes;

    public ClimaAdapter(@NonNull Context context, @LayoutRes int resource, @NonNull DatosRestaurante[] objects) {
        super(context, resource, objects);
        contexto = context;
        iLayout = resource;
        datosRestaurantes = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ImageView imgVwDet;
        TextView txtVwRestDet, txtVwDescDet;
        View vwFila = convertView;

        if (vwFila == null) { //La lista se llena por primera vez
            LayoutInflater CrearLayout = ((Activity) contexto).getLayoutInflater();
            vwFila = CrearLayout.inflate(iLayout, parent, false);
        }

        imgVwDet = (ImageView) vwFila.findViewById(R.id.imgVw);
        txtVwRestDet = (TextView) vwFila.findViewById(R.id.txtVwRest);
        txtVwDescDet = (TextView) vwFila.findViewById(R.id.txtVwDesc);

        //Llenar datos
        imgVwDet.setImageResource(datosRestaurantes[position].imagenClima);
        txtVwRestDet.setText(datosRestaurantes[position].nombreRest);
        txtVwDescDet.setText(datosRestaurantes[position].descripcion);
        return vwFila;
        //return super.getView(position, convertView, parent);
    }
}
