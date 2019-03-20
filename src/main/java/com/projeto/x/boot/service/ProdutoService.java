package com.projeto.x.boot.service;

import java.util.List;

import com.projeto.x.boot.domain.Produto;

public interface ProdutoService {
	
	void salvar(Produto produto); 

	void editar(Produto produto); 

	void excluir(Long id);
	
	Produto buscarPorId(Long id);
	
	List<Produto> buscarTodos();

}
