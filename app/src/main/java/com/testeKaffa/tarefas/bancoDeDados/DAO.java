package com.testeKaffa.tarefas.bancoDeDados;

import com.testeKaffa.tarefas.Model.Tarefa;

import java.util.List;

public class DAO implements InterfaceDAO{

    @Override
    public boolean salvar(Tarefa tarefa) {
        return false;
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
