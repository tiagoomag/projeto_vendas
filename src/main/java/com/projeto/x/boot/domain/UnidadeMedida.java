package com.projeto.x.boot.domain;

public enum UnidadeMedida {

	AMPOLA("AMPOLA", "Apola"),
	BALDE("BALDE", "Balde"),
	BANDEJ("BANDEJ", "Bandeja"),
	BARRA("BARRA", "Barra"),
	BISNAG("BISNAG", "Bisnag"),
	BLOCO("BLOCO", "Bloco"),
	BOBINA("BOBINA", "Bobina"),
	BOMBEAR("BOMBEAR", "Bombona"),
	CÁPSULAS("CÁPSULAS", "Cápsulas"),
	CARRINHO("CARRINHO", "Cartela"),
	CENTO("CENTO", "Cento"),
	CJ("CJ", "Conjunto"),
	CM("CM", "Centímetro"),
	CM2("CM2", "Centímetro quadrado"),
	CX("CX", "Caixa"),
	CX2("CX2", "Caixa com 2 unidades"),
	CX3("CX3", "Caixa com 3 unidades"),
	CX5("CX5", "Caixa com 5 unidades"),
	CX10("CX10", "Caixa com 10 unidades"),
	CX20("CX20", "Caixa com 20 unidades"),
	CX25("CX25", "Caixa com 25 unidades"),
	CX50("CX50", "Caixa com 50 unidades"),
	CX100("CX100", "Caixa com 100 unidades"),
	DISP("DISP", "Exibição"),
	DUZIA("DUZIA", "DUZIA"),
	EMBAL("EMBAL", "Embal"),
	FARDO("FARDO", "Fardo"),
	FOLHA("FOLHA", "Folha"),
	FRASCO("FRASCO", "Frasco"),
	GALAO("GALAO", "Galão"),
	GF("GF", "Garrafa"),
	GRAMAS("GRAMAS", "Gramas"),
	JOGO("JOGO", "Jogo"),
	KG("KG", "Kg"),
	KIT("KIT", "Kit"),
	LATA("LATA", "Lata"),
	LITRO("LITRO", "Litro"),
	M("M", "Metro"),
	M2("M2", "Metro quadrado"),
	M3("M3", "Metro cúbico"),
	MILHEI("MILHEI", "Milheiro"),
	ML("ML", "Mililitro"),
	PACOTE("PACOTE", "Pacote"),
	PALETE("PALETE", "Palete"),
	PARES("PARES", "Pares"),
	PC("PC", "Peça"),
	AMIGO("AMIGO", "Amigo"),
	K("K", "Kilate"),
	RESMA("RESMA", "Resma"),
	ROLO("ROLO", "Rolo"),
	SACO("SACO", "Saco"),
	SACOLA("SACOLA", "Sacola"),
	TAMBOR("TAMBOR", "Tambor"),
	TANQUE("TANQUE", "Tanque"),
	TON("TON", "Tonelada"),
	TUBO("TUBO", "Tubo"),
	UNID("UNID", "Unidade"),
	VASIL("VASIL", "Vasilhame"),
	VIDRO("VIDRO", "Vidro");
	
	private String sigla;
	private String descricao;
	
	UnidadeMedida(String sigla, String descricao) {
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
