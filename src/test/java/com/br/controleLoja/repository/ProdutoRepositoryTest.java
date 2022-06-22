package com.br.controleLoja.repository;

import com.br.controleLoja.entity.Produto;
import com.br.controleLoja.enums.TipoProdutoEnum;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import javax.validation.ConstraintViolationException;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@DisplayName("Teste do repository de produto")
class ProdutoRepositoryTest {

    @Autowired
    private ProdutoRepository produtoRepository;

    @Test
    @DisplayName("Deve salvar o produto quando sucesso")
    void shouldPersistProductWhenSuccessful() {
        Produto produto = criarProduto();
        Produto salvo = produtoRepository.save(produto);

        Assertions.assertNotNull(salvo);
        Assertions.assertNotNull(salvo.getId());
        Assertions.assertEquals(salvo.getNome(), produto.getNome());
        Assertions.assertEquals(salvo.getTipo(), produto.getTipo());

    }

    @Test
    @DisplayName("Deve atualizar o produto quando sucesso")
    void shouldUpdatetProductWhenSuccessful() {
        Produto produto = criarProduto();
        Produto salvo = produtoRepository.save(produto);

        salvo.setNome("Produto 1 novo");
        salvo.setCodigoProduto("abc12");

        Produto atualizado = produtoRepository.save(salvo);

        Assertions.assertNotNull(atualizado);
        Assertions.assertNotNull(atualizado.getId());
        Assertions.assertEquals(atualizado.getNome(), salvo.getNome());

    }

    @Test
    @DisplayName("Busca por nome e deve retornar o produto quando sucesso")
    void shouldReturnProductByNameWhenSuccessful (){
        Produto produto = criarProduto();
        Produto salvo = produtoRepository.save(produto);
        String nome = salvo.getNome();
        Produto produtoAchado = produtoRepository.findByNomeOrCodigo(nome).get();

        Assertions.assertNotNull(produtoAchado);
        Assertions.assertEquals(salvo, produtoAchado);

    }

    @Test
    @DisplayName("Busca por codigo de produto e deve retornar o produto quando sucesso")
    void shouldReturnProductByCodeWhenSuccessful (){
        Produto produto = criarProduto();
        Produto salvo = produtoRepository.save(produto);
        String nome = salvo.getCodigoProduto();
        Produto produtoAchado = produtoRepository.findByNomeOrCodigo(nome).get();

        Assertions.assertNotNull(produtoAchado);
        Assertions.assertEquals(salvo, produtoAchado);

    }

    @Test
    @DisplayName("Deve retornar vazio quando produto não for achado")
    void shouldReturnEmptyWhenProductNotFound (){
        Produto produtoAchado = produtoRepository.findByNomeOrCodigo("cds").get();

        Assertions.assertNull(produtoAchado);
    }

    /**@Test
    @DisplayName("Deve lançar execeção quando os campos estiverem vazio")
    void shouldThrowExceptionWhenFieldEmpty (){
        Produto produtoVazio = Produto.builder().build();

        Throwable e = Assertions.assertThrows(ConstraintViolationException.class, () -> produtoRepository.save(produtoVazio));
        Assertions.assertEquals("O campo não pode ser vazio.", e.getMessage());
    }**/

    private Produto criarProduto(){
        return Produto.builder().codigoProduto("as123").nome("produto 1").tipo(TipoProdutoEnum.TIPO_A).build();
    }



}