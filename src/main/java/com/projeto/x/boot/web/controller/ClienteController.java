package com.projeto.x.boot.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.projeto.x.boot.domain.Cliente;
import com.projeto.x.boot.domain.Funcionario;
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
	
	@GetMapping("/listar")
	public String listar( ) {
		return "/cliente/lista";
	}
	
	@PostMapping("/salvar")
	public String salvar(Cliente cliente, RedirectAttributes attr) {
		clienteService.salvar(cliente);
		attr.addFlashAttribute("success", "Cliente inserido com sucesso.");
		return "redirect:/clientes/cadastrar";
	}
	
	@ModelAttribute("ufs")
	public UF[] getUFs() {
		return UF.values();
	}

}
