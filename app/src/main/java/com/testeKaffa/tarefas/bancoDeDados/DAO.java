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
        ContentValues cv = new ContentValues();
        cv.put("nome", tarefa.getNomeTarefa());
        try {
            String[]args ={tarefa.getId().toString()};
            salvarDadosNaTabela.update(DbHelper.TABELA_TAREFAS,cv, "id=?", args);
            Log.i("INFO DB", "Tarefa atualizada com sucesso");
        }catch (Exception e){
            Log.i("INFO DB", "Erro ao atualizar a tarefa" + e.getMessage());
            return false;
        }
        return true;
    }

    @Override
    public boolean deletar(Tarefa tarefa) {
        try {
            String[]args ={tarefa.getId().toString()};

            salvarDadosNaTabela.delete(DbHelper.TABELA_TAREFAS, "id=?", args);
            Log.i("INFO DB", "Tarefa removida com sucesso");
        }catch (Exception e){
            Log.i("INFO DB", "Erro ao remover a tarefa" + e.getMessage());
            return false;
        }
        return true;
    }

    @Override
    public List<Tarefa> listar() {
        List<Tarefa>tarefas = new ArrayList<>();

        String sql = "SELECT *FROM " + DbHelper.TABELA_TAREFAS +" ;";
        Cursor c = lerDadosNaTabela.rawQuery(sql, null);

        while(c.moveToNext()){

            Tarefa tarefa = new Tarefa();

            Long id = c.getLong(c.getColumnIndex("id"));
            String nomeTarefa = c.getString(c.getColumnIndex("nome"));

            tarefa.setId(id);
            tarefa.setNomeTarefa(nomeTarefa);

            tarefas.add(tarefa);

        }

        return tarefas;
    }

}
