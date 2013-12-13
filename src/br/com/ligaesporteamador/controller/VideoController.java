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

@Controller("cVideoController")
@Scope("request")
public class VideoController extends VideoBO {

	private Video video;
	private List<Esporte> esportes;
	private List<Video> videos;
	private String nome;

	@Autowired
	VideoService videoService;

	@Autowired
	private EsporteService esporteService;

	public VideoController() {

		video = new Video();
		esportes = new ArrayList<Esporte>();
		videos = new ArrayList<Video>();
	}

	public Video getVideo() {
		return video;
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

			if (message.equals("")) {

				video = insertDateValidation(video);

				videoService.insertVideo(video);

				EnviarMensagem.atencao("Video cadastrado com sucesso.", null,
						false);
				video = new Video();

			} else {
				EnviarMensagem.atencao(message, null, false);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void findAllVideo() {

		try {
			videos = videoService.findAllVideo(nome);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<Esporte> getEsportes() {
		return esportes;
	}

	public void setEsportes(List<Esporte> esportes) {
		this.esportes = esportes;
	}

	public List<Video> getVideos() {
		return videos;
	}

	public void setVideos(List<Video> videos) {
		this.videos = videos;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setVideo(Video video) {
		this.video = video;
	}

}
