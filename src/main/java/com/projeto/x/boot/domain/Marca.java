package com.projeto.x.boot.domain;

import java.util.List;

import javax.persistence.*;

@SuppressWarnings("serial")
@Entity
@Table(name="MARCAS")
public class Marca extends AbstractEntity<Long> {
	
	@Column(nullable = false, unique = true, length = 50)
	private String nome;

	//muitos produtos pertencem a uma marca. Ler da direita pra esquerda.
	@OneToMany(mappedBy="marca")
	private List<Produto> produtos;
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}

}
