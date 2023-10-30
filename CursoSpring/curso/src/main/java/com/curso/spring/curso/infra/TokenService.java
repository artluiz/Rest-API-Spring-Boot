package com.curso.spring.curso.infra;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.curso.spring.curso.Usuario.Usuario;

@Service
public class TokenService {
	
	@Value("${api.security.token.secret}")
	private String secret;
	
	public String geraToken(Usuario usuario) {
		
		try {
		    var algorithm = Algorithm.HMAC256(secret);
		    return JWT.create()
		        .withIssuer("Produtos_api")
		        .withSubject(usuario.getLogin())
		        .withExpiresAt(dataExpires())
		        .sign(algorithm);
		    
		} catch (JWTCreationException exception){
		    throw new RuntimeException("Erro ao gerar token", exception);
		}
	}

	private Instant dataExpires() {
		return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-03:00"));
	}
	
	public String getSubject(String tokenJWT) {
		try {
			var algorithm = Algorithm.HMAC256(secret);
		    return JWT.require(algorithm)
		    		.withIssuer("Produtos_api")
		    		.build()
		    		.verify(tokenJWT)
		    		.getSubject();
		    
		} catch (JWTVerificationException exception){
		    throw new RuntimeException("Token inválido ou expirado.");
		}
	}
	
}
