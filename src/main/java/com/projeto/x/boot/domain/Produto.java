package com.projeto.x.boot.domain;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

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
	
	//1 marca tem muitos produtos. :: Ler da direita pra esquerda
	@ManyToOne
	@JoinColumn(name = "marca_id_fk")
	private Marca marca;
	
	@OneToMany(mappedBy = "produto")
	List<PedidoProduto> listaPedidosProdutos;
	
	/*
	@ManyToMany(cascade = CascadeType.ALL)  //1 produto -> N fornecedores. 1 fornecedor - > N produtos
	@JoinTable(name = "produtos_fornecedores", joinColumns = { @JoinColumn(name = "produto_id_fk") }, 
			inverseJoinColumns = { @JoinColumn(name = "fornecedor_id_fk") })
	private List<Fornecedor> fornecedores; */
	
	@Column(length = 100)
	private String codigoBarras;

	public List<PedidoProduto> getListaPedidosProdutos() {
		return listaPedidosProdutos;
	}

	public void setListaPedidosProdutos(List<PedidoProduto> listaPedidosProdutos) {
		this.listaPedidosProdutos = listaPedidosProdutos;
	}

	private boolean ativo;

	
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

	public Marca getMarca() {
		return marca;
	}

	public void setMarca(Marca marca) {
		this.marca = marca;
	}

	public String getCodigoBarras() {
		return codigoBarras;
	}

	public void setCodigoBarras(String codigoBarras) {
		this.codigoBarras = codigoBarras;
	}
	
}
