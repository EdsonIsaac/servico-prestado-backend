package io.github.edson.servicoprestado.usuario.service;

import io.github.edson.servicoprestado.infraestrutura.exception.ObjectNotFoundException;
import io.github.edson.servicoprestado.infraestrutura.exception.ValidationException;
import io.github.edson.servicoprestado.usuario.model.Usuario;
import io.github.edson.servicoprestado.usuario.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final BCryptPasswordEncoder encoder;

    @Autowired
    public UsuarioService(UsuarioRepository usuarioRepository, BCryptPasswordEncoder encoder) {
        this.usuarioRepository = usuarioRepository;
        this.encoder = encoder;
    }

    public Usuario findById (Long id) {
        return usuarioRepository.findById(id).orElseThrow(() -> {
            throw new ObjectNotFoundException("Usuário não encontrado!");
        });
    }

    public Usuario findByUsuairo (String usuario) {
        return usuarioRepository.findByUsuario(usuario);
    }

    public Usuario save (Usuario usuario) {

        if (usuario == null) {
            throw new ValidationException("Usuário nulo!");
        }

        if (validarUsuario(usuario)) {
            usuarioRepository.save(usuario);
        }

        return usuario;
    }

    public Usuario update (Usuario usuario) {

        if (usuario == null) {
            throw new ValidationException("Usuário nulo!");
        }

        if (!usuarioRepository.existsById(usuario.getId())) {
            throw new ObjectNotFoundException("Usuário não encontrado!");
        }

        if (validarUsuario(usuario)) {
            usuarioRepository.save(usuario);
        }

        return usuario;
    }

    public void delete (Usuario usuario) {

        if (usuario == null) {
            throw new ValidationException("Usuário nulo!");
        }

        if (!usuarioRepository.existsById(usuario.getId())) {
            throw new ObjectNotFoundException("Usuário não encontrado!");
        }

        usuarioRepository.delete(usuario);
    }

    private boolean validarUsuario(Usuario usuario) {

        Usuario usuario_findByUsuario = usuarioRepository.findByUsuario(usuario.getUsuario());

        if (usuario_findByUsuario != null && !usuario_findByUsuario.equals(usuario)) {
            throw new ValidationException("Usuário já cadastrado!");
        }

        if (usuario.getId() != null) {
            Usuario usuario_findById = usuarioRepository.findById(usuario.getId()).orElse(null);

            if (!usuario.getSenha().equals(usuario_findById.getSenha())) {
                usuario.setSenha(encoder.encode(usuario.getSenha()));
            }
        } else {
            usuario.setSenha(encoder.encode(usuario.getSenha()));
        }

        return true;
    }
}