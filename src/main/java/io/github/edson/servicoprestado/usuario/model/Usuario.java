package io.github.edson.servicoprestado.usuario.model;

import io.github.edson.servicoprestado.infraestrutura.enums.Perfil;
import io.github.edson.servicoprestado.infraestrutura.model.AbstractEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
public class Usuario extends AbstractEntity {

    @NotEmpty(message = "{campo.usuario.obrigatorio}")
    private String usuario;

    @NotEmpty(message = "{campo.senha.obrigatorio}")
    private String senha;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "perfil")
    private Set<Perfil> perfis = new HashSet<>();

    @PrePersist
    private void perPersist () {
        this.perfis.add(Perfil.USER);
    }
}