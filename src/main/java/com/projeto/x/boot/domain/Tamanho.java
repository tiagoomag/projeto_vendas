package com.projeto.x.boot.domain;

public enum Tamanho {
	
	PP("PP", "PP"),
	P("P", "P"),
	M("M", "M"),
	G("G", "G"),
	GG("GG", "GG"),
	XLG("XLG", "XLG");
	
	private String sigla;
	private String descricao;
	
	Tamanho(String sigla, String descricao) {
		this.sigla = sigla;
		this.descricao = descricao;
	}

	public String getSigla() {
		return sigla;
	}

	public String getDescricao() {
		return descricao;
	}
	
}
