package br.com.ligaesporteamador.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.ligaesporteamador.model.Video;

@Service
public interface VideoService {

	public List<Video> findVideoHome() throws Exception;
	
	void insertVideo(Video video) throws Exception;

	public List<Video> findHomeVideoAmador() throws Exception;
	
}
