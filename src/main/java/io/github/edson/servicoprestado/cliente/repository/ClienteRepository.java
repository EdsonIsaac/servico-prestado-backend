package io.github.edson.servicoprestado.cliente.repository;

import io.github.edson.servicoprestado.cliente.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    public Cliente findByNome (String nome);

    public Cliente findByCpf (String cpf);
}