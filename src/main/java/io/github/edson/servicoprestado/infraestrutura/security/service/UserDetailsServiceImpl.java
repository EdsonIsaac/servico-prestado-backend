package io.github.edson.servicoprestado.infraestrutura.security.service;

import io.github.edson.servicoprestado.infraestrutura.security.model.User;
import io.github.edson.servicoprestado.infraestrutura.service.Facade;
import io.github.edson.servicoprestado.usuario.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final Facade facade;

    @Autowired
    public UserDetailsServiceImpl(Facade facade) {
        this.facade = facade;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Usuario usuario = facade.usuarioFindByUsuario(username);

        if (usuario == null) {
            throw new UsernameNotFoundException("Usuário não encontrado!");
        }

        return new User(
            usuario.getId(),
            usuario.getUsuario(),
            usuario.getSenha(),
            usuario.getPerfis().stream().map(x -> new SimpleGrantedAuthority(x.getDescription())).collect(Collectors.toList())
        );
    }
}