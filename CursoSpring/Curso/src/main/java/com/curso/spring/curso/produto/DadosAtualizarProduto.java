package com.curso.spring.curso.produto;

import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.validation.constraints.NotNull;

public record DadosAtualizarProduto(
		@NotNull
		Long id, 
		String nome, 
		Plataforma plataforma, 
		int quantidade,
		BigDecimal preco,
		Genero genero, 
		LocalDate lançamento, 
		String empresa) {

}
