package com.projeto.x.boot.service;

import java.util.List;

import com.projeto.x.boot.domain.Pedido;

public interface PedidoService {
	
	void salvar(Pedido pedido); 

	void editar(Pedido pedido); 

	void excluir(Long id);
	
	Pedido buscarPorId(Long id);
	
	List<Pedido> buscarTodos();

}
