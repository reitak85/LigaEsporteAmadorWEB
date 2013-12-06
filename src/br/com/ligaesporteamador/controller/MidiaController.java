package br.com.ligaesporteamador.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.ligaesporteamador.model.Midia;
import br.com.ligaesporteamador.service.MidiaService;

public class MidiaController {

	@Autowired
	private MidiaService midiaService;

	private Midia midia;
	private List<Midia> listMidia;

	public MidiaController() {

		midia = new Midia();
		listMidia = new ArrayList<Midia>();
	}

	public Midia getMidia() {
		return midia;
	}

	public void setMidia(Midia midia) {
		this.midia = midia;
	}

	public List<Midia> getListMidia() {
		return listMidia;
	}

	public void setListMidia(List<Midia> listMidia) {
		this.listMidia = listMidia;
	}

}
