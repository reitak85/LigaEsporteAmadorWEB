package br.com.ligaesporteamador.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import br.com.ligaesporteamador.bo.CategoriaEsporteBO;
import br.com.ligaesporteamador.model.CategoriaEsporte;
import br.com.ligaesporteamador.model.Esporte;
import br.com.ligaesporteamador.service.CategoriaEsporteService;
import br.com.ligaesporteamador.service.EsporteService;
import br.com.ligaesporteamador.util.EnviarMensagem;

@Controller("categoriaController")
@Scope("request")
public class CategoriaController extends CategoriaEsporteBO{

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

			categoriaEsporte = insertCategoriaValidation(categoriaEsporte);
			String message = validationForm(categoriaEsporte);

			if(!message.equals("")){
				EnviarMensagem.atencao(message, null, false);
			}else{

				categoriaEsporteService.insertCategoriaEsporte(categoriaEsporte);
				EnviarMensagem.informacao("Categoria cadastrada com sucesso.", null, false);
			}
			
		} catch (Exception e) {
			EnviarMensagem.erro("Erro ao cadastrar categoria.", null, false);
			e.printStackTrace();
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
