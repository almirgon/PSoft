package br.ufcg.psoft.lab02.services;

import br.ufcg.psoft.lab02.models.Usuario;

public interface UsuarioService {

    Usuario adicionaUsuario(Usuario usuario);

    void removeUsuario(Usuario usuario);

}
