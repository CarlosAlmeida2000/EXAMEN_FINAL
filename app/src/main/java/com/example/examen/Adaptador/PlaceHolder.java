package com.example.examen.Adaptador;

import android.content.Context;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.examen.R;
import com.mindorks.placeholderview.annotations.Layout;
import com.mindorks.placeholderview.annotations.NonReusable;
import com.mindorks.placeholderview.annotations.View;

import static android.os.Build.VERSION_CODES.R;

@NonReusable
@Layout(com.example.examen.R.layout.revista)
public class PlaceHolder {
    @View(com.example.examen.R.id.txtDescripcion)
    TextView descripcion;

    @View(com.example.examen.R.id.txtNombre)
    TextView nombre;

    @View(com.example.examen.R.id.imgPortada)
    ImageView img;

    Context contexto;

    public PlaceHolder(Context contexto){

    }
}
