package br.com.ligaesporteamador.enums;

public enum CategoriaTime {
	
	MANDANTE(1), MADANTE_VISITANTE(2), VISITANTE(3);
	
	private Integer valor;
	
	private CategoriaTime(Integer valor) {
		this.valor = valor;
	}
	
	public Integer getValor() {
		return valor;
	}

}
