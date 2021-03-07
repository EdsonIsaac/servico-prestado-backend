package io.github.edson.servicoprestado.usuario.controller;

import io.github.edson.servicoprestado.infraestrutura.service.Facade;
import io.github.edson.servicoprestado.usuario.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    private final Facade facade;

    @Autowired
    public UsuarioController(Facade facade) {
        this.facade = facade;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Usuario save (@RequestBody @Valid Usuario usuario) {
        return facade.usuarioSave(usuario);
    }
}