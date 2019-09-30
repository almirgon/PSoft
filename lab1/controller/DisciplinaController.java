package br.ufcg.psoft.lab1.controller;

import br.ufcg.psoft.lab1.dto.AtualizaNotaDto;
import br.ufcg.psoft.lab1.dto.AtualizarNomeDto;
import br.ufcg.psoft.lab1.model.Disciplina;
import br.ufcg.psoft.lab1.service.DisciplinaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping("/v1/api/disciplinas")
public class DisciplinaController {

    @Autowired
    private DisciplinaService disciplinaService;

    @GetMapping
    public ResponseEntity<List<Disciplina>> todas(){
        return ResponseEntity.ok(disciplinaService.pegaTodas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Disciplina> umaDisciplina(Long id){
        return ResponseEntity.ok(disciplinaService.get(id));
    }

    @PostMapping
    public ResponseEntity<Disciplina> criaDisciplina(@RequestBody Disciplina disciplina){
        Disciplina retorno = disciplinaService.criaDisciplina(disciplina);
        return ResponseEntity.ok(retorno);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Disciplina> deleta(@PathVariable Long id){
        return ResponseEntity.ok(disciplinaService.removeDisciplina(id));
    }

    @PutMapping("/{id}/nome")
    public ResponseEntity<Disciplina> setNome(@PathVariable Long id, @RequestBody AtualizarNomeDto nome){
        return ResponseEntity.ok(disciplinaService.atualizaNome(id, nome.getNome()));
    }

    @PutMapping("/{id}/nota")
    public ResponseEntity<Disciplina> setNota(@PathVariable Long id, @RequestBody AtualizaNotaDto nota){
        return ResponseEntity.ok((disciplinaService.atualizaNota(id, nota.getNota())));
    }







}
