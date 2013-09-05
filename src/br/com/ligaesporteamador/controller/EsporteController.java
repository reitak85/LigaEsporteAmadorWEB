package br.com.ligaesporteamador.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import br.com.ligaesporteamador.bo.EsporteBO;
import br.com.ligaesporteamador.model.Esporte;
import br.com.ligaesporteamador.service.EsporteService;
import br.com.ligaesporteamador.util.EnviarMensagem;

@Controller("esporteController")
@Scope("request")
public class EsporteController extends EsporteBO{

	private List<Esporte> esportes;
	private Esporte esporte;

	@Autowired
	private EsporteService esporteService;
	
	public EsporteController() {
		esportes = new ArrayList<Esporte>();
		esporte = new Esporte();
	}

	public void insertEsporte(){
		try {
			
			esporte  = insertEsorteValidation(esporte);
			String message = validationForm(esporte); 
			
			if(!message.equals("")){
				EnviarMensagem.atencao(message, null, false);
			}else{
				esporteService.insertEsporte(esporte);
				esporte = null;
				EnviarMensagem.informacao("Esporte cadastrado com sucesso.", null, false);
			}
			
		} catch (Exception e) {
			EnviarMensagem.erro("Erro ao cadastrar esporte !", null, false);
			e.printStackTrace();
		}
	}
	
	

	public Esporte getEsporte() {
		return esporte;
	}

	public void setEsporte(Esporte esporte) {
		this.esporte = esporte;
	}

	public List<Esporte> getEsportes() {
		return esportes;
	}

	public void setEsportes(List<Esporte> esportes) {
		this.esportes = esportes;
	}

}
