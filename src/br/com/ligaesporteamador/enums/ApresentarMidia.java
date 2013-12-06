package br.com.ligaesporteamador.enums;

public enum ApresentarMidia {

	FUTEBOL(1), 
	BASQUETE(2), 
	TENIS(3), 
	VOLEI(4), 
	HANDEBOL(5), 
	RUGBY(6), 
	GERAL(7), 
	TODAS(8);

	private Integer valor;

	private ApresentarMidia(Integer valor) {
		this.valor = valor;
	}

	public Integer getValor() {
		return valor;
	}

}
