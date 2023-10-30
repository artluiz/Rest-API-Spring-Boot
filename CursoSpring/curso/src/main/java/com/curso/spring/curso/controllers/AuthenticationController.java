package com.curso.spring.curso.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.curso.spring.curso.Usuario.DadosAuthentication;
import com.curso.spring.curso.Usuario.Usuario;
import com.curso.spring.curso.infra.DadosTokenJWT;
import com.curso.spring.curso.infra.TokenService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/login")
public class AuthenticationController {
	
	@Autowired
	private AuthenticationManager manager;
	
	@Autowired
	private TokenService tokenService;
	
	@PostMapping
	public ResponseEntity<?> efetuarLogin(@RequestBody @Valid DadosAuthentication dados){
		
		var token = new UsernamePasswordAuthenticationToken(dados.login(), dados.senha());
		var authentication = manager.authenticate(token);
														//usa um cast de usuario para garantir ao Java que o objeto é um usuário
		
		var tokenJWT = (tokenService.geraToken((Usuario) authentication.getPrincipal())); 
		return ResponseEntity.ok(new DadosTokenJWT(tokenJWT));
	}
}
