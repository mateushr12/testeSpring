package com.br.controleLoja.enums;

public enum TipoProdutoEnum {
    TIPO_A("tipo a"),
    TIPO_B("tipo b");

    private String descircao;
    TipoProdutoEnum(String descricao) {
        this.descircao = descricao;
    }

    public String getDescircao() {
        return descircao;
    }

    //testar
    public String getDescription(){
        return this.descircao;
    }
}
