package com.br.controleLoja.DTO;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class ProdutoDTO {

    private Long idProduto;
    @NotEmpty(message = "O campo não pode ser vazio.")
    private String codigoProduto;
    @NotEmpty(message = "O campo não pode ser vazio.")
    private String nome;
    @NotEmpty(message = "O campo não pode ser vazio.")
    private String tipo;
    private Boolean ativo = false;

}
