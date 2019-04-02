package com.projeto.x.boot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.projeto.x.boot.dao.PedidoDao;
import com.projeto.x.boot.domain.Pedido;

@Service
@Transactional
public class PedidoServiceImpl implements PedidoService{

	@Autowired
	PedidoDao pedidoDao;
	
	@Override
	public void salvar(Pedido pedido) {
		pedidoDao.save(pedido);
	}

	@Override
	public void editar(Pedido pedido) {
		pedidoDao.update(pedido);
	}

	@Override
	public void excluir(Long id) {
		pedidoDao.delete(id);
	}

	@Override
	@Transactional(readOnly = true)
	public Pedido buscarPorId(Long id) {
		return pedidoDao.findById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Pedido> buscarTodos() {
		return pedidoDao.findAll();
	}

}
