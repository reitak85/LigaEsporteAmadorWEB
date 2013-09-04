package br.com.ligaesporteamador.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import br.com.ligaesporteamador.bd.DataAccessService;
import br.com.ligaesporteamador.dao.CategoriaEsporteDao;
import br.com.ligaesporteamador.model.CategoriaEsporte;
import br.com.ligaesporteamador.model.Esporte;

@Repository
public class CategoriaEsporteDaoImpl extends DataAccessService<CategoriaEsporte> implements CategoriaEsporteDao{

	@Override
	public List<CategoriaEsporte> findCategoriaEsporte(Esporte esporte)
			throws Exception {

		Map<String, Object>  params = new HashMap<String, Object>();
		
		String query ="SELECT CE FROM CategoriaEsporte CE WHERE CE.esporte.id = :ESPORTE_ID";	
		params.put("ESPORTE_ID", esporte.getId());
		
		return createQueryById(query, params);
	}

	@Override
	public void insertCategoriaEsporte(
			CategoriaEsporte categoriaEsporte) throws Exception {
		
		create(categoriaEsporte);
	}

}
