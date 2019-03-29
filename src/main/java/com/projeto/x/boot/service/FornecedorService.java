package com.projeto.x.boot.service;

import java.util.List;

import com.projeto.x.boot.domain.Fornecedor;

public interface FornecedorService {
	
	void salvar(Fornecedor fornecedor); 

	void editar(Fornecedor fornecedor); 

	void excluir(Long id);
	
	Fornecedor buscarPorId(Long id);
	
	List<Fornecedor> buscarTodos();

}
