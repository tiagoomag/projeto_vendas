package com.projeto.x.boot.dao;

import java.util.List;

import com.projeto.x.boot.domain.Pedido;

public interface PedidoDao {
	
	void save(Pedido pedido);
	
	void update(Pedido pedido);
	
	void delete(Long id);
	
	Pedido findById(Long id);
	
	List<Pedido> findAll();

}
