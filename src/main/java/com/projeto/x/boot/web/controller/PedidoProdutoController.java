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

import com.projeto.x.boot.domain.PedidoProduto;
import com.projeto.x.boot.domain.Produto;
import com.projeto.x.boot.service.PedidoProdutoService;
import com.projeto.x.boot.service.ProdutoService;

@Controller
@RequestMapping("/pedidosProdutos")
public class PedidoProdutoController {
	
	
	@Autowired
	PedidoProdutoService pedidoProdutoService;
	
	@Autowired
	ProdutoService produtoService;
	
	private List<PedidoProduto> listaProdutosPedido;
	
	@GetMapping("/cadastrar")
	public String cadastrar(PedidoProduto pedidoProduto) {
		return "/pedido_produto/cadastro";
	}
	
	@GetMapping("/listar")
	public String listar(ModelMap model) {
		model.addAttribute("pedidosProdutos", pedidoProdutoService.buscarTodos());
		return "/pedido_produto/lista";
	}
	
	@PostMapping("/salvar")
	public String salvar(PedidoProduto pedidoProduto, RedirectAttributes attr) {
		pedidoProdutoService.salvar(pedidoProduto);
		attr.addFlashAttribute("success", "Pedido inserido com sucesso.");
		return "redirect:/pedidosProdutos/listar";
	}
	
	@PostMapping("/adicionarProduto")
	public String adicionarProduto(PedidoProduto pedidoProduto, Produto produto, RedirectAttributes attr) {
		pedidoProduto.setProduto(produto);
		listaProdutosPedido.add(pedidoProduto);
		attr.addFlashAttribute("success", "Produto adicionado");
		return null;
	}
	
	@GetMapping("/editar/{id}")
	public String preEditar(@PathVariable("id") Long id, ModelMap model) {
		model.addAttribute("pedidosProdutos", pedidoProdutoService.buscarPorId(id));
		return "pedido-produto/cadastro";
	}
	
	@PostMapping("/editar")
	public String editar(PedidoProduto pedidoProduto, RedirectAttributes attr) {
		pedidoProdutoService.editar(pedidoProduto);
		attr.addFlashAttribute("success", "Pedido editado com sucesso.");
		return "redirect:/pedidosProdutos/listar";
	}	
	
	@GetMapping("/excluir/{id}")
	public String excluir(@PathVariable("id") Long id, RedirectAttributes attr) {
		pedidoProdutoService.excluir(id);
		attr.addFlashAttribute("success", "Pedido excluido com sucesso.");
		return "redirect:/pedidosProdutos/listar"; 	
	}
	
	@ModelAttribute("produtos")
	public List<Produto> listaDeProdutos() {
		return produtoService.buscarTodos();
	}

	//lista de produtos adicionados
	@ModelAttribute("listaProdutosAdicionados")
	public List<PedidoProduto> getListaProdutosPedido() {
		return listaProdutosPedido;
	}

	public void setListaProdutosPedido(List<PedidoProduto> listaProdutosPedido) {
		this.listaProdutosPedido = listaProdutosPedido;
	}
	
	

}
