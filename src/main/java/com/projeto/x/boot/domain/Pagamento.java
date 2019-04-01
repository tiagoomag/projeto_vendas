package com.projeto.x.boot.domain;

public enum Pagamento {

	DÉBITO("DEBT", "Débito"),
	DINHEIRO("DIN", "Dinheiro"),
	CRÉDITO("CREDT", "Crédito"),
	CRÉDITO_PARCELADO_2X_SEM_JUROS("CREDT2XSJ", "Crédito Parc 2x Sem Juros"),
	CRÉDITO_PARCELADO_3X_SEM_JUROS("CREDT3XSJ", "Crédito Parc 3x Sem Juros"),
	CRÉDITO_PARCELADO_4X_SEM_JUROS("CREDT4XSJ", "Crédito Parc 4x Sem Juros"),
	CRÉDITO_PARCELADO_5X_SEM_JUROS("CREDT5XSJ", "Crédito Parc 5x Sem Juros"),
	CRÉDITO_PARCELADO_6X_SEM_JUROS("CREDT6XSJ", "Crédito Parc 6x Sem Juros");

	private String sigla;
	private String descricao;
	
	Pagamento(String sigla, String descricao) {
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

