package com.projeto.x.boot.domain;

import java.util.List;

import javax.persistence.*;

@SuppressWarnings("serial")
@Entity
@Table(name = "DEPARTAMENTOS")
public class Departamento extends  AbstractEntity<Long> {
	
	@Column(name = "nome", nullable = false, unique = true, length = 60)
	private String nome;

	
	/*
	 * Departamento tem uma lista de cargos OneToMany: Muitos cargos para 1 departamento
	 * Departamento <-> Cargo: Rel. Bidirecional
	 * Lado forte: Aquele que contem a chave estrangeira (classe cargo)
	 * mappedBy: Atributo que está fazendo parte do lado forte da relação, no caso: Departamento, lá na classe cargo.
	 * Resumo: Lado departamento -> Lado fraco da relação, Lado cargo -> Lado forte da relação. 
	 */
	
	@OneToMany(mappedBy = "departamento") 
	private List<Cargo> cargos;
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getNome() {
		return nome;
	}

	public List<Cargo> getCargos() {
		return cargos;
	}

	public void setCargos(List<Cargo> cargos) {
		this.cargos = cargos;
	}
	
	
}
