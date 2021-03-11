package com.example.examen.Adaptador;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.examen.Modelos.Revista;

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
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RevistaViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class RevistaViewHolder extends RecyclerView.ViewHolder {

        public RevistaViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
