package com.curso.spring.curso.produto;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

//Produto = entidade e Long é o tipo do Id do objeto

public interface ProdutoRepository extends JpaRepository<Produto, Long>{

	List<Produto> findAllByAtivoTrue();

	
}
