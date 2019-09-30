package br.ufcg.psoft.lab02.models;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table
public class Usuario implements Serializable {

    @Id
    @GeneratedValue
    private String email;

    @Column
    private String nome;

    @Column
    private String senha;

    public Usuario() { }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
