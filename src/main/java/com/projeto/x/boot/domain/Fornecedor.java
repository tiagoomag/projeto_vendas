package com.projeto.x.boot.domain;

import java.util.List;

import javax.persistence.*;

@SuppressWarnings("serial")
@Entity
@Table(name = "FORNECEDORES")
public class Fornecedor extends AbstractEntity<Long> {
	
	@Column(nullable = false, unique = true)
	private String nome;
	
	//min = 14 max = 18
	@Column(nullable = false, unique = true, length = 18)
	private String cpfCnpj;
	
	@Column(length = 14)
	private String telefone;
	
	@Column(nullable = false, unique = true, length = 15)
	private String celular;
	
	@Column(unique = true)
	private String email;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "endereco_id_fk")
	private Endereco endereco;
	
    /*
	@ManyToMany(mappedBy="fornecedores")
    private List<Produto> produtos; */

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpfCnpj() {
		return cpfCnpj;
	}

	public void setCpfCnpj(String cpfCnpj) {
		this.cpfCnpj = cpfCnpj;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	} 
	

}
