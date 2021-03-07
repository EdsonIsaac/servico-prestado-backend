package io.github.edson.servicoprestado.cliente.controller;

import io.github.edson.servicoprestado.cliente.model.Cliente;
import io.github.edson.servicoprestado.infraestrutura.service.Facade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    private final Facade facade;

    @Autowired
    public ClienteController(Facade facade) {
        this.facade = facade;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Cliente> findAll () {
        return facade.clienteFindAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Cliente findById (@PathVariable Long id) {
        return facade.clienteFindById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Cliente save (@RequestBody @Valid Cliente cliente) {
        return facade.clienteSave(cliente);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Cliente update (@PathVariable Long id, @RequestBody @Valid Cliente clienteAtualizado) {
        Cliente cliente = facade.clienteFindById(id);

        cliente.setNome(clienteAtualizado.getNome());
        cliente.setDataNascimento(clienteAtualizado.getDataNascimento());
        cliente.setSexo(clienteAtualizado.getSexo());
        cliente.setCpf(clienteAtualizado.getCpf());
        cliente.setTelefone(clienteAtualizado.getTelefone());
        cliente.setEmail(clienteAtualizado.getEmail());

        return facade.clienteUpdate(cliente);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete (@PathVariable Long id) {

        facade.clienteDelete(
            facade.clienteFindById(id)
        );
    }
}