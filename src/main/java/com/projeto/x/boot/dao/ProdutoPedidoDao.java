package com.projeto.x.boot.dao;

import java.util.List;

import com.projeto.x.boot.domain.ProdutoPedido;

public interface ProdutoPedidoDao  {
	
	void save(ProdutoPedido produtoPedido);
	
	void update(ProdutoPedido produtoPedido);
	
	void delete(Long id);
	
	ProdutoPedido findById(Long id);
	
	List<ProdutoPedido> findAll();

}
