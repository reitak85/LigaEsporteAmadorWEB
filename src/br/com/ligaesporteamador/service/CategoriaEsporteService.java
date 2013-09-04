package br.com.ligaesporteamador.service;

import java.util.List;

import br.com.ligaesporteamador.model.CategoriaEsporte;
import br.com.ligaesporteamador.model.Esporte;

public interface CategoriaEsporteService {

	public List<CategoriaEsporte> findCategoriaEsporte(Esporte esporte) throws Exception;
	
	public void insertCategoriaEsporte(CategoriaEsporte categoriaEsporte) throws Exception;
}
