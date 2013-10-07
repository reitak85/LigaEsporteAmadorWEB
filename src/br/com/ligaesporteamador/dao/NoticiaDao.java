package br.com.ligaesporteamador.dao;

import java.util.List;

import br.com.ligaesporteamador.model.Esporte;
import br.com.ligaesporteamador.model.Noticia;

public interface NoticiaDao {

	public List<Noticia> findNoticia() throws Exception;
	
	public List<Noticia> findNoticia(Esporte esporte) throws Exception;
	
	public void insertNoticia(Noticia noticia) throws Exception;

	public void updateNoticia(Noticia noticia) throws Exception;
}
