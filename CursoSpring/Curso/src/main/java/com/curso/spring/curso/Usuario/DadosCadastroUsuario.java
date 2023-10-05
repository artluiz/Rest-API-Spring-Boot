package com.curso.spring.curso.Usuario;

import jakarta.validation.constraints.NotBlank;

public record DadosCadastroUsuario(
		
		@NotBlank
		String login, 
		@NotBlank
		String senha
		
		) {
	
	
}
