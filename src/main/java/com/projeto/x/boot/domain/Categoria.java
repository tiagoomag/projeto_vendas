package com.projeto.x.boot.domain;

import javax.persistence.*;

@SuppressWarnings("serial")
@Entity
@Table(name = "CATEGORIAS")
public class Categoria extends AbstractEntity<Long> {
	
	@Column(nullable = false, unique = true, length = 40)
	private String nome;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
}
