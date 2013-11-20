package br.com.ligaesporteamador.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import br.com.ligaesporteamador.bo.VideoBO;
import br.com.ligaesporteamador.model.Video;
import br.com.ligaesporteamador.service.VideoService;

@Controller("rugbyController")
@Scope("request")
public class RugbyController extends VideoBO {

	private Video video;
	private List<Video> videos;
	private List<Video> videosAmador;

	@Autowired
	VideoService videoService;


	public RugbyController() {

		video = new Video();
		videos = new ArrayList<Video>();
		videosAmador = new ArrayList<Video>();
	}

	public Video getVideo() {
		return video;
	}

	@PostConstruct
	public void findHomeVideos() {
		try {
			videos = videoService.findVideoRugby();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@PostConstruct
	public void findHomeVideoAmador() {
		try {
			videosAmador = videoService.findVideoAmadorRugby();
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

	public List<Video> getVideosAmador() {
		return videosAmador;
	}

	public void setVideosAmador(List<Video> videosAmador) {
		this.videosAmador = videosAmador;
	}

}
