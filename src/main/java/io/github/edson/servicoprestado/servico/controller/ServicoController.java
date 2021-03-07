package io.github.edson.servicoprestado.servico.controller;

import io.github.edson.servicoprestado.infraestrutura.service.Facade;
import io.github.edson.servicoprestado.servico.model.Servico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/servicos")
public class ServicoController {

    private final Facade facade;

    @Autowired
    public ServicoController(Facade facade) {
        this.facade = facade;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Servico> findAll () {
        return facade.servicoFindAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Servico findById (@PathVariable Long id) {
        return facade.servicoFindById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Servico save (@RequestBody @Valid Servico servico) {
        return facade.servicoSave(servico);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Servico update (@PathVariable Long id, @RequestBody @Valid Servico servicoUpdated) {
        Servico servico = facade.servicoFindById(id);

        servico.setDescricao(servicoUpdated.getDescricao());
        servico.setValorPagamento(servicoUpdated.getValorPagamento());
        servico.setSituacaoPagamento(servicoUpdated.getSituacaoPagamento());
        servico.setCliente(servicoUpdated.getCliente());

        return facade.servicoUpdate(servico);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete (@PathVariable Long id) {

        facade.servicoDelete(
            facade.servicoFindById(id)
        );
    }
}