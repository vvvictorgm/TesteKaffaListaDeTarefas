package com.testeKaffa.tarefas.Model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Tarefa implements Serializable {
    private Long id;
    private String nomeTarefa;
    private List<Tarefa> listaTarefas = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeTarefa() {
        return nomeTarefa;
    }

    public void setNomeTarefa(String nomeTarefa) {
        this.nomeTarefa = nomeTarefa;
    }
}
