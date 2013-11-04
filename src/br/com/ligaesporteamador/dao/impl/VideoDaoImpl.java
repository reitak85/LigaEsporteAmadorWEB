package br.com.ligaesporteamador.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import br.com.ligaesporteamador.bd.DataAccessService;
import br.com.ligaesporteamador.dao.VideoDao;
import br.com.ligaesporteamador.model.Video;

@Repository
public class VideoDaoImpl extends DataAccessService<Video> implements VideoDao{

	@Override
	public List<Video> findVideoHome() throws Exception {
		
		Map<String, Object>  params = new HashMap<String, Object>();
		
		String query ="SELECT v FROM Video v WHERE v.categoria = :categoria order by v.dataDeCriacao desc LIMIT 0, 4";	
		params.put("categoria", "Profissional");
		
		return createQueryById(query, params);
		
	}

	@Override
	public void insertVideo(Video video) throws Exception {
		create(video);
	}

	@Override
	public List<Video> findHomeVideoAmador() throws Exception {
		
		Map<String, Object>  params = new HashMap<String, Object>();
		
		String query ="SELECT v FROM Video v WHERE v.categoria = :categoria order  by v.dataDeCriacao desc LIMIT 0, 4";
		params.put("categoria", "Amador");
		
		return createQueryById(query, params);
	}

}
