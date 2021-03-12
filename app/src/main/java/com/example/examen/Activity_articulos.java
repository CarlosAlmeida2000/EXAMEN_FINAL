package com.example.examen;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.example.examen.Modelos.ArticuloPlaceHolder;
import com.example.examen.Modelos.VolumenPlaceHolder;
import com.example.examen.WebServices.Asynchtask;
import com.example.examen.WebServices.WebService;
import com.mindorks.placeholderview.PlaceHolderView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class Activity_articulos extends AppCompatActivity implements Asynchtask {

    String articulo_id;
    PlaceHolderView phv_Articulos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_articulos);
        Bundle b = this.getIntent().getExtras();
        this.articulo_id = b.getString("issue_id");

        this.phv_Articulos = findViewById(R.id.phv_articulos);
        Map<String, String> datos = new HashMap<String, String>();
        WebService ws= new WebService("https://revistas.uteq.edu.ec/ws/pubs.php?i_id=78", datos, Activity_articulos.this, Activity_articulos.this);
        ws.execute("GET");
    }
    @Override
    public void processFinish(String result) throws JSONException {
        try{
            JSONArray datos = new JSONArray(result);
            for(int i=0;i<datos.length();i++){
                JSONObject articulo = datos.getJSONObject(i);
                this.phv_Articulos.addView(new ArticuloPlaceHolder(getApplicationContext(), articulo));
            }
        }catch (JSONException e){
        }
    }
}