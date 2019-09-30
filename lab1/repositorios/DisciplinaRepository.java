package br.ufcg.psoft.lab1.repository;

import br.ufcg.psoft.lab1.model.Disciplina;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component //Componente que fornece servicos ao software
public class DisciplinaRepository {

    private Map<Long, Disciplina> disciplinas = new HashMap();
    private Long geradorDeId = 0L;


    public Disciplina getDisciplina(Long id){
       return this.disciplinas.get(id);
    }

    public Disciplina criaDisciplina(Disciplina disciplina){
        disciplina.setId(geradorDeId);
        this.disciplinas.putIfAbsent(geradorDeId,disciplina);
        geradorDeId += 1;
        return  disciplina;

    }

    public Disciplina deletaDisciplina(Long id){
        return this.disciplinas.remove(id);
    }

    public Disciplina atualizaDisciplina(Long id, Disciplina disciplina){
        return this.disciplinas.put(id, disciplina);
    }

    public List<Disciplina> getAllDisciplinas(){

        ArrayList<Disciplina> lista = new ArrayList<>();

        for (Disciplina disciplina: disciplinas.values()){
            lista.add(disciplina);
        }

        return lista;

    }

}
