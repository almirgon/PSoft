package br.ufcg.psoft.lab1.dto;

import java.io.Serializable;

public class AtualizaNotaDto implements Serializable {

    private double nota;


    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }
}
