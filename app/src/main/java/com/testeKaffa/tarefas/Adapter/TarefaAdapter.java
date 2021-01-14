package com.testeKaffa.tarefas.Adapter;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.testeKaffa.tarefas.Model.Tarefa;

import java.util.List;

public class TarefaAdapter extends RecyclerView.Adapter<TarefaAdapter.MyViewHolder> {
    private List<Tarefa> listaDeTarefas;
    //constructor, to iniciate this class we have to pass a List with tasks
    public TarefaAdapter(List<Tarefa> lista) {
        this.listaDeTarefas = lista;
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
