package io.github.edson.servicoprestado.servico.model;

import io.github.edson.servicoprestado.cliente.model.Cliente;
import io.github.edson.servicoprestado.infraestrutura.enums.Pagamento;
import io.github.edson.servicoprestado.infraestrutura.model.AbstractEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
public class Servico extends AbstractEntity {

    @NotEmpty(message = "{campo.descricao.obrigatorio}")
    @Column(length = 255)
    private String descricao;

    @NotNull(message = "{campo.valorPagamento.obrigatorio}")
    private Double valorPagamento;

    @NotNull(message = "{campo.situacaoPagamento.obrigatorio}")
    private Pagamento situacaoPagamento;

    @Column(updatable = false)
    private LocalDate dataCadastro;

    @NotNull(message = "{campo.cliente.obrigatorio}")
    @ManyToOne(optional = false)
    private Cliente cliente;

    @PrePersist
    private void prePersist () {
        setDataCadastro(LocalDate.now());
    }
}