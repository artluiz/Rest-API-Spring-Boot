package com.curso.spring.curso.Usuario;

public record DadosDetalhadosUsuario(
		Long id, 
		String login,
		String senha
		) {
	public DadosDetalhadosUsuario(Usuario usuario) {
		this(
				usuario.getId(), 
				usuario.getLogin(), 
				usuario.getSenha());
	}
}
