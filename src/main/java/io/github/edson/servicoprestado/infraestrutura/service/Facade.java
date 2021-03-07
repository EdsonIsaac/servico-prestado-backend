package io.github.edson.servicoprestado.infraestrutura.service;

import io.github.edson.servicoprestado.cliente.model.Cliente;
import io.github.edson.servicoprestado.cliente.service.ClienteService;
import io.github.edson.servicoprestado.servico.model.Servico;
import io.github.edson.servicoprestado.servico.service.ServicoService;
import io.github.edson.servicoprestado.usuario.model.Usuario;
import io.github.edson.servicoprestado.usuario.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Facade {

    @Autowired
    private ClienteService clienteService;

    @Autowired
    private ServicoService servicoService;

    @Autowired
    private UsuarioService usuarioService;

    /************************************************ CLIENTE ************************************************/

    public Cliente clienteFindById (Long id) {
        return clienteService.findById(id);
    }

    public List<Cliente> clienteFindAll () {
        return clienteService.findAll();
    }

    public Cliente clienteSave (Cliente cliente) {
        return clienteService.save(cliente);
    }

    public Cliente clienteUpdate (Cliente cliente) {
        return clienteService.update(cliente);
    }

    public void clienteDelete (Cliente cliente) {
        clienteService.delete(cliente);
    }

    /************************************************ SERVIÇO ************************************************/

    public Servico servicoFindById (Long id) {
        return servicoService.findById(id);
    }

    public List<Servico> servicoFindAll () {
        return servicoService.findAll();
    }

    public Servico servicoSave (Servico servico) {
        return servicoService.save(servico);
    }

    public Servico servicoUpdate (Servico servico) {
        return servicoService.update(servico);
    }

    public void servicoDelete (Servico servico) {
        servicoService.delete(servico);
    }

    /************************************************ USUÁRIO ************************************************/

    public Usuario usuarioFindById (Long id) {
        return usuarioService.findById(id);
    }

    public Usuario usuarioFindByUsuario (String usuario) {
        return usuarioService.findByUsuairo(usuario);
    }

    public Usuario usuarioSave (Usuario usuario) {
        return usuarioService.save(usuario);
    }

    public Usuario usuarioUpdate (Usuario usuario) {
        return usuarioService.update(usuario);
    }

    public void usuarioDelete (Usuario usuario) {
        usuarioService.delete(usuario);
    }
}