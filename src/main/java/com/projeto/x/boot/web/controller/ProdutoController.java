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

import com.projeto.x.boot.domain.Cor;
import com.projeto.x.boot.domain.Fornecedor;
import com.projeto.x.boot.domain.Marca;
import com.projeto.x.boot.domain.Produto;
import com.projeto.x.boot.domain.Tamanho;
import com.projeto.x.boot.domain.UnidadeMedida;
import com.projeto.x.boot.service.FornecedorService;
import com.projeto.x.boot.service.MarcaService;
import com.projeto.x.boot.service.ProdutoService;

@Controller
@RequestMapping("/produtos")
public class ProdutoController {
	
	@Autowired
	ProdutoService produtoService;
	
	@Autowired
	MarcaService marcaService;
	
	@Autowired 
	FornecedorService fornecedorService;
	
	@GetMapping("/cadastrar")
	public String cadastrar(Produto produto) {
		produto.setAtivo(true);
		return "/produto/cadastro";
	}
	
	@GetMapping("/listar")
	public String listar(ModelMap model) {
		model.addAttribute("produtos", produtoService.buscarTodos());
		return "/produto/lista";
	}
	
	@PostMapping("/salvar")
	public String salvar(Produto produto, Marca marca, List<Fornecedor> fornecedores, RedirectAttributes attr) {
		produtoService.salvar(produto);
		attr.addFlashAttribute("success", "Produto inserido com sucesso.");
		return "redirect:/produtos/listar";
	}
	
	@GetMapping("/editar/{id}")
	public String preEditar(@PathVariable("id") Long id, ModelMap model) {
		model.addAttribute("produto", produtoService.buscarPorId(id));
		return "produto/cadastro";
	}
	
	@PostMapping("/editar")
	public String editar(Produto produto, RedirectAttributes attr) {
		produtoService.editar(produto);
		attr.addFlashAttribute("success", "Produto editado com sucesso.");
		return "redirect:/produtos/listar";
	}	
	
	@GetMapping("/excluir/{id}")
	public String excluir(@PathVariable("id") Long id, RedirectAttributes attr) {
		produtoService.excluir(id);
		attr.addFlashAttribute("success", "Produto excluido com sucesso.");
		return "redirect:/produtos/listar"; 	
	}
	
	@ModelAttribute("marcas")
	public List<Marca> listaDeMarcas() {
		return marcaService.buscarTodos();
	}
	
	@ModelAttribute("listaFornecedores")
	public List<Fornecedor> listaDeFornecedores() {
		return fornecedorService.buscarTodos();
	}
	
	@ModelAttribute("unidadeMedidas")
	public UnidadeMedida[] getUnidadeMedidas() {
		return UnidadeMedida.values();
	}
	
	@ModelAttribute("tamanhos")
	public Tamanho[] getTamanhos() {
		return Tamanho.values();
	}
	
	@ModelAttribute("cores")
	public Cor[] getCores() {
		return Cor.values();
	}
}
