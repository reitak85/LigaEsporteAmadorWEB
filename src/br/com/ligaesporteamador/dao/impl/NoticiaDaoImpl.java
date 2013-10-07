package br.com.ligaesporteamador.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import br.com.ligaesporteamador.bd.DataAccessService;
import br.com.ligaesporteamador.dao.NoticiaDao;
import br.com.ligaesporteamador.model.CategoriaEsporte;
import br.com.ligaesporteamador.model.Esporte;
import br.com.ligaesporteamador.model.Noticia;

@Repository
public class NoticiaDaoImpl extends DataAccessService<Noticia> implements NoticiaDao{
	
	@Override
	public List<Noticia> findNoticia() throws Exception {

		Map<String, Object>  params = new HashMap<String, Object>();
		
		String query ="SELECT CE FROM Noticia NO";
		
		return createQueryById(query, params);
	}

	@Override
	public List<Noticia> findNoticia(Esporte esporte)
			throws Exception {

		Map<String, Object>  params = new HashMap<String, Object>();
		
		String query ="SELECT CE FROM Noticia NO WHERE NO.esporte.id = :ESPORTE_ID";	
		params.put("ESPORTE_ID", esporte.getId());
		
		return createQueryById(query, params);
	}

	@Override
	public void insertNoticia(
			Noticia noticia) throws Exception {
		
		create(noticia);
	}

	@Override
	public void updateNoticia(Noticia noticia) throws Exception {
		update(noticia);
	}

}
