package io.github.edson.servicoprestado.infraestrutura.enums;

public enum Pagamento {

    ABERTO("Aberto"), PAGO("Pago");

    private String description;

    Pagamento(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}