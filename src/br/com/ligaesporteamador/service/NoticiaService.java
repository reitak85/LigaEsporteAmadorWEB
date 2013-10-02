package br.com.ligaesporteamador.service;

import java.util.List;

import br.com.ligaesporteamador.model.Esporte;
import br.com.ligaesporteamador.model.Noticia;

public interface NoticiaService {

	public List<Noticia> findNoticia() throws Exception;
	
	public List<Noticia> findNoticia(Esporte esporte) throws Exception;
	
	public void insertNoticia(Noticia noticia) throws Exception;

	public void updateNoticia(Noticia noticia) throws Exception;
}
