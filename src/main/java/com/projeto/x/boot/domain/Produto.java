package com.projeto.x.boot.domain;

import java.math.BigDecimal;

import javax.persistence.*;

import org.springframework.format.annotation.NumberFormat;
import org.springframework.format.annotation.NumberFormat.Style;

@SuppressWarnings("serial")
@Entity
@Table(name="PRODUTOS")
public class Produto extends AbstractEntity<Long> {
	
	@Column(nullable = false, length = 100)
	private String nome;

	@Column(length = 100)
	private String descricao;
	
	@Column(name="unidade_medida", length = 10)
	@Enumerated(EnumType.STRING)
	private UnidadeMedida unidadeMedida;
	
	@Column(length = 3)
	@Enumerated(EnumType.STRING)
	private Tamanho tamanho;
	
	@Column(nullable = false, length = 10)
	@Enumerated(EnumType.STRING)
	private Cor cor;

	@NumberFormat(style = Style.CURRENCY, pattern = "#,##0.00")
	@Column(name="preco_custo", nullable = false, columnDefinition = "DECIMAL(7) DEFAULT 0.00")
	private BigDecimal precoCusto;
	
	@NumberFormat(style = Style.CURRENCY, pattern = "#,##0.00")
	@Column(name="preco_venda", nullable = false, columnDefinition = "DECIMAL(7) DEFAULT 0.00")
	private BigDecimal precoVenda;

	private boolean ativo;
	
	/*
	 * Relacionamentos: fornecedor, categoria,
	 * estoque e marca.
	 * Campos: imagem e codigo de barras
	 */

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public UnidadeMedida getUnidadeMedida() {
		return unidadeMedida;
	}

	public void setUnidadeMedida(UnidadeMedida unidadeMedida) {
		this.unidadeMedida = unidadeMedida;
	}

	public Tamanho getTamanho() {
		return tamanho;
	}

	public void setTamanho(Tamanho tamanho) {
		this.tamanho = tamanho;
	}

	public Cor getCor() {
		return cor;
	}

	public void setCor(Cor cor) {
		this.cor = cor;
	}

	public BigDecimal getPrecoCusto() {
		return precoCusto;
	}

	public void setPrecoCusto(BigDecimal precoCusto) {
		this.precoCusto = precoCusto;
	}

	public BigDecimal getPrecoVenda() {
		return precoVenda;
	}

	public void setPrecoVenda(BigDecimal precoVenda) {
		this.precoVenda = precoVenda;
	}

	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
}
