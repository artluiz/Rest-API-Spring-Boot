package com.curso.spring.curso.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.curso.spring.curso.Usuario.DadosCadastroUsuario;
import com.curso.spring.curso.Usuario.DadosDetalhadosUsuario;
import com.curso.spring.curso.Usuario.Usuario;
import com.curso.spring.curso.Usuario.UsuarioRepository;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/usuario")

public class UsuarioController {
	
	@Autowired
	private UsuarioRepository repository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@PostMapping
	@Transactional
	public ResponseEntity<DadosDetalhadosUsuario> cadastrar(@RequestBody @Valid DadosCadastroUsuario dados, UriComponentsBuilder uriBuilder) {
		var usuario = new Usuario(dados);
		usuario.setSenha(passwordEncoder.encode(dados.senha()));
		repository.save(usuario);
		
		var uri = uriBuilder.path("/usuario/{id}").buildAndExpand(usuario.getId()).toUri();
		
		return ResponseEntity.created(uri).body(new DadosDetalhadosUsuario(usuario));
	}
	
}
