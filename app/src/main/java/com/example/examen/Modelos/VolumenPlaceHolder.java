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
@Layout(R.layout.volumen)
public class VolumenPlaceHolder {

    @View(R.id.txtTitle)
    TextView title;

    @View(R.id.txtDataPublished)
    TextView dataPublished;

    @View(R.id.txtDoi)
    TextView doi;

    @View(R.id.txtVolume)
    TextView volume;

    @View(R.id.txtYear)
    TextView year;

    @View(R.id.txtNumber)
    TextView number;

    @View(R.id.txtIssue_id)
    TextView ussue_id;

    @View(R.id.imgCover)
    ImageView cover;

    Context contexto;
    JSONObject lstVolumenes;

    public VolumenPlaceHolder(Context contexto, JSONObject lstVolumenes) {
        this.contexto = contexto;
        this.lstVolumenes = lstVolumenes;
    }
    @Resolve
    protected  void onResolved(){
        try {
            this.title.setText(lstVolumenes.getString("title"));
            this.dataPublished.setText(lstVolumenes.getString("date_published"));
            this.doi.setText(lstVolumenes.getString("doi"));
            this.volume.setText(lstVolumenes.getString("volume"));
            this.year.setText(lstVolumenes.getString("year"));
            this.number.setText(lstVolumenes.getString("number"));
            this.ussue_id.setText(lstVolumenes.getString("ussue_id"));
            Glide.with(this.contexto).load(lstVolumenes.getString("cover")).into(this.cover);
        }catch (JSONException e){
        }
    }
}
