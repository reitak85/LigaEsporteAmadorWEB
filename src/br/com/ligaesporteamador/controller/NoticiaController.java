package br.com.ligaesporteamador.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.primefaces.event.FileUploadEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import br.com.ligaesporteamador.bo.NoticiaBO;
import br.com.ligaesporteamador.model.Esporte;
import br.com.ligaesporteamador.model.Noticia;
import br.com.ligaesporteamador.service.EsporteService;
import br.com.ligaesporteamador.service.NoticiaService;
import br.com.ligaesporteamador.util.EnviarMensagem;

@Controller("noticiaController")
@Scope("request")
public class NoticiaController extends NoticiaBO {
	
	@Autowired
	private EsporteService esporteService;

	@Autowired
	private NoticiaService noticiaService;

	private List<Esporte> esportes;
	private Noticia noticia;

	public NoticiaController() {
		esportes = new ArrayList<Esporte>();
		noticia = new Noticia();
		noticia.setEsporte(new Esporte());
	}

	@PostConstruct
	public void findEsportes() {
		try {
			esportes = esporteService.findEsporte();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void insertNoticia() {
		try {
			noticia = insertNoticiaValidation(noticia);
			String message = validationInsertForm(noticia);

			if (!message.equals("")) {
				EnviarMensagem.atencao(message, null, false);
			} else {
				noticiaService.insertNoticia(noticia);
				EnviarMensagem.informacao("Notícia cadastrada com sucesso.", null, false);

			}

		} catch (Exception e) {
			EnviarMensagem.erro("Erro ao cadastrar notícia.", null, false);
			e.printStackTrace();
		}
	}

	public void updateNoticia() {
		try {

			noticia = updateNoticiaValidation(noticia);
			String message = validationUpdateForm(noticia);

			if (!message.equals("")) {
				EnviarMensagem.atencao(message, null, false);
			} else {
				noticiaService.insertNoticia(noticia);
				EnviarMensagem.informacao("Notícia cadastrada com sucesso.", null, false);

			}

		} catch (Exception e) {
			EnviarMensagem.erro("Erro ao cadastrar notícia.", null, false);
			e.printStackTrace();
		}
	}
	
	public void handleFileUpload(FileUploadEvent event) {  
        System.out.println("OKOK agora bora rss");
        EnviarMensagem.informacao((event.getFile().getFileName() + " is uploaded."), null, false);

    } 
	
	public List<Esporte> getEsportes() {
		return esportes;
	}

	public void setEsportes(List<Esporte> esportes) {
		this.esportes = esportes;
	}

	public Noticia getNoticia() {
		return noticia;
	}

	public void setNoticia(Noticia noticia) {
		this.noticia = noticia;
	}

}
