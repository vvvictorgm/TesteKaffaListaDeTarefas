package com.testeKaffa.tarefas.bancoDeDados;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.testeKaffa.tarefas.Model.Tarefa;

import java.nio.DoubleBuffer;
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
        cv.put("nome", "teste");
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
        return false;
    }

    @Override
    public boolean deletar(Tarefa tarefa) {
        return false;
    }

    @Override
    public List<Tarefa> listar() {
        return null;
    }
}
