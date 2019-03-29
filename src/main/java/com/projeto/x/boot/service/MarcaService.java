package com.projeto.x.boot.service;

import java.util.List;

import com.projeto.x.boot.domain.Marca;

public interface MarcaService {
	
	void salvar(Marca marca); 

	void editar(Marca marca); 

	void excluir(Long id);
	
	Marca buscarPorId(Long id);
	
	List<Marca> buscarTodos();

	boolean produtoTemMarcas(Long id);

}
