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

import com.projeto.x.boot.domain.Cliente;
import com.projeto.x.boot.domain.UF;
import com.projeto.x.boot.service.ClienteService;

//Associada com classes que possuem métodos que processam requests numa aplicação web.
@Controller
/*
 * Geralmente utilizada em cima dos métodos de uma classe anotada com @Controller. 
 * Serve para você colocar os endereços da sua aplicação que, quando acessados por algum cliente,
 *  deverão ser direcionados para o determinado método.
 */
@RequestMapping("/clientes") 

public class ClienteController {
	
	@Autowired
	private ClienteService clienteService;
	
	@GetMapping("/cadastrar")
	public String cadastrar(Cliente cliente) {
		return "/cliente/cadastro";
	}
	
	@PostMapping("/salvar")
	public String salvar(Cliente cliente, RedirectAttributes attr) {
		clienteService.salvar(cliente);
		attr.addFlashAttribute("success", "Cliente inserido com sucesso.");
		return "redirect:/clientes/cadastrar";
	}
	
	@GetMapping("/editar/{id}")
	public String preEditar(@PathVariable("id") Long id, ModelMap model) {
		model.addAttribute("cliente", clienteService.buscarPorId(id));
		return "cliente/cadastro";
	}
	
	@PostMapping("/editar")
	public String editar(Cliente cliente, RedirectAttributes attr) {
		clienteService.editar(cliente);
		attr.addFlashAttribute("success", "Cliente editado com sucesso.");
		return "redirect:/clientes/listar";
	}	
	
	@GetMapping("/excluir/{id}")
	public String excluir(@PathVariable("id") Long id, RedirectAttributes attr) {
		clienteService.excluir(id);
		attr.addFlashAttribute("success", "Cliente excluido com sucesso.");
		return "redirect:/clientes/listar"; 	
	}
	
	@GetMapping("/listar")
	public String listar(ModelMap model ) {
		model.addAttribute("clientes", clienteService.buscarTodos());
		return "/cliente/lista";
	}
	
	@ModelAttribute("ufs")
	public UF[] getUFs() {
		return UF.values();
	}

}
