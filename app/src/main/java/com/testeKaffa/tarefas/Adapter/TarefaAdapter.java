package com.testeKaffa.tarefas.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.testeKaffa.tarefas.Model.Tarefa;
import com.testeKaffa.tarefas.R;

import java.util.List;

public class TarefaAdapter extends RecyclerView.Adapter<TarefaAdapter.MyViewHolder> {
    private List<Tarefa> listaDeTarefas;
    //constructor, to iniciate this cl ass we have to pass a List with tasks
    public TarefaAdapter(List<Tarefa> lista) {
        this.listaDeTarefas = lista;
    }

    @NonNull
    @Override
    //ret
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemLista = LayoutInflater.from(parent.getContext()).
                inflate(R.layout.lista_tarefa_adapter,parent,false);
        return new MyViewHolder(itemLista);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        //create a objet to get the item
        Tarefa tarefa = listaDeTarefas.get(position);
        //then we set the name of the task
        holder.tarefa.setText(tarefa.getNomeTarefa());
    }

    @Override
    //this function is for count the number of the items on the list
    public int getItemCount() {
        return this.listaDeTarefas.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        TextView tarefa;
        //constructor super
        public MyViewHolder(@NonNull View itemView) {

            super(itemView);
            //recieve the itemview and find in the layout
            tarefa = itemView.findViewById(R.id.textTarefa);
        }


    }
}
