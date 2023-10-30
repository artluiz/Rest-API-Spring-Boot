package com.curso.spring.curso.produto;

import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "Produto")
@Entity(name = "produtos")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Produto {

	public Produto(DadosCadastroProduto dados) {
		this.nome = dados.nome();
		this.plataforma = dados.plataforma();
		this.quantidade = dados.quantidade();
		this.preco = dados.preco();
		this.genero = dados.genero();
		this.lançamento = dados.lançamento();
		this.empresa = dados.empresa();
		this.ativo = true;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private int quantidade;

	@Enumerated(EnumType.STRING)
	private Plataforma plataforma;
	private BigDecimal preco;
	
	@Enumerated(EnumType.STRING)
	private Genero genero;
	private LocalDate lançamento;
	private String empresa;
	private boolean ativo;

	public void atualizarInfos(@Valid DadosAtualizarProduto dados) {
		if (dados.nome() != null) {
			this.nome = dados.nome();
		}
		if (dados.genero() != null) {
			this.genero = dados.genero();
		}
		if (dados.plataforma() != null) {
			this.plataforma = dados.plataforma();
		}
		if (dados.lançamento() != null) {
			this.lançamento = dados.lançamento();
		}
		if (dados.empresa() != null) {
			this.empresa = dados.empresa();
		}

	}

	public void inativar() {
		this.ativo = false;

	}
	
	public void reativar() {
		this.ativo = true;

	}
}
