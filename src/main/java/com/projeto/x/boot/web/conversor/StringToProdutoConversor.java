/*package com.projeto.x.boot.web.conversor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.projeto.x.boot.domain.Produto;
import com.projeto.x.boot.service.ProdutoService;

@Component
public class StringToProdutoConversor implements Converter<String, Produto> {
	
	@Autowired
	private ProdutoService service;

	@Override
	public Produto convert(String text) {
		if (text.isEmpty()) {
			return null;
		}
		Long id = Long.valueOf(text);
		return service.buscarPorId(id);
	}

}*/
