package com.example.examen.Modelos;

import android.content.Context;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.examen.R;
import com.mindorks.placeholderview.annotations.Layout;
import com.mindorks.placeholderview.annotations.NonReusable;
import com.mindorks.placeholderview.annotations.Resolve;
import com.mindorks.placeholderview.annotations.View;

import org.json.JSONException;
import org.json.JSONObject;

@NonReusable
@Layout(R.layout.revista)
public class RevistaPlaceHolder {

    @View(com.example.examen.R.id.txtDescripcion)
    TextView descripcion;

    @View(com.example.examen.R.id.txtNombre)
    TextView nombre;

    @View(com.example.examen.R.id.imgPortada)
    ImageView img;

    Context contexto;
    JSONObject lstRevista;

    public RevistaPlaceHolder(Context contexto, JSONObject lstRevista) {
        this.contexto = contexto;
        this.lstRevista = lstRevista;
    }

    @Resolve
    protected void onResolved() throws JSONException {
        this.nombre.setText(this.lstRevista.getString("name"));
        this.descripcion.setText(this.lstRevista.getString("description"));
        Glide.with(this.contexto).load(this.lstRevista.getString("portada")).into(this.img);
    }
}
