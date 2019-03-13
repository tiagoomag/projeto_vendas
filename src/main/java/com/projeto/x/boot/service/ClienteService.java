package com.projeto.x.boot.service;

import java.util.List;

import com.projeto.x.boot.domain.Cliente;


public interface ClienteService {
	
	void salvar(Cliente cliente); 

	void editar(Cliente cliente); 

	void excluir(Long id);
	
	Cliente buscarPorId(Long id);
	
	List<Cliente> buscarTodos();

}
