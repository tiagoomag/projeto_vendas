package com.projeto.x.boot.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.projeto.x.boot.domain.Pedido;
import com.projeto.x.boot.domain.Produto;
import com.projeto.x.boot.service.PedidoService;
import com.projeto.x.boot.service.ProdutoService;

@Controller
@RequestMapping("/pedidos")
public class PedidoController {
	
	@Autowired
	PedidoService pedidoService;
	
	@Autowired
	ProdutoService produtoService;
	
	Produto produto = new Produto();
	
	@GetMapping("/cadastrar")
	public String cadastrar(Pedido pedido) {
		return "/pedido/cadastro";
	}
	
	@GetMapping("/listar")
	public String listar(ModelMap model) {
		model.addAttribute("pedidos", pedidoService.buscarTodos());
		return "/pedido/lista";
	}
	
	@PostMapping("/salvar")
	public String salvar(Pedido pedido, Produto produto,  RedirectAttributes attr) {
		pedidoService.salvar(pedido);
		attr.addFlashAttribute("success", "Pedido inserido com sucesso.");
		return "redirect:/pedidos/cadastrar";
	}
	
	@GetMapping("/editar/{id}")
	public String preEditar(@PathVariable("id") Long id, ModelMap model) {
		model.addAttribute("pedidos", pedidoService.buscarPorId(id));
		return "pedido/cadastro";
	}
	
	@PostMapping("/editar")
	public String editar(Pedido pedido, RedirectAttributes attr) {
		pedidoService.editar(pedido);
		attr.addFlashAttribute("success", "Pedido editado com sucesso.");
		return "redirect:/pedidos/listar";
	}	
	
	@GetMapping("/excluir/{id}")
	public String excluir(@PathVariable("id") Long id, RedirectAttributes attr) {
		pedidoService.excluir(id);
		attr.addFlashAttribute("success", "Pedido excluido com sucesso.");
		return "redirect:/pedidos/listar"; 	
	}
	
	@ModelAttribute("produtos")
	public List<Produto> listaDeProdutos() {
		return produtoService.buscarTodos();
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	
	
	
	
	

}
