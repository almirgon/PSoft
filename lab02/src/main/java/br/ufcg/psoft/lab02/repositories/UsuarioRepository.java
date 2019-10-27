package br.ufcg.psoft.lab02.repositories;

import br.ufcg.psoft.lab02.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.io.Serializable;

public interface UsuarioRepository<T, ID extends Serializable> extends JpaRepository<Usuario, String> {
}
