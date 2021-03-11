package com.example.examen.Modelos;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Revista {
    String id;
    String titulo;
    String descripcion;
    String urlPerfil;

    public Revista(JSONObject a)  throws JSONException {
        this.id= a.getString("journal_id");
        this.titulo = a.getString("name");
        this.descripcion = a.getString("description");
        this.urlPerfil = a.getString("portada");
    }
    public static ArrayList<Revista> JsonObjectsBuild(JSONArray datos) throws JSONException {
        ArrayList<Revista> revistas = new ArrayList<>();
        for (int i = 0; i < datos.length(); i++) {
            revistas.add(new Revista(datos.getJSONObject(i)));
        }
        return revistas;
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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUrlPerfil() {
        return urlPerfil;
    }

    public void setUrlPerfil(String urlPerfil) {
        this.urlPerfil = urlPerfil;
    }
}
