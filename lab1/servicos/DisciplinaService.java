package br.ufcg.psoft.lab1.service;


import br.ufcg.psoft.lab1.model.Disciplina;

import java.util.List;

public interface DisciplinaService {

    Disciplina get(Long id);

    Disciplina atualizaDisciplina(Long id, Disciplina disciplina);

    Disciplina removeDisciplina(Long id);

    List<Disciplina> pegaTodas();

    Disciplina criaDisciplina(Disciplina disciplina);

    Disciplina atualizaNome(Long id, String nome);

    Disciplina atualizaNota(Long id, Double nota);

}
