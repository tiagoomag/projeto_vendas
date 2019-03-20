package com.projeto.x.boot.dao;

import org.springframework.stereotype.Repository;

import com.projeto.x.boot.domain.Produto;

@Repository
public class ProdutoDaoImpl extends AbstractDao<Produto, Long> implements ProdutoDao {

}
