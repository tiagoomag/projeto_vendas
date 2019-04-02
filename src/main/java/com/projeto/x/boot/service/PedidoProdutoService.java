package com.projeto.x.boot.service;

import java.util.List;

import com.projeto.x.boot.domain.PedidoProduto;

public interface PedidoProdutoService {
	
	void salvar(PedidoProduto pedidoProduto); 

	void editar(PedidoProduto pedidoProduto); 

	void excluir(Long id);
	
	PedidoProduto buscarPorId(Long id);
	
	List<PedidoProduto> buscarTodos();

}
