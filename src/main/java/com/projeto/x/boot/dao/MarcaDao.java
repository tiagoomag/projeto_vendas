package com.projeto.x.boot.dao;

import java.util.List;

import com.projeto.x.boot.domain.Marca;

public interface MarcaDao {

	void save(Marca marca);
	
	void update(Marca marca);
	
	void delete(Long id);
	
	Marca findById(Long id);
	
	List<Marca> findAll();

}
