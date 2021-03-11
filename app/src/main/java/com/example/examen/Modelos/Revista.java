package com.example.examen.Modelos;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Revista {
    int id;
    String titulo;
    String descripcion;

    public Revista(JSONObject a)  throws JSONException {

    }
    public static ArrayList<Revista> JsonObjectsBuild(JSONArray datos) throws JSONException {
        ArrayList<Revista> contactos = new ArrayList<>();
        for (int i = 0; i < datos.length(); i++) {
            contactos.add(new Revista(datos.getJSONObject(i)));
        }
        return contactos;
    }
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
