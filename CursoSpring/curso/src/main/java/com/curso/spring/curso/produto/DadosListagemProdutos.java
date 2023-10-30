package com.curso.spring.curso.produto;

import java.math.BigDecimal;
import java.time.LocalDate;

public record DadosListagemProdutos(Long id, String nome, Plataforma plataforma, Genero genero, BigDecimal preco, LocalDate lançamento, String empresa) {
	
	public DadosListagemProdutos(Produto produto) {
		this(
			produto.getId(), 
			produto.getNome(), 
			produto.getPlataforma(), 
			produto.getGenero(), 
			produto.getPreco(),
			produto.getLançamento(), 
			produto.getEmpresa());
	}
}
