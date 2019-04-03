package com.projeto.x.boot.domain;

import java.math.BigDecimal;

import javax.persistence.*;


import org.springframework.format.annotation.NumberFormat;
import org.springframework.format.annotation.NumberFormat.Style;

@SuppressWarnings("serial")
@Entity
@Table(name = "pedidos_produtos")
public class ProdutoPedido extends AbstractEntity<Long> {
	
	@Column(nullable = false)
	private int quantidade;
	
	@NumberFormat(style = Style.CURRENCY, pattern = "#,##0.00")
	@Column(name="preco_unitario", nullable = false, columnDefinition = "DECIMAL(7) DEFAULT 0.00")
	private BigDecimal precoUnitario;
	
	@NumberFormat(style = Style.CURRENCY, pattern = "#,##0.00")
	@Column(name="preco_total", nullable = false, columnDefinition = "DECIMAL(7) DEFAULT 0.00")
	private BigDecimal precoTotal;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "pedido_id_fk")
	private Pedido pedido;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "produto_id_fk")
	private Produto produto;

	public BigDecimal getPrecoUnitario() {
		return precoUnitario;
	}

	public void setPrecoUnitario(BigDecimal precoUnitario) {
		this.precoUnitario = precoUnitario;
	}

	public BigDecimal getPrecoTotal() {
		return precoTotal;
	}

	public void setPrecoTotal(BigDecimal precoTotal) {
		this.precoTotal = precoTotal;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	
}