package com.projeto.x.boot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.projeto.x.boot.dao.FornecedorDao;
import com.projeto.x.boot.domain.Fornecedor;

@Service
@Transactional
public class FornecedorServiceImpl implements FornecedorService{

	@Autowired
	FornecedorDao dao;
	
	@Override
	public void salvar(Fornecedor fornecedor) {
		dao.save(fornecedor);
	}

	@Override
	public void editar(Fornecedor fornecedor) {
		dao.update(fornecedor);
	}

	@Override
	public void excluir(Long id) {
		dao.delete(id);
	}

	@Override
	@Transactional(readOnly = true)
	public Fornecedor buscarPorId(Long id) {
		
		return dao.findById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Fornecedor> buscarTodos() {
		
		return dao.findAll();
	}

}
