package io.github.edson.servicoprestado.servico.repository;

import io.github.edson.servicoprestado.servico.model.Servico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServicoRepository extends JpaRepository<Servico, Long> {}