package br.com.ligaesporteamador.bo;

import java.util.Calendar;

import br.com.ligaesporteamador.model.Video;

public class VideoBO {
	
	public String validadteForm(Video video){
		return "";
	}
	
	public Video insertDateValidation(Video video) throws Exception{
		video.setDataDeCriacao(Calendar.getInstance());
		return video;
	}
	
	public Video updateDateValidation(Video video) throws Exception{
		video.setDataDeAtualizacao(Calendar.getInstance());
		return video;
	}

}
