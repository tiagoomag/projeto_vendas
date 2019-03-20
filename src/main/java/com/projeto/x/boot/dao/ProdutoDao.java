package com.projeto.x.boot.dao;

import java.util.List;

import com.projeto.x.boot.domain.Produto;

public interface ProdutoDao {
	
	void save(Produto produto);
	
	void update(Produto produto);
	
	void delete(Long id);
	
	Produto findById(Long id);
	
	List<Produto> findAll();

}
