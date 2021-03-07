package io.github.edson.servicoprestado.infraestrutura.enums;

public enum Perfil {

    USER (1, "ROLE_USER");

    private Integer cod;
    private String description;

    Perfil(Integer cod, String description) {
        this.cod = cod;
        this.description = description;
    }

    public Integer getCod() {
        return cod;
    }

    public String getDescription() {
        return description;
    }
}