package com.curso.spring.curso.produto;

import java.time.LocalDate;

public record DadosDetalhados(
		Long id, 
		String nome, 
		Plataforma plataforma, 
		int quantidade, 
		Genero genero, 
		LocalDate lançamento, 
		String empresa) {
	public DadosDetalhados(Produto produto) {
		this(
				produto.getId(), 
				produto.getNome(), 
				produto.getPlataforma(),
				produto.getQuantidade(), 
				produto.getGenero(), 
				produto.getLançamento(), 
				produto.getEmpresa());
	}
}
