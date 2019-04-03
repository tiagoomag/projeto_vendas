package com.projeto.x.boot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.projeto.x.boot.dao.ProdutoPedidoDao;
import com.projeto.x.boot.domain.ProdutoPedido;

@Service
@Transactional
public class ProdutoPedidoServiceImpl implements ProdutoPedidoService {

	@Autowired
	ProdutoPedidoDao produtoPedidoDao;
	
	@Override
	public void salvar(ProdutoPedido produtoPedido) {
		produtoPedidoDao.save(produtoPedido);
	}

	@Override
	public void editar(ProdutoPedido produtoPedido) {
		produtoPedidoDao.update(produtoPedido);
	}

	@Override
	public void excluir(Long id) {
		produtoPedidoDao.delete(id);
	}

	@Override
	@Transactional(readOnly = true)
	public ProdutoPedido buscarPorId(Long id) {

		return produtoPedidoDao.findById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<ProdutoPedido> buscarTodos() {
		
		return produtoPedidoDao.findAll();
	}

}
