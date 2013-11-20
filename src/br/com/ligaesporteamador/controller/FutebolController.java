package br.com.ligaesporteamador.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import br.com.ligaesporteamador.bo.VideoBO;
import br.com.ligaesporteamador.model.Esporte;
import br.com.ligaesporteamador.model.Noticia;
import br.com.ligaesporteamador.model.Video;
import br.com.ligaesporteamador.service.NoticiaService;
import br.com.ligaesporteamador.service.VideoService;

@Controller("futebolController")
@Scope("request")
public class FutebolController extends VideoBO {

	private Video video;
	private List<Video> videos;
	private List<Video> videosAmador;
	private List<Noticia> noticias;

	@Autowired
	private VideoService videoService;

	@Autowired
	private NoticiaService noticiaService;

	public FutebolController() {

		video = new Video();
		videos = new ArrayList<Video>();
		videosAmador = new ArrayList<Video>();
	}

	@PostConstruct
	public void findfutebolVideos() {
		try {
			videos = videoService.findVideoFutebol();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@PostConstruct
	public void findNoticia() {
		try {

			Esporte esporte = new Esporte();
			esporte.setId(1L);

			noticias = noticiaService.findNoticia(esporte);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@PostConstruct
	public void findfutebolVideoAmador() {
		try {
			videosAmador = videoService.findVideoAmadorFutebol();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Video getVideo() {
		return video;
	}

	public void setVideo(Video video) {
		this.video = video;
	}

	public List<Video> getVideos() {
		return videos;
	}

	public void setVideos(List<Video> videos) {
		this.videos = videos;
	}

	public List<Video> getVideosAmador() {
		return videosAmador;
	}

	public void setVideosAmador(List<Video> videosAmador) {
		this.videosAmador = videosAmador;
	}

	public List<Noticia> getNoticias() {
		return noticias;
	}

	public void setNoticias(List<Noticia> noticias) {
		this.noticias = noticias;
	}

}
