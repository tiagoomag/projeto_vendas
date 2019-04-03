package com.projeto.x.boot.service;

import java.util.List;

import com.projeto.x.boot.domain.ProdutoPedido;

public interface ProdutoPedidoService {
	
	void salvar(ProdutoPedido produtoPedido); 

	void editar(ProdutoPedido produtoPedido); 

	void excluir(Long id);
	
	ProdutoPedido buscarPorId(Long id);
	
	List<ProdutoPedido> buscarTodos();

}
