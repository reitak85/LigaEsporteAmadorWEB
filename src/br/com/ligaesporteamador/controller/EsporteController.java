package br.com.ligaesporteamador.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.event.PreRenderViewEvent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import br.com.ligaesporteamador.model.Esporte;
import br.com.ligaesporteamador.service.EsporteService;

@Controller("esporteCoontroller")
@Scope("request")
public class EsporteController {

	private List<Esporte> esportes;

	@Autowired
	private EsporteService esporteService;
	
	public EsporteController() {
		esportes = new ArrayList<Esporte>();
	}

	@PostConstruct
	public void findEsportes(PreRenderViewEvent event) {
		try {
			esportes = esporteService.findEsporte();
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

}
