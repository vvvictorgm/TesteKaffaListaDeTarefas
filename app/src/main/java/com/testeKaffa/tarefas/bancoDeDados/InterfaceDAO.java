package com.testeKaffa.tarefas.bancoDeDados;

import com.testeKaffa.tarefas.Model.Tarefa;

import java.util.List;

public interface InterfaceDAO {
    public boolean salvar(Tarefa tarefa);
    public boolean atualizar(Tarefa tarefa);
    public boolean deletar(Tarefa tarefa);
    public List<Tarefa> listar();


}
