package com.testeKaffa.tarefas.Activity;

import android.content.ContentValues;
import android.content.Intent;
import android.os.Bundle;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.testeKaffa.tarefas.Adapter.TarefaAdapter;
import com.testeKaffa.tarefas.Model.Tarefa;
import com.testeKaffa.tarefas.R;
import com.testeKaffa.tarefas.bancoDeDados.DAO;
import com.testeKaffa.tarefas.bancoDeDados.DbHelper;
import com.testeKaffa.tarefas.biblioteca.RecyclerItemClickListener;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;

import java.util.ArrayList;
import java.util.List;

public class  MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private TarefaAdapter tarefaAdapter;
    private List<Tarefa> listaTarefas = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //Configure of RecyclerView
        //first, find the recyclerview in the window
        recyclerView = findViewById(R.id.recyclerListaDeTarefas);


        //add the click
        recyclerView.addOnItemTouchListener(
                new RecyclerItemClickListener(getApplicationContext(), recyclerView, new RecyclerItemClickListener.OnItemClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {
                        //we have to recover the task to edit
                        Tarefa tarefaSelecionada = listaTarefas.get(position);
                        //send the task to screen of add task
                        Intent intent = new Intent(MainActivity.this, AdicionarTarefa.class);
                        intent.putExtra("tarefaSelecionada", tarefaSelecionada);

                        startActivity(intent);

                    }

                    @Override
                    public void onLongItemClick(View view, int position) {

                    }

                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                    }
                })
        );

       FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //when you click on the FloatingActionButton, you go to layout AdicionarTarefa
                Intent intent = new Intent(getApplicationContext(), AdicionarTarefa.class);
                startActivity(intent);
            }
        });
    }
    //this funcition will load all the list
    public void carregarListaDeTarefas(){
        //list Tasks
        DAO dao = new DAO(getApplicationContext());
        listaTarefas = dao.listar();


        //instance the object

        //configure RecyclerView
        //we use LinearLayout because it's perfect for us in this app about lists
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        //set the size for fixed
        recyclerView.setHasFixedSize(true);
        recyclerView.addItemDecoration(new DividerItemDecoration(getApplicationContext(),LinearLayoutManager.VERTICAL));
        //use the adapter
        recyclerView.setAdapter(tarefaAdapter);
    }

    @Override
    //when the app starts will load the list of tasks
    protected void onStart() {
        carregarListaDeTarefas();
        super.onStart();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
