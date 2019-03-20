package com.projeto.x.boot.domain;

public enum Cor {
	
	BRANCO("BRANCO", "Branco"),
	PRETO("PRETO", "Preto"),
	MAGENTA("MAGENTA", "Magenta"),
	ROSA("ROSA", "Rosa"),
	VERMELHO("VERMELHO", "Vermelho"),
	LARANJA("LARANJA", "Laranja"),
	MARROM("MARROM", "Marrom"),
	AMARELO("AMARELO", "Amarelo"),
	CINZA("CINZA", "Cinza"),
	VERDE("VERDE", "Verde"),
	CIANO("CIANO", "Ciano"),
	AZUL("Azul", "Azul"),
	VIOLETA("VIOLETA", "Violeta");
	
	private String sigla;
	private String descricao;
	
	Cor(String sigla, String descricao) {
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
