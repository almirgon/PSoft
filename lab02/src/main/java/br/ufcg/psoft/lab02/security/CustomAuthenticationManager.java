package br.ufcg.psoft.lab02.security;

import br.ufcg.psoft.lab02.models.Usuario;
import br.ufcg.psoft.lab02.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Service;

@Service
public class CustomAuthenticationManager implements AuthenticationManager {

    @Autowired
    private UsuarioService usuarioService;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String email = authentication.getName();
        String password = authentication.getCredentials().toString();

        Usuario usuario = usuarioService.buscaUsuario(email);

        if (usuario == null) {
            throw new BadCredentialsException("Não existe usuário com esse email");
        }
        if (usuario.getSenha().equals(password)) {
            return new UsernamePasswordAuthenticationToken(email, password);
        }
        return null;
    }
}
