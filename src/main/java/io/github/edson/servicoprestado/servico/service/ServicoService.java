package io.github.edson.servicoprestado.servico.service;

import io.github.edson.servicoprestado.infraestrutura.exception.ObjectNotFoundException;
import io.github.edson.servicoprestado.infraestrutura.exception.ValidationException;
import io.github.edson.servicoprestado.servico.model.Servico;
import io.github.edson.servicoprestado.servico.repository.ServicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicoService {

    private final ServicoRepository servicoRepository;

    @Autowired
    public ServicoService(ServicoRepository servicoRepository) {
        this.servicoRepository = servicoRepository;
    }

    public Servico findById (Long id) {
        Servico servico = servicoRepository.findById(id).orElseThrow(() -> {
            throw new ObjectNotFoundException("Serviço não encontrado!");
        });

        return servico;
    }

    public List<Servico> findAll () {
        return servicoRepository.findAll();
    }

    public Servico save (Servico servico) {

        if (servico == null) {
            throw new ValidationException("Serviço nulo!");
        }

        return servicoRepository.save(servico);
    }

    public Servico update (Servico servico) {

        if (servico == null) {
            throw new ValidationException("Serviço nulo!");
        }

        if (!servicoRepository.existsById(servico.getId())) {
            throw new ObjectNotFoundException("Serviço não encontrado!");
        }

        return servicoRepository.save(servico);
    }

    public void delete (Servico servico) {

        if (servico == null) {
            throw new ValidationException("Serviço nulo!");
        }

        if (!servicoRepository.existsById(servico.getId())) {
            throw new ObjectNotFoundException("Serviço não encontrado!");
        }

        servicoRepository.delete(servico);
    }
}