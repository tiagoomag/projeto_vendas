package com.projeto.x.boot.web.controller;

import java.util.ArrayList;
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

import com.projeto.x.boot.domain.ProdutoPedido;
import com.projeto.x.boot.domain.Produto;
import com.projeto.x.boot.service.ProdutoPedidoService;
import com.projeto.x.boot.service.ProdutoService;

@Controller
@RequestMapping("/produtosPedidos")
public class ProdutoPedidoController {
	
	@Autowired
	ProdutoPedidoService produtoPedidoService;
	
	@Autowired
	ProdutoService produtoService;
	
	private List<ProdutoPedido> listaProdutosPedido = new ArrayList<>();
	private Produto produto = new Produto();
	private ProdutoPedido produtoPedido = new ProdutoPedido();
	
	@GetMapping("/cadastrar")
	public String cadastrar(ProdutoPedido produtoPedido) {
		return "/produto_pedido/cadastro";
	}
	
	@GetMapping("/listar")
	public String listar(ModelMap model) {
		model.addAttribute("produtosPedidos", produtoPedidoService.buscarTodos());
		return "/produto_pedido/lista";
	}
	
	@PostMapping("/salvar")
	public String salvar(ProdutoPedido produtoPedido, RedirectAttributes attr) {
		produtoPedidoService.salvar(produtoPedido);
		attr.addFlashAttribute("success", "Pedido inserido com sucesso.");
		return "redirect:/produtosPedidos/listar";
	}
	
	@PostMapping("/adicionarProduto")
	public String adicionarProduto(Produto produto, int quantidade, RedirectAttributes attr) {
		ProdutoPedido produtoPedido = new ProdutoPedido();
		produtoPedido.setProduto(produto);
		produtoPedido.setQuantidade(quantidade);
		listaProdutosPedido.add(produtoPedido);
		
		attr.addFlashAttribute("success", "Produto adicionado");
		return "redirect:/produtosPedidos/cadastrar";
	}
	
	@GetMapping("/removerProduto/{id}")
	public String removerProduto(@PathVariable("id") Long id, RedirectAttributes attr) {
		listaProdutosPedido.remove(produtoPedido);
		attr.addFlashAttribute("success", "Produto removido");
		return "redirect:/produtosPedidos/cadastrar";
	}
	
	@GetMapping("/editar/{id}")
	public String preEditar(@PathVariable("id") Long id, ModelMap model) {
		model.addAttribute("pedidosProdutos", produtoPedidoService.buscarPorId(id));
		return "produto_pedido/cadastro";
	}
	
	@PostMapping("/editar")
	public String editar(ProdutoPedido produtoPedido, RedirectAttributes attr) {
		produtoPedidoService.editar(produtoPedido);
		attr.addFlashAttribute("success", "Pedido editado com sucesso.");
		return "redirect:/produtosPedidos/listar";
	}	
	
	@GetMapping("/excluir/{id}")
	public String excluir(@PathVariable("id") Long id, RedirectAttributes attr) {
		produtoPedidoService.excluir(id);
		attr.addFlashAttribute("success", "Pedido excluido com sucesso.");
		return "redirect:/produtosPedidos/listar"; 	
	}
	
	@ModelAttribute("produtos")
	public List<Produto> listaDeProdutos() {
		return produtoService.buscarTodos();
	}

	//lista de produtos adicionados
	@ModelAttribute("listaProdutosAdicionados")
	public List<ProdutoPedido> getListaProdutosPedido() {
		return listaProdutosPedido;
	}

	public void setListaProdutosPedido(List<ProdutoPedido> listaProdutosPedido) {
		this.listaProdutosPedido = listaProdutosPedido;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public ProdutoPedido getProdutoPedido() {
		return produtoPedido;
	}

	public void setProdutoPedido(ProdutoPedido produtoPedido) {
		this.produtoPedido = produtoPedido;
	}

}
