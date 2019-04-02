package com.projeto.x.boot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.projeto.x.boot.dao.PedidoProdutoDao;
import com.projeto.x.boot.domain.PedidoProduto;

@Service
@Transactional
public class PedidoProdutoServiceImpl implements PedidoProdutoService {

	@Autowired
	PedidoProdutoDao pedidoProdutoDao;
	
	@Override
	public void salvar(PedidoProduto pedidoProduto) {
		pedidoProdutoDao.save(pedidoProduto);
	}

	@Override
	public void editar(PedidoProduto pedidoProduto) {
		pedidoProdutoDao.update(pedidoProduto);
	}

	@Override
	public void excluir(Long id) {
		pedidoProdutoDao.delete(id);
	}

	@Override
	@Transactional(readOnly = true)
	public PedidoProduto buscarPorId(Long id) {

		return pedidoProdutoDao.findById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<PedidoProduto> buscarTodos() {
		
		return pedidoProdutoDao.findAll();
	}

}
