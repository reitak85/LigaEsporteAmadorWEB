package br.com.ligaesporteamador.dao;

import java.util.List;

import br.com.ligaesporteamador.model.Esporte;

public interface EsporteDao {

	List<Esporte> findEsporte() throws Exception;

}
