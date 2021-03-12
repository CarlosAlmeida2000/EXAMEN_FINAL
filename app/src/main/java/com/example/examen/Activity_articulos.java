package com.example.examen;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.examen.WebServices.Asynchtask;
import com.example.examen.WebServices.WebService;
import com.mindorks.placeholderview.PlaceHolderView;

import org.json.JSONException;

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
        this.phv_Articulos = findViewById(R.id.phv_volumenes);
        Map<String, String> datos = new HashMap<String, String>();
        WebService ws= new WebService("https://revistas.uteq.edu.ec/ws/pubs.php?i_id=78"+this.articulo_id, datos, Activity_articulos.this, Activity_articulos.this);
        ws.execute("GET");
    }
    @Override
    public void processFinish(String result) throws JSONException {

    }
}