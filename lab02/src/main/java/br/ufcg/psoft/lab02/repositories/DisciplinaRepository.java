package br.ufcg.psoft.lab02.repositories;

import br.ufcg.psoft.lab02.models.Disciplina;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

@Repository
public interface DisciplinaRepository<T, ID extends Serializable> extends JpaRepository<Disciplina, Long> {

    List<Disciplina> findAllDisciplinaByOrderByNotaDesc();

    List<Disciplina> findAllDisciplinaByOrderByLikesDesc();
}
