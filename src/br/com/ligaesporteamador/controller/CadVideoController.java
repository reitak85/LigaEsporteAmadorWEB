package br.com.ligaesporteamador.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import br.com.ligaesporteamador.bo.VideoBO;
import br.com.ligaesporteamador.model.Esporte;
import br.com.ligaesporteamador.model.Video;
import br.com.ligaesporteamador.service.EsporteService;
import br.com.ligaesporteamador.service.VideoService;
import br.com.ligaesporteamador.util.EnviarMensagem;

@Controller("cadVideoController")
@Scope("request")
public class CadVideoController extends VideoBO {

	private Video video;
	private List<Esporte> esportes;

	@Autowired
	VideoService videoService;

	@Autowired
	private EsporteService esporteService;

	public CadVideoController() {

		video = new Video();
		esportes = new ArrayList<Esporte>();
	}

	public Video getVideo() {
		return video;
	}

	public void insertVideo() {

		try {

			String message = validadteForm(video);

			if (message.equals("")) {

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

	public void setVideo(Video video) {
		this.video = video;
	}

	public List<Esporte> getEsportes() {
		return esportes;
	}

	public void setEsportes(List<Esporte> esportes) {
		this.esportes = esportes;
	}

}
