package com.curso.spring.curso.produto;

import java.time.LocalDate;

public record DadosListagemProdutos(Long id, String nome, Plataforma plataforma, Genero genero, LocalDate lançamento, String empresa) {
	
	public DadosListagemProdutos(Produto produto) {
		this(produto.getId(), produto.getNome(), produto.getPlataforma(), produto.getGenero(), produto.getLançamento(), produto.getEmpresa());
	}
}
