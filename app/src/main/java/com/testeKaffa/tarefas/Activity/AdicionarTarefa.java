 package com.testeKaffa.tarefas.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.testeKaffa.tarefas.Model.Tarefa;
import com.testeKaffa.tarefas.R;
import com.testeKaffa.tarefas.bancoDeDados.DAO;

public class AdicionarTarefa extends AppCompatActivity {
private TextInputEditText editTarefa;
private Tarefa tarefaAtual;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adicionar_tarefa);

        editTarefa = findViewById(R.id.textTarefa);

        //recover the taks if it's edition
        //we have to Cast (Tarefa) because it get a Serializable
        tarefaAtual = (Tarefa) getIntent().getSerializableExtra("tarefaSelecionada");

        //if tarefaAtual it's not null, so have something, and in that case is to edit it
        if(tarefaAtual != null){
            editTarefa.setText(tarefaAtual.getNomeTarefa());
            }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_adicionar_tarefa, menu);
        return super.onCreateOptionsMenu(menu);
    }

    //make  when click im save botton
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        DAO dao = new DAO(getApplicationContext());
        switch (item.getItemId()){


            case R.id.itemSalvar:

                //for database update and modification
                if(tarefaAtual != null){//estou editando uma tarefa
                    String nomeTarefa = editTarefa.getText().toString();
                    if (!nomeTarefa.isEmpty()) {
                        Tarefa tarefa = new Tarefa();
                        tarefa.setNomeTarefa(nomeTarefa);
                        tarefa.setId(tarefaAtual.getId());
                        //updated
                        if(dao.atualizar(tarefa)){
                            finish();
                            Toast.makeText(getApplicationContext(), "Sucesso ao atualizar a tarefa", Toast.LENGTH_SHORT).show();
                        }else{
                            Toast.makeText(getApplicationContext(), "Erro ao atualizar a tarefa", Toast.LENGTH_SHORT).show();
                        }
                    }
                }else {
                    //save
                    String nomeTarefa = editTarefa.getText().toString();
                    if (!nomeTarefa.isEmpty()) {
                        Tarefa tarefa = new Tarefa();
                        tarefa.setNomeTarefa(nomeTarefa);
                        if(dao.salvar(tarefa)){
                            finish();
                            Toast.makeText(getApplicationContext(), "Sucesso ao salvar nova tarefa", Toast.LENGTH_SHORT).show();
                        }else{
                            Toast.makeText(getApplicationContext(), "Erro ao salvar nova tarefa", Toast.LENGTH_SHORT).show();
                        }
                    }
                }
                break;
        }
        return super.onOptionsItemSelected(item);

    }
}
