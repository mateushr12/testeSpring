package com.br.controleLoja.entity;

import com.br.controleLoja.enums.TipoProdutoEnum;
import lombok.Builder;
import lombok.Data;

import javax.persistence.*;

@Data
@Builder
@Entity
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(unique = true)
    private String codigoProduto;

    private String nome;

    @Enumerated(EnumType.STRING)
    private TipoProdutoEnum tipo;

    private Boolean ativo;


}
