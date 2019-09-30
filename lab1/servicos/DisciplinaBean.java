package br.ufcg.psoft.lab1.service;

import br.ufcg.psoft.lab1.model.Disciplina;
import br.ufcg.psoft.lab1.repository.DisciplinaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DisciplinaBean implements DisciplinaService{

    @Autowired
    private DisciplinaRepository repositorio;

    @Override
    public Disciplina get(Long id) {
        return this.repositorio.getDisciplina(id);
    }

    @Override
    public Disciplina removeDisciplina(Long id) {
        return this.repositorio.deletaDisciplina(id);
    }

    @Override
    public List<Disciplina> pegaTodas() {
        return this.repositorio.getAllDisciplinas();
    }

    @Override
    public Disciplina atualizaDisciplina(Long id, Disciplina disciplina) {
        return this.repositorio.atualizaDisciplina(id, disciplina);
    }

    @Override
    public Disciplina criaDisciplina(Disciplina disciplina){
        return this.repositorio.criaDisciplina(disciplina);
    }

    @Override
    public Disciplina atualizaNome(Long id, String nome) {
       Disciplina pega = this.repositorio.getDisciplina(id);
       pega.setNome(nome);
       return this.repositorio.atualizaDisciplina(id, pega);
    }

    @Override
    public Disciplina atualizaNota(Long id, Double nota) {
        Disciplina pega = this.repositorio.getDisciplina(id);
        pega.setNota(nota);
        return this.repositorio.atualizaDisciplina(id, pega);
    }
}
