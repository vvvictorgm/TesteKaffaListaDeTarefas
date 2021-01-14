package com.testeKaffa.tarefas.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.google.android.material.textfield.TextInputEditText;
import com.testeKaffa.tarefas.Model.Tarefa;
import com.testeKaffa.tarefas.R;
import com.testeKaffa.tarefas.bancoDeDados.DAO;

public class AdicionarTarefa extends AppCompatActivity {
private TextInputEditText editTarefa;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adicionar_tarefa);

        editTarefa = findViewById(R.id.textTarefa);
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
                //when the user click in " save" use DAO for save
                DAO dao = new DAO(getApplicationContext());
                Tarefa  tarefa = new Tarefa();
                tarefa.setNomeTarefa("teste");
                dao.salvar(tarefa);



                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
