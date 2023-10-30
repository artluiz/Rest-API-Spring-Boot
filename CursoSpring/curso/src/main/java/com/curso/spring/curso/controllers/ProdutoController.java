package com.curso.spring.curso.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.curso.spring.curso.produto.DadosAtualizarProduto;
import com.curso.spring.curso.produto.DadosCadastroProduto;
import com.curso.spring.curso.produto.DadosDetalhados;
import com.curso.spring.curso.produto.DadosListagemProdutos;
import com.curso.spring.curso.produto.Produto;
import com.curso.spring.curso.produto.ProdutoRepository;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/produtos")

public class ProdutoController {

	@Autowired
	private ProdutoRepository repository;

	@PostMapping
	@Transactional
	public ResponseEntity<DadosDetalhados> cadastrar(@RequestBody @Valid DadosCadastroProduto dados, UriComponentsBuilder uriBuilder) {
		var produto = new Produto(dados);
		repository.save(produto);
		
		var uri = uriBuilder.path("/produtos/{id}").buildAndExpand(produto.getId()).toUri();
		
		return ResponseEntity.created(uri).body(new DadosDetalhados(produto));
	}

	@GetMapping
	public ResponseEntity<java.util.List<DadosListagemProdutos>> listar() {
		var lista = repository.findAllByAtivoTrue().stream().map(DadosListagemProdutos::new).toList();
		
		return ResponseEntity.ok(lista);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<DadosDetalhados> GetbyId(@PathVariable  Long id) {
		var produto = repository.getReferenceById(id);
		
		return ResponseEntity.ok(new DadosDetalhados(produto));
	}

	@PutMapping
	@Transactional
	public ResponseEntity<DadosDetalhados> atualizar(@RequestBody @Valid DadosAtualizarProduto dados) {
		var produto = repository.getReferenceById(dados.id());
		produto.atualizarInfos(dados);
		
		return ResponseEntity.ok(new DadosDetalhados(produto));
	}

	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<Void> excluir(@PathVariable  Long id) {
		repository.deleteById(id);
		
		return ResponseEntity.noContent().build();
	}

	@DeleteMapping("inativar/{id}")
	@Transactional
	public ResponseEntity<Void> excluir_logico(@PathVariable Long id) {
		var produto = repository.getReferenceById(id);
		produto.inativar();
		
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping("/reativar/{id}")
	@Transactional
	public ResponseEntity<Void> ativar(@PathVariable Long id) {
		var produto = repository.getReferenceById(id);
		produto.reativar();
		
		return ResponseEntity.noContent().build();
	}
}
