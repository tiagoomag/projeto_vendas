package com.projeto.x.boot.dao;

import java.util.List;

import com.projeto.x.boot.domain.PedidoProduto;

public interface PedidoProdutoDao  {
	
	void save(PedidoProduto pedidoProduto);
	
	void update(PedidoProduto pedidoProduto);
	
	void delete(Long id);
	
	PedidoProduto findById(Long id);
	
	List<PedidoProduto> findAll();

}
