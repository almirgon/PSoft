package br.ufcg.psoft.lab02.services;

import br.ufcg.psoft.lab02.models.Usuario;
import br.ufcg.psoft.lab02.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class UsuarioBean implements UsuarioService{

    @Autowired
    private UsuarioRepository<Usuario, String> usuarioRepository;

    @Override
    public Usuario buscaUsuario(String email) {
        return this.usuarioRepository.findById(email).get();
    }

    @Override
    public Usuario adicionaUsuario(Usuario usuario) {
        return this.usuarioRepository.save(usuario);
    }

    @Override
    public void removeUsuario() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String nomeUsuario = authentication.getName();

        this.usuarioRepository.deleteById(nomeUsuario);

    }


}
