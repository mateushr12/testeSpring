package com.br.controleLoja.repository;

import com.br.controleLoja.entity.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {

    @Query("select p from Produto p where p.codigoProduto like '%:nomeOrCodigo%' or p.nome like %:nomeOrCodigo%")
    Optional<Produto> findByNomeOrCodigo(String nomeOrCodigo);
}
