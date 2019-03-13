package com.projeto.x.boot.dao;

import java.util.List;

import com.projeto.x.boot.domain.Cargo;

public interface CargoDao {
	
	void save(Cargo Cargo);
	
	void update(Cargo Cargo);
	
	void delete(Long id);
	
	Cargo findById(Long id);
	
	List<Cargo> findAll();


}
