package br.ufcg.psoft.lab02.services;

import br.ufcg.psoft.lab02.models.Usuario;

public interface UsuarioService {

    Usuario buscaUsuario(String email);

    Usuario adicionaUsuario(Usuario usuario);

    void removeUsuario();

}
