package com.testeKaffa.tarefas.bancoDeDados;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.testeKaffa.tarefas.Model.Tarefa;

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
