package com.projeto.x.boot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.projeto.x.boot.dao.MarcaDao;
import com.projeto.x.boot.domain.Marca;

@Service
@Transactional
public class MarcaServiceImpl implements MarcaService{

	@Autowired
	MarcaDao dao;
	
	@Override
	public void salvar(Marca marca) {
		dao.save(marca);
	}

	@Override
	public void editar(Marca marca) {
		dao.update(marca);
	}

	@Override
	public void excluir(Long id) {
		dao.delete(id);
	}

	@Override
	@Transactional(readOnly= true)
	public Marca buscarPorId(Long id) {
		
		return dao.findById(id);
	}

	@Override
	@Transactional(readOnly= true)
	public List<Marca> buscarTodos() {
		
		return dao.findAll();
	}

	@Override
	public boolean produtoTemMarcas(Long id) {
		if(buscarPorId(id).getProdutos().isEmpty()) {
			return false;
		}
		return true;
	}

}
