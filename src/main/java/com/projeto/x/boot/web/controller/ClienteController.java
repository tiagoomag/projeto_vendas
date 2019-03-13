package com.projeto.x.boot.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

//Associada com classes que possuem métodos que processam requests numa aplicação web.
@Controller
/*
 * Geralmente utilizada em cima dos métodos de uma classe anotada com @Controller. 
 * Serve para você colocar os endereços da sua aplicação que, quando acessados por algum cliente,
 *  deverão ser direcionados para o determinado método.
 */
@RequestMapping("clientes") 

public class ClienteController {
	
	@GetMapping("/cadastrar")
	public String cadastrar( ) {
		return "/cliente/cadastro";
	}
	
	@GetMapping("/listar")
	public String listar( ) {
		return "/cliente/lista";
	}

}
