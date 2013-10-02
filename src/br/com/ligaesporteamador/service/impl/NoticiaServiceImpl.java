package br.com.ligaesporteamador.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ligaesporteamador.dao.NoticiaDao;
import br.com.ligaesporteamador.model.Esporte;
import br.com.ligaesporteamador.model.Noticia;
import br.com.ligaesporteamador.service.NoticiaService;

@Service
public class NoticiaServiceImpl implements NoticiaService{

	@Autowired
	private NoticiaDao noticiaDao;

	@Override
	public List<Noticia> findNoticia() throws Exception {
		return noticiaDao.findNoticia();
	}

	@Override
	public List<Noticia> findNoticia(Esporte esporte) throws Exception {
		return noticiaDao.findNoticia(esporte);
	}

	@Override
	public void insertNoticia(Noticia noticia) throws Exception {
		noticiaDao.insertNoticia(noticia);		
	}

	@Override
	public void updateNoticia(Noticia noticia) throws Exception {
		noticiaDao.updateNoticia(noticia);
	}

}
