package com.projeto.x.boot.domain;

import javax.persistence.Entity;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "pedidos_produtos")
public class PedidoProduto extends AbstractEntity<Long> {

}
