package br.com.ligaesporteamador.service;

import java.util.List;

import br.com.ligaesporteamador.model.Esporte;

public interface EsporteService {
	
	List<Esporte> findEsporte()throws Exception;
	
	void insertEsporte(Esporte esporte)throws Exception;

}
