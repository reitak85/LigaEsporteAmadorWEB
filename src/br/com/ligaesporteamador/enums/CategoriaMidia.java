package br.com.ligaesporteamador.enums;

public enum CategoriaMidia {
	
	PRINCIPAL(1), SECUNDARIA(2), INSTITUCIONAL(3);
	
	private Integer valor;
	
	private CategoriaMidia(Integer valor) {
		this.valor = valor;
	}
	
	public Integer getValor() {
		return valor;
	}

}
