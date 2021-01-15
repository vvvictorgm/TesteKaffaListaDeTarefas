package com.testeKaffa.tarefas.bancoDeDados;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.testeKaffa.tarefas.Model.Tarefa;

import java.nio.DoubleBuffer;
import java.util.ArrayList;
import java.util.List;

public class DAO implements InterfaceDAO{
    private SQLiteDatabase salvarDadosNaTabela;
    private SQLiteDatabase lerDadosNaTabela;

    public DAO(Context context) {
        DbHelper db = new DbHelper(context);
        salvarDadosNaTabela = db.getWritableDatabase();
        lerDadosNaTabela = db.getReadableDatabase();
    }

    @Override
    public boolean salvar(Tarefa tarefa) {
        ContentValues cv = new ContentValues();
        cv.put("nome", tarefa.getNomeTarefa());
        try{
            salvarDadosNaTabela.insert(DbHelper.TABELA_TAREFAS, null, cv);
        }catch (Exception e){
            Log.e("AVISO", "ERRO AO SALVAR TAREFA"+ e.getMessage());
            return false;
        }
        return true;
    }

    @Override
    public boolean atualizar(Tarefa tarefa) {
        
        return true;
    }

    @Override
    public boolean deletar(Tarefa tarefa) {
        return false;
    }

    @Override
    public List<Tarefa> listar() {
       List<Tarefa> tarefas = new ArrayList<>();
       //take all the tasks
       String sql = "SELECT * FROM " +DbHelper.TABELA_TAREFAS +";";
       // now we use a cursor to navegate in DB
       Cursor c = lerDadosNaTabela.rawQuery(sql, null);

       while(c.moveToNext()){
           Tarefa tarefa = new Tarefa();

           Long id = c.getLong(c.getColumnIndex("id"));
           String nomeTarefa = c.getString(c.getColumnIndex("nome"));
           tarefa.setId(id);
           tarefa.setNomeTarefa(nomeTarefa);
           tarefas.add(tarefa);

       }



        return
    }
}
