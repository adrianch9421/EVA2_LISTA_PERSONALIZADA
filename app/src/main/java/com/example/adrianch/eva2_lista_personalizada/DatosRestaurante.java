package com.example.adrianch.eva2_lista_personalizada;


import com.itchii.mario.eva2_10_lista_restaurantes.R;

/**
 * Created by Adrian Ch 19/10/2017.
 */

public class DatosRestaurante {
    int imagenClima;
    String nombreRest, telefono, descripcion, ubicacion;

    public DatosRestaurante() {

        imagenClima = R.drawable.barrafina;
        nombreRest = "Barrafina";
        telefono = "123456789";
        descripcion = "Excelente";
        ubicacion = "Lugar original";
    }

    public DatosRestaurante(int imgClima, String iRestaurant, String iDescripcion, String iTelefono, String iUbicacion) {
        imagenClima = imgClima;
        nombreRest = iRestaurant;
        descripcion = iDescripcion;
        telefono = iTelefono;
        ubicacion = iUbicacion;
    }
}
