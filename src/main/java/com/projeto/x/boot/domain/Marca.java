package com.projeto.x.boot.domain;

import javax.persistence.*;

@SuppressWarnings("serial")
@Entity
@Table(name="MARCAS")
public class Marca extends AbstractEntity<Long> {
	
	@Column(nullable = false, unique = true, length = 50)
	private String nome;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
