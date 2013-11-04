package br.com.ligaesporteamador.dao;

import java.util.List;

import br.com.ligaesporteamador.model.Video;

public interface VideoDao {

	List<Video> findVideoHome() throws Exception;
	
	void insertVideo(Video video) throws Exception;

	List<Video> findHomeVideoAmador() throws Exception;
}
