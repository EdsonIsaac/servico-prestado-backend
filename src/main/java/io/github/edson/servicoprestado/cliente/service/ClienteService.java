package io.github.edson.servicoprestado.cliente.service;

import io.github.edson.servicoprestado.cliente.model.Cliente;
import io.github.edson.servicoprestado.cliente.repository.ClienteRepository;
import io.github.edson.servicoprestado.infraestrutura.exception.ObjectNotFoundException;
import io.github.edson.servicoprestado.infraestrutura.exception.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    private final ClienteRepository clienteRepository;

    @Autowired
    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public Cliente findById (Long id) {
        Cliente cliente = clienteRepository.findById(id).orElseThrow(() ->{
           throw new ObjectNotFoundException("Cliente não encontrado!");
        });

        return cliente;
    }

    public List<Cliente> findAll () {
        return clienteRepository.findAll();
    }

    public Cliente save (Cliente cliente) {

        if (cliente == null) {
            throw new ValidationException("Cliente nulo!");
        }

        if (validarCliente(cliente)) {
            clienteRepository.save(cliente);
        }

        return cliente;
    }

    public Cliente update (Cliente cliente) {

        if (cliente == null) {
            throw new ValidationException("Cliente nulo!");
        }

        if (!clienteRepository.existsById(cliente.getId())) {
            throw new ObjectNotFoundException("Cliente não encontrado!");
        }

        if (validarCliente(cliente)) {
            clienteRepository.save(cliente);
        }

        return clienteRepository.save(cliente);
    }

    public void delete (Cliente cliente) {

        if (cliente == null) {
            throw new ValidationException("Cliente nulo!");
        }

        if (!clienteRepository.existsById(cliente.getId())) {
            throw new ObjectNotFoundException("Cliente não encontrado!");
        }

        clienteRepository.delete(cliente);
    }

    private boolean validarCliente (Cliente cliente) {

        Cliente cliente_findByNome = clienteRepository.findByNome(cliente.getNome());

        if (cliente_findByNome != null && !cliente_findByNome.equals(cliente)) {
            throw new ValidationException("Nome já cadastrado!");
        }

        Cliente cliente_findByCpf = clienteRepository.findByCpf(cliente.getCpf());

        if (cliente_findByCpf != null && !cliente_findByCpf.equals(cliente)) {
            throw new ValidationException("CPF já cadastrado!");
        }

        return true;
    }
}