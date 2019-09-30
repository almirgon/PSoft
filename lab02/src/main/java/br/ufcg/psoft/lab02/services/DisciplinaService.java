package br.ufcg.psoft.lab02.services;

import br.ufcg.psoft.lab02.models.Disciplina;

import java.util.List;

public interface DisciplinaService {

     Disciplina pegaDisciplina(Long id);

     List<Disciplina> listaDisciplinas();

     Disciplina adicionaDisciplina(Disciplina disciplina);

     Disciplina atualizaNota(Long id, double nota);

     Disciplina adicionaComentario(Long id, String comentario);

     Disciplina incrementaLikes(Long id);

     List<Disciplina> listaDisciplinasPorNota();

     List<Disciplina> listaDisciplinaPorLike();

     void deletaDisciplina(Long id);

}
