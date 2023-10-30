package com.curso.spring.curso.produto;

import java.math.BigDecimal;
import java.time.LocalDate;

public record DadosDetalhados(
		Long id, 
		String nome, 
		Plataforma plataforma, 
		int quantidade, 
		BigDecimal preco,
		Genero genero, 
		LocalDate lançamento, 
		String empresa) {
	public DadosDetalhados(Produto produto) {
		this(
				produto.getId(), 
				produto.getNome(), 
				produto.getPlataforma(),
				produto.getQuantidade(),
				produto.getPreco(),
				produto.getGenero(), 
				produto.getLançamento(), 
				produto.getEmpresa());
	}
}
