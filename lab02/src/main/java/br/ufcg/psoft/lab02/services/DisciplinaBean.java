package br.ufcg.psoft.lab02.services;

import br.ufcg.psoft.lab02.models.Disciplina;
import br.ufcg.psoft.lab02.repositories.DisciplinaRepository;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLOutput;
import java.util.List;

@Service
public class DisciplinaBean implements DisciplinaService {

    @Autowired
    private DisciplinaRepository<Disciplina, Long> disciplinaRepository;

    private final String LINE_SEPARATOR = System.getProperty(System.lineSeparator());

    @PostConstruct
    public void initDisciplina(){
        ObjectMapper mapper = new ObjectMapper();
        TypeReference<List<Disciplina>> typeReference = new TypeReference<List<Disciplina>>() {};
        InputStream inputStream = ObjectMapper.class.getResourceAsStream("/json/disciplinas.json");
        try{
            List<Disciplina> disciplinas = mapper.readValue(inputStream, typeReference);
            this.disciplinaRepository.saveAll(disciplinas);
            System.out.println("Disciplinas salvas no BD");
        }catch (IOException e){
            System.out.println("Não foi possivel salvar a disciplina" + e.getMessage());
        }
    }

    @Override
    public Disciplina pegaDisciplina(Long id) {
        return this.disciplinaRepository.findById(id).get();
    }

    @Override
    public List<Disciplina> listaDisciplinas() {
        return this.disciplinaRepository.findAll();
    }

    @Override
    public Disciplina adicionaDisciplina(Disciplina disciplina) {
        return this.disciplinaRepository.save(disciplina);
    }

    @Override
    public Disciplina atualizaNota(Long id, double nota) {
        Disciplina disciplina = this.disciplinaRepository.findById(id).get();
        disciplina.setNota(nota);
        return this.disciplinaRepository.save(disciplina);
    }

    @Override
    public Disciplina adicionaComentario(Long id, String comentario) {
        Disciplina disciplina = this.disciplinaRepository.findById(id).get();
        if(disciplina.getComentarios() == null){
            disciplina.setComentarios(comentario);
        }else{
            disciplina.setComentarios(disciplina.getComentarios() + LINE_SEPARATOR + comentario);
        }
        return this.disciplinaRepository.save(disciplina);
    }

    @Override
    public Disciplina incrementaLikes(Long id) {
        Disciplina disciplina = this.disciplinaRepository.findById(id).get();
        disciplina.setLikes(disciplina.getLikes()+1);
        return this.disciplinaRepository.save(disciplina);
    }

    @Override
    public List<Disciplina> listaDisciplinasPorNota() {
        return this.disciplinaRepository.findAllDisciplinaByOrderByNotaDesc();
    }

    @Override
    public List<Disciplina> listaDisciplinaPorLike() {
        return this.disciplinaRepository.findAllDisciplinaByOrderByLikesDesc();
    }

    @Override
    public void deletaDisciplina(Long id) {
        this.disciplinaRepository.deleteById(id);
    }


}