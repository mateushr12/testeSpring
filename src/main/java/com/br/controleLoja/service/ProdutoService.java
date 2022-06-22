package com.br.controleLoja.service;

import com.br.controleLoja.DTO.ProdutoDTO;
import com.br.controleLoja.entity.Produto;
import com.br.controleLoja.enums.TipoProdutoEnum;
import com.br.controleLoja.repository.ProdutoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProdutoService {

    ProdutoRepository produtoRepository;

    @Transactional
    public Produto save(ProdutoDTO produtoDTO){
        Produto produto = Produto.builder()
                .codigoProduto(produtoDTO.getNome().trim().toUpperCase())
                .nome(produtoDTO.getNome().trim().toUpperCase())
                .tipo(TipoProdutoEnum.valueOf(produtoDTO.getTipo()))
                .ativo(produtoDTO.getAtivo())
                .build();
        return produtoRepository.save(produto);
    }

    public Produto findByIdOrThrowExeception(Long id){
        return produtoRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Produto não encontrado."));
    }

    public void delete(Long id){
        Produto produto = findByIdOrThrowExeception(id);
        produtoRepository.delete(produto);
    }

    @Transactional
    public Produto update(ProdutoDTO produtoDTO){
        findByIdOrThrowExeception(produtoDTO.getIdProduto());
        Produto produto = Produto.builder()
                .id(produtoDTO.getIdProduto())
                .codigoProduto(produtoDTO.getCodigoProduto().trim().toUpperCase())
                .nome(produtoDTO.getNome().trim().toUpperCase())
                .tipo(TipoProdutoEnum.valueOf(produtoDTO.getTipo()))
                .ativo(produtoDTO.getAtivo())
                .build();
        return produtoRepository.save(produto);
    }

    public List<Produto> findAll(){
        return produtoRepository.findAll();
    }

    public Produto findByNomeOrCodigo(String nomeOrCodigo){
        return produtoRepository.findByNomeOrCodigo(nomeOrCodigo)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Produto não encontrado."));
    }
}
