package br.ufcg.psoft.lab02.controllers;

import br.ufcg.psoft.lab02.models.Usuario;
import br.ufcg.psoft.lab02.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping
    public ResponseEntity<Usuario> adicionaUsuario(@RequestBody Usuario usuario){
        return new ResponseEntity<Usuario>(this.usuarioService.adicionaUsuario(usuario), HttpStatus.OK);
    }
}
