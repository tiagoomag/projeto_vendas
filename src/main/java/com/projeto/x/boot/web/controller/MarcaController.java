package com.projeto.x.boot.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.projeto.x.boot.domain.Marca;
import com.projeto.x.boot.service.MarcaService;

@Controller
@RequestMapping("/marcas")
public class MarcaController {
	
	@Autowired
	private MarcaService marcaService;
	
	@GetMapping("/cadastrar")
	public String cadastrar(Marca marca) {
		return "/marca/cadastro";
	}
	
	@PostMapping("/salvar")
	public String salvar(Marca marca, RedirectAttributes attr) {
		marcaService.salvar(marca);
		attr.addFlashAttribute("success", "Marca inserida com sucesso.");
		return "redirect:/marcas/listar";
	}
	
	@GetMapping("/editar/{id}")
	public String preEditar(@PathVariable("id") Long id, ModelMap model) {
		model.addAttribute("marca", marcaService.buscarPorId(id));
		return "marca/cadastro";
	}
	
	@PostMapping("/editar")
	public String editar(Marca marca, RedirectAttributes attr) {
		marcaService.editar(marca);
		attr.addFlashAttribute("success", "Marca editado com sucesso.");
		return "redirect:/marcas/listar";
	}	
	
	@GetMapping("/excluir/{id}")
	public String excluir(@PathVariable("id") Long id, RedirectAttributes attr) {
		marcaService.excluir(id);
		attr.addFlashAttribute("success", "Marca excluido com sucesso.");
		return "redirect:/marcas/listar"; 	
	}
	
	@GetMapping("/listar")
	public String listar(ModelMap model ) {
		model.addAttribute("marcas", marcaService.buscarTodos());
		return "/marca/lista";
	}

}
