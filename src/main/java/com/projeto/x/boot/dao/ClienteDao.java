package com.projeto.x.boot.dao;

import java.util.List;

import com.projeto.x.boot.domain.Cliente;

public interface ClienteDao {
	
	void save(Cliente cliente);
	
	void update(Cliente cliente);
	
	void delete(Long id);
	
	Cliente findById(Long id);
	
	List<Cliente> findAll();

}
