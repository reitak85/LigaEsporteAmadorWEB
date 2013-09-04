package br.com.ligaesporteamador.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import br.com.ligaesporteamador.model.CategoriaEsporte;
import br.com.ligaesporteamador.model.Esporte;
import br.com.ligaesporteamador.service.CategoriaEsporteService;
import br.com.ligaesporteamador.service.EsporteService;
import br.com.ligaesporteamador.util.EnviarMensagem;

@Controller("categoriaController")
@Scope("request")
public class CategoriaController {

	@Autowired
	private EsporteService esporteService;
	
	@Autowired
	private CategoriaEsporteService categoriaEsporteService;

	private List<Esporte> esportes;
	private CategoriaEsporte categoriaEsporte;

	public CategoriaController() {
		esportes = new ArrayList<Esporte>();
		categoriaEsporte = new CategoriaEsporte();
	}

	@PostConstruct
	public void findEsportes() {
		try {
			esportes = esporteService.findEsporte();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void insertCategoria(){
		try {
			
			categoriaEsporteService.insertCategoriaEsporte(categoriaEsporte);
			EnviarMensagem.erro("Categoria cadastrada com sucesso.", null, false);
			
		} catch (Exception e) {
			e.printStackTrace();
			EnviarMensagem.erro("Erro ao cadastrar categoria.", null, false);
		}
	}

	public List<Esporte> getEsportes() {
		return esportes;
	}

	public void setEsportes(List<Esporte> esportes) {
		this.esportes = esportes;
	}

	public CategoriaEsporte getCategoriaEsporte() {
		return categoriaEsporte;
	}

	public void setCategoriaEsporte(CategoriaEsporte categoriaEsporte) {
		this.categoriaEsporte = categoriaEsporte;
	}

}
