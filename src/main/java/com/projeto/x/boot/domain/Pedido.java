package com.projeto.x.boot.domain;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.*;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

@SuppressWarnings("serial")
@Entity
@Table(name ="PEDIDOS")
public class Pedido extends AbstractEntity<Long> {
	
	@DateTimeFormat(iso = ISO.DATE)
	@Column(name = "data_pedido", nullable = false, columnDefinition = "DATE")
	private LocalDate dataPedido;
	
	@ManyToOne	
	@JoinColumn(name="id_funcionario_fk")
	private Funcionario funcionario;
	
	@ManyToOne	
	@JoinColumn(name="id_cliente_fk")
	private Cliente cliente;
	
	
	@ManyToMany(cascade = CascadeType.ALL)  //1 pedido -> N produtos. 1 produto - > N pedidos
	@JoinTable(name = "pedidos_produtos", joinColumns = { @JoinColumn(name = "pedido_id_fk") }, 
			inverseJoinColumns = { @JoinColumn(name = "produto_id_fk") })
	private List<Produto> produtos; 
	

	public LocalDate getDataPedido() {
		return dataPedido;
	}

	public void setDataPedido(LocalDate dataPedido) {
		this.dataPedido = dataPedido;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	
}
