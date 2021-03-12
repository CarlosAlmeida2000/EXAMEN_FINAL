package com.example.examen;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.examen.Modelos.VolumenPlaceHolder;
import com.example.examen.WebServices.Asynchtask;
import com.example.examen.WebServices.WebService;
import com.mindorks.placeholderview.PlaceHolderView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class Activity_volumen extends AppCompatActivity implements Asynchtask {

    String volumen_id;
    PlaceHolderView phv_Volumenes;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_volumen);
        Bundle b = this.getIntent().getExtras();
        this.volumen_id = b.getString("journal_id");
        this.phv_Volumenes = findViewById(R.id.phv_volumenes);
        Map<String, String> datos = new HashMap<String, String>();
        WebService ws= new WebService("https://revistas.uteq.edu.ec/ws/issues.php?j_id="+this.volumen_id, datos, Activity_volumen.this, Activity_volumen.this);
        ws.execute("GET");
    }

    @Override
    public void processFinish(String result) throws JSONException {
        try{
            JSONArray datos = new JSONArray(result);
            for(int i=0;i<datos.length();i++){
                JSONObject volumen = datos.getJSONObject(i);
                this.phv_Volumenes.addView(new VolumenPlaceHolder(getApplicationContext(), volumen));
            }
        }catch (JSONException e){
        }
    }
}