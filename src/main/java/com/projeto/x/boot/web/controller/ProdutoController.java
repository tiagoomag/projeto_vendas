package com.projeto.x.boot.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.projeto.x.boot.domain.Produto;
import com.projeto.x.boot.service.ProdutoService;

@Controller
@RequestMapping("/produtos")
public class ProdutoController {
	
	@Autowired
	ProdutoService produtoService;
	
	@GetMapping("/cadastrar")
	public String cadastrar(Produto produto) {
		return "/produto/cadastro";
	}
	
	@PostMapping("/salvar")
	public String salvar(Produto produto, RedirectAttributes attr) {
		produtoService.salvar(produto);
		attr.addFlashAttribute("success", "Produto inserido com sucesso.");
		return "redirect:/produtos/listar";
	}
	
	

}
