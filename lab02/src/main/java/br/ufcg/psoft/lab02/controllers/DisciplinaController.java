package br.ufcg.psoft.lab02.controllers;

import br.ufcg.psoft.lab02.dto.AtualizaComentarioDto;
import br.ufcg.psoft.lab02.dto.AtualizaNotaDto;
import br.ufcg.psoft.lab02.models.Disciplina;
import br.ufcg.psoft.lab02.services.DisciplinaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api/disciplinas")
public class DisciplinaController {

    @Autowired
    private DisciplinaService disciplinaService;

    @GetMapping("/{id}")
    public ResponseEntity<Disciplina> buscaDisciplina(@PathVariable Long id){
       try{
           return new ResponseEntity<Disciplina>(disciplinaService.pegaDisciplina(id), HttpStatus.OK);
       }catch (NoSuchElementException e){
           return new ResponseEntity<>(HttpStatus.NOT_FOUND);
       }
    }

    @GetMapping
    public ResponseEntity<List<Disciplina>> listaTodas(){
        return new ResponseEntity<List<Disciplina>>(disciplinaService.listaDisciplinas(), HttpStatus.OK);
    }

    @GetMapping("/ranking/notas")
    public ResponseEntity<List<Disciplina>> rankingPorNota(){
        return new ResponseEntity<List<Disciplina>>(disciplinaService.listaDisciplinasPorNota(), HttpStatus.OK);
    }

    @GetMapping("/ranking/likes")
    public ResponseEntity<List<Disciplina>> rankingPorLike(){
        return new ResponseEntity<List<Disciplina>>(disciplinaService.listaDisciplinaPorLike(), HttpStatus.OK);
    }

    @PutMapping("/api/disciplinas/nota/{id}")
    public ResponseEntity<Disciplina> setNota(@PathVariable Long id, @RequestBody AtualizaNotaDto nota){
        return new ResponseEntity<Disciplina>(disciplinaService.atualizaNota(id,nota.getNota()), HttpStatus.OK);
    }

    @PutMapping("/api/disciplinas/likes/{id}")
    public ResponseEntity<Disciplina> setLikes(@PathVariable Long id){
        return new ResponseEntity<Disciplina>(disciplinaService.incrementaLikes(id),HttpStatus.OK);
    }

    @PutMapping("/comentarios/{id}")
    public ResponseEntity<Disciplina> setComenatio(@PathVariable Long id, @RequestBody AtualizaComentarioDto comentario){
        return new ResponseEntity<Disciplina>(disciplinaService.adicionaComentario(id, comentario.getComentario()), HttpStatus.OK);
    }


}
