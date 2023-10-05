package com.curso.spring.curso.Usuario;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import com.curso.spring.curso.produto.Produto;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

	UserDetails findByLogin(String login);
	
	List<Usuario> findAllByAtivoTrue();
	
}
