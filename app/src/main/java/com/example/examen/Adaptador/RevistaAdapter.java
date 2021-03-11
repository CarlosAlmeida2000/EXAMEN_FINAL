package com.example.examen.Adaptador;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.examen.Modelos.Revista;
import com.example.examen.R;

import java.util.List;

public class RevistaAdapter extends RecyclerView.Adapter<RevistaAdapter.RevistaViewHolder>  {

    private Context Ctx;
    private List<Revista> lstRevistas;

    public RevistaAdapter(Context ctx, List<Revista> lstRevistas) {
        Ctx = ctx;
        this.lstRevistas = lstRevistas;
    }

    @NonNull
    @Override
    public RevistaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(Ctx);
        View view = inflater.inflate(R.layout.item_revista, null);
        return new RevistaViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RevistaViewHolder holder, int position) {
        Revista revista = lstRevistas.get(position);
        holder.txtName.setText(revista.getTitulo());
        holder.txtInferior.setText(revista.getDescripcion());

        Glide.with(Ctx).load(revista.getUrlPerfil()).into(holder.imgPerfil);
    }

    @Override
    public int getItemCount() {
        return lstRevistas.size();
    }

    public class RevistaViewHolder extends RecyclerView.ViewHolder {
        TextView txtName, txtInferior;
        ImageView imgPerfil;
        public RevistaViewHolder(@NonNull View itemView) {
            super(itemView);

            txtName = itemView.findViewById(R.id.txtName);
            txtInferior = itemView.findViewById(R.id.txtInferior);
            imgPerfil = itemView.findViewById(R.id.imgPerfil);

        }
    }
}
