package io.github.edson.servicoprestado.cliente.model;

import io.github.edson.servicoprestado.infraestrutura.model.AbstractEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrePersist;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
public class Cliente extends AbstractEntity {

    @NotEmpty(message = "{campo.nome.obrigatorio}")
    @Column(nullable = false, length = 150)
    private String nome;

    @NotNull(message = "{campo.dataNascimento.obrigatorio}")
    private LocalDate dataNascimento;

    @NotEmpty(message = "{campo.sexo.obrigatorio}")
    @Column(length = 9)
    private String sexo;

    @NotEmpty(message = "{campo.cpf.obrigatorio}")
    @CPF(message = "{campo.cpf.invalido}")
    @Column(nullable = false, length = 11)
    private String cpf;

    @Column(length = 16)
    private String telefone;

    @Column(length = 100)
    private String email;

    @Column(updatable = false)
    private LocalDate dataCadastro;

    @PrePersist
    private void prePersist () {
        setDataCadastro(LocalDate.now());
    }

    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}