package com.projeto.x.boot.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.projeto.x.boot.domain.Fornecedor;
import com.projeto.x.boot.domain.UF;
import com.projeto.x.boot.service.FornecedorService;

@Controller
@RequestMapping("/fornecedores")
public class FornecedorController {
	
	@Autowired
	private FornecedorService fornecedorService;
	
	@GetMapping("/cadastrar")
	public String cadastrar(Fornecedor fornecedor) {
		return "/fornecedor/cadastro";
	}
	
	@PostMapping("/salvar")
	public String salvar(Fornecedor fornecedor, RedirectAttributes attr) {
		fornecedorService.salvar(fornecedor);
		attr.addFlashAttribute("success", "Fornecedor inserido com sucesso.");
		return "redirect:/fornecedores/cadastrar";
	}
	
	@GetMapping("/editar/{id}")
	public String preEditar(@PathVariable("id") Long id, ModelMap model) {
		model.addAttribute("fornecedor", fornecedorService.buscarPorId(id));
		return "fornecedor/cadastro";
	}
	
	@PostMapping("/editar")
	public String editar(Fornecedor fornecedor, RedirectAttributes attr) {
		fornecedorService.editar(fornecedor);
		attr.addFlashAttribute("success", "Fornecedor editado com sucesso.");
		return "redirect:/fornecedores/listar";
	}	
	
	@GetMapping("/excluir/{id}")
	public String excluir(@PathVariable("id") Long id, RedirectAttributes attr) {
		fornecedorService.excluir(id);
		attr.addFlashAttribute("success", "Fornecedor excluido com sucesso.");
		return "redirect:/fornecedores/listar"; 	
	}
	
	@GetMapping("/listar")
	public String listar(ModelMap model ) {
		model.addAttribute("fornecedores", fornecedorService.buscarTodos());
		return "/fornecedor/lista";
	}
	
	@ModelAttribute("ufs")
	public UF[] getUFs() {
		return UF.values();
	}

}
