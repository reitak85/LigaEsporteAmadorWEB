package br.com.ligaesporteamador.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import br.com.ligaesporteamador.bo.VideoBO;
import br.com.ligaesporteamador.model.Esporte;
import br.com.ligaesporteamador.model.Video;
import br.com.ligaesporteamador.service.EsporteService;
import br.com.ligaesporteamador.service.VideoService;
import br.com.ligaesporteamador.util.EnviarMensagem;

@Controller("videoController")
@Scope("request")
public class VideoController extends VideoBO {

	private Video video;
	private List<Video> videos;
	private List<Video> videosAmador;
	private List<Esporte> esportes;

	@Autowired
	VideoService videoService;

	@Autowired
	private EsporteService esporteService;

	public VideoController() {

		video = new Video();
		videos = new ArrayList<Video>();
		esportes = new ArrayList<Esporte>();
		videosAmador = new ArrayList<Video>();
	}

	public Video getVideo() {
		return video;
	}

	@PostConstruct
	public void findHomeVideos() {
		try {
			videos = videoService.findVideoHome();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@PostConstruct
	public void findHomeVideoAmador() {
		try {
			videosAmador = videoService.findHomeVideoAmador();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@PostConstruct
	public void findEsportes() {
		try {
			esportes = esporteService.findEsporte();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void insertVideo() {

		try {

			String message = validadteForm(video);

			if (!message.equals("")) {

				videoService.insertVideo(video);

				EnviarMensagem.atencao("Video cadastrado com sucesso.", null,false);
				video = new Video();

			} else {
				EnviarMensagem.atencao(message, null, false);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
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

	public List<Esporte> getEsportes() {
		return esportes;
	}

	public void setEsportes(List<Esporte> esportes) {
		this.esportes = esportes;
	}

	public List<Video> getVideosAmador() {
		return videosAmador;
	}

	public void setVideosAmador(List<Video> videosAmador) {
		this.videosAmador = videosAmador;
	}

}
