package br.ufcg.psoft.lab1.dto;

import java.io.Serializable;

public class AtualizarNomeDto implements Serializable {

    private String nome;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
