package br.ufcg.psoft.lab02.models;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table
public class Disciplina implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String nome;

    @Column
    private double nota;

    @Column
    private String comentarios;

    @Column
    private int likes;

    public Disciplina() { }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }

    public String getComentarios() {
        return comentarios;
    }

    public void setComentarios(String comentarios) {
        this.comentarios = comentarios;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }
}
