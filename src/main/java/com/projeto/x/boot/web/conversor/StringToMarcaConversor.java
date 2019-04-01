package com.projeto.x.boot.web.conversor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

import com.projeto.x.boot.domain.Marca;
import com.projeto.x.boot.service.MarcaService;

public class StringToMarcaConversor implements Converter<String, Marca>{
	
	@Autowired
	private MarcaService service;
	
	@Override
	public Marca convert(String text) {
		if (text.isEmpty()) {
			return null;
		}
		Long id = Long.valueOf(text);
		return service.buscarPorId(id);
	}

}
