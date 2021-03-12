package com.example.examen.Modelos;

import android.content.Context;
import android.widget.TextView;

import com.example.examen.R;
import com.mindorks.placeholderview.annotations.Layout;
import com.mindorks.placeholderview.annotations.NonReusable;
import com.mindorks.placeholderview.annotations.Resolve;
import com.mindorks.placeholderview.annotations.View;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@NonReusable
@Layout(R.layout.articulo)
public class ArticuloPlaceHolder {

    @View(R.id.txtTitle)
    TextView title;
    @View(R.id.txtAuthors)
    TextView authors;
    @View(R.id.btnPDF)
    TextView PDF;
    @View(R.id.btnHTML)
    TextView HTML;

    Context contexto;
    JSONObject lstArticulos;
    JSONArray jsonAuthors;
    String strAuthors="";

    public ArticuloPlaceHolder(Context contexto, JSONObject lstArticulos) {
        this.contexto = contexto;
        this.lstArticulos = lstArticulos;
    }

    @Resolve
    protected void onResolve(){
        try {
            title.setText(lstArticulos.getString("title"));

            jsonAuthors = lstArticulos.getJSONArray("authors");
            for (int i = 0; i < jsonAuthors.length(); i++){
                strAuthors +=  jsonAuthors.getJSONObject(i).getString("nombres") + " ";
            }
            this.authors.setText(strAuthors);
        }catch (JSONException e){
        }
    }
}
