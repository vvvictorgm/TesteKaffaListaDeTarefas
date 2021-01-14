package com.testeKaffa.tarefas.Adapter;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class TarefaAdapeter extends RecyclerView.Adapter<TarefaAdapeter.MyViewHolder> {
    //constructor
    public TarefaAdapeter() {
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        //constructor super
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
