package com.estoque.sistema;

import org.springframework.data.jpa.repository.JpaRepository;

// Essa interface mágica já traz os comandos de Salvar, Deletar e Buscar
public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}