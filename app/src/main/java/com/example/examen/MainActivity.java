package com.example.examen;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import com.example.examen.Adaptador.RevistaAdapter;
import com.example.examen.Modelos.Revista;
import com.example.examen.WebServices.Asynchtask;
import com.example.examen.WebServices.WebService;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity implements Asynchtask {

    RecyclerView rcvRevistas;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rcvRevistas = (RecyclerView) findViewById(R.id.rcvChats);
        rcvRevistas.setHasFixedSize(true);
        rcvRevistas.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

        Map<String, String> datos = new HashMap<String, String>();
        WebService ws= new WebService("https://revistas.uteq.edu.ec/ws/journals.php", datos, getApplicationContext(), this);
        ws.execute("GET");
    }

    @Override
    public void processFinish(String result) throws JSONException {
        ArrayList<Revista> lstRevista = new ArrayList<Revista> ();
        try {
            JSONArray JSONlistaContactos = new JSONArray(result);
            lstRevista = Revista.JsonObjectsBuild(JSONlistaContactos);

            RevistaAdapter adapatorRevista = new RevistaAdapter(getApplicationContext(), lstRevista);
            rcvRevistas.setAdapter(adapatorRevista);

        }
        catch (JSONException e)
        {
            Toast.makeText(getApplicationContext(),e.getMessage(),Toast.LENGTH_LONG);
        }
    }
}