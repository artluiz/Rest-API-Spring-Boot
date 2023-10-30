package com.curso.spring.curso.produto;

import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;

public record DadosCadastroProduto(
		
		@NotBlank
		String nome, 
		@Enumerated
		Plataforma plataforma,
		int quantidade,
		@NotNull
		BigDecimal preco, 
		@Enumerated
		Genero genero,
		@Past
		LocalDate lançamento,
		@NotBlank
		String empresa
		) {

}
