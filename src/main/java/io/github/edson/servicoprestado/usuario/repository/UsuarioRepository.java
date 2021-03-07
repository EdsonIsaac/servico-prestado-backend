package io.github.edson.servicoprestado.usuario.repository;

import io.github.edson.servicoprestado.usuario.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    public Usuario findByUsuario (String usuario);
}