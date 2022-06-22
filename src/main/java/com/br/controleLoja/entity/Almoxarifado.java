package com.br.controleLoja.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigInteger;
import java.util.Date;

@Data
@Entity
public class Almoxarifado {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String nomeAlmox;

    private int produtoId;

    private BigInteger quantidade;

    private Date dataAtualizacao;
}
