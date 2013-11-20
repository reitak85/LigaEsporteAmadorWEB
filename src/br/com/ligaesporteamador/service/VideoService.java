package br.com.ligaesporteamador.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.ligaesporteamador.model.Video;

@Service
public interface VideoService {

	List<Video> findVideoHome() throws Exception;

	List<Video> findVideoFutebol() throws Exception;

	List<Video> findVideoBasquete() throws Exception;

	List<Video> findVideoVolei() throws Exception;

	List<Video> findVideoHandebol() throws Exception;

	List<Video> findVideoTenis() throws Exception;

	List<Video> findVideoRugby() throws Exception;

	List<Video> findHomeVideoAmador() throws Exception;

	List<Video> findVideoAmadorFutebol() throws Exception;

	List<Video> findVideoAmadorBasquete() throws Exception;

	List<Video> findVideoAmadorVolei() throws Exception;

	List<Video> findVideoAmadorHandebol() throws Exception;

	List<Video> findVideoAmadorTenis() throws Exception;

	List<Video> findVideoAmadorRugby() throws Exception;

	void insertVideo(Video video) throws Exception;

	List<Video> findAllVideo(String nome) throws Exception;
	
}
