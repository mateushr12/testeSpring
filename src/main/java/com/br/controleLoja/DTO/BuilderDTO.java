package com.br.controleLoja.DTO;


import com.br.controleLoja.validation.constraints.ExemploValidacao;

public class BuilderDTO {

    private Long id;
    private String codigoProduto;
    @ExemploValidacao
    private String nome;
    private String tipo;
    private Boolean ativo;

    private BuilderDTO(){

    }

    public static BuilderDTO builder() {
        return new BuilderDTO();
    }

    public BuilderDTO codigoProduto(String codigoProduto) {
        this.codigoProduto = codigoProduto;
        return this;
    }

    public BuilderDTO nome(String nome) {
        this.nome = nome;
        return this;
    }

    public BuilderDTO tipo(String tipo) {
        this.tipo = tipo;
        return this;
    }

    public BuilderDTO ativo(Boolean ativo) {
        this.ativo = ativo;
        return this;
    }
}
