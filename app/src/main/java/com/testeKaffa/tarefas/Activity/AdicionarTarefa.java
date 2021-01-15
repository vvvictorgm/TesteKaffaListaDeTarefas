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
        switch (item.getItemId()){
            case R.id.itemSalvar:
                //for database update and modification
                DAO dao = new DAO(getApplicationContext());
                if(tarefaAtual != null) { //edition
                    String nomeTarefa = editTarefa.getText().toString();
                    //when the user click in " save" use DAO for edit
                    if( !nomeTarefa.isEmpty()) {
                        Tarefa tarefa = new Tarefa();
                        tarefa.setNomeTarefa(nomeTarefa);
                        tarefa.setId(tarefaAtual.getId());
                    //uptade de DB
                        if(dao.atualizar(tarefa)){
                            finish();
                            Toast.makeText(getApplicationContext(), "Tarefa atualizada com sucesso", Toast.LENGTH_SHORT).show();
                        }else{
                            Toast.makeText(getApplicationContext(), "Erro ao atualizada com sucesso", Toast.LENGTH_SHORT).show();

                        }
                    }

                }else{//save

                String nomeTarefa = editTarefa.getText().toString();
                //when the user click in " save" use DAO for save
                if( !nomeTarefa.isEmpty()) {
                    Tarefa tarefa = new Tarefa();
                    tarefa.setNomeTarefa(nomeTarefa);
                    if (dao.salvar(tarefa)) {
                        finish();
                        Toast.makeText(getApplicationContext(), "Tarefa salva com sucesso", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(getApplicationContext(), "Erro ao salvar tarefa", Toast.LENGTH_SHORT).show();

                    }
                }



                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
