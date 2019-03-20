package com.projeto.x.boot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.projeto.x.boot.dao.ProdutoDao;
import com.projeto.x.boot.domain.Produto;

@Service
@Transactional
public class ProdutoServiceImpl implements ProdutoService{

	@Autowired
	ProdutoDao dao;
	
	@Override
	public void salvar(Produto produto) {
		dao.save(produto);
	}

	@Override
	public void editar(Produto produto) {
		dao.update(produto);
	}

	@Override
	public void excluir(Long id) {
		dao.delete(id);
	}

	@Override
	public Produto buscarPorId(Long id) {
		return  dao.findById(id);
	}

	@Override
	public List<Produto> buscarTodos() {
		return dao.findAll();
	}

}
