package br.com.ligaesporteamador.dao;

import java.util.List;

import br.com.ligaesporteamador.model.CategoriaEsporte;
import br.com.ligaesporteamador.model.Esporte;

public interface CategoriaEsporteDao {

	public List<CategoriaEsporte> findCategoriaEsporte(Esporte esporte) throws Exception;
}
