package br.com.ligaesporteamador.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import br.com.ligaesporteamador.bo.TimeBO;
import br.com.ligaesporteamador.model.CategoriaEsporte;
import br.com.ligaesporteamador.model.Esporte;
import br.com.ligaesporteamador.model.Jogador;
import br.com.ligaesporteamador.model.Time;
import br.com.ligaesporteamador.service.CategoriaEsporteService;
import br.com.ligaesporteamador.service.EnderecoService;
import br.com.ligaesporteamador.service.EsporteService;
import br.com.ligaesporteamador.service.JogadorService;
import br.com.ligaesporteamador.service.TimeService;
import br.com.ligaesporteamador.util.EnviarMensagem;
import br.com.ligaesporteamador.util.Util;


@Controller("timeController")
@Scope("request")
public class TimeController extends TimeBO{

	private Time time;
	private Esporte esporte;
	private CategoriaEsporte categoriaEsporte;
	private Jogador jogador;
	private List<Jogador> jogadors;
	private List<Esporte> esportes;
	private List<CategoriaEsporte> categoriaEsportes;

	@Autowired
	private EsporteService esporteService;
	
	@Autowired
	private JogadorService jogadorService;

	@Autowired
	private CategoriaEsporteService categoriaEsporteService;

	@Autowired
	private EnderecoService enderecoService;
	
	@Autowired
	private TimeService timeService;

	public TimeController() {

		time = new Time();
		esporte = new Esporte();
		categoriaEsporte = new CategoriaEsporte();
		jogador = new Jogador();
		esportes = new ArrayList<Esporte>();
		categoriaEsportes = new ArrayList<CategoriaEsporte>();
		jogadors = new ArrayList<Jogador>();
	}

	@PostConstruct
	public void findEsportes() {
		try {
			esportes = esporteService.findEsporte();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void findCategoriaEsporte() {
		try {
			esporte.setId(time.getEsporte().getId());
			categoriaEsportes = categoriaEsporteService
					.findCategoriaEsporte(esporte);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void findEnderecoByCep() {
		try {
			
			time.getComplementoEndereco()
					.getEndereco()
					.setCep(time.getComplementoEndereco().getEndereco()
							.getCep().replace("-", ""));

			time.getComplementoEndereco().setEndereco(
					enderecoService.findEnderecoByCep(time
							.getComplementoEndereco().getEndereco()));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void addJogador(){
		try {
			
			jogador.setTime(time);
			jogador = insertJogadorValidation(jogador);
			
			String message = validaForm(jogador);
			
			if(!message.equals("")){
				EnviarMensagem.atencao(message, null, false);
			}else{
				jogadorService.insertJogador(jogador);
				jogadors = jogadorService.findJogador(jogador);
				jogador = null;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void insertTime(){
		try {
			
			String message = validaFormTime(time);
			time = insertTimeValidation(time);
			
			if(!message.equals("")){
				EnviarMensagem.atencao(message, null, false);
			}else{

				if(time.getId() == null){
					time = timeService.insertTime(time);
					EnviarMensagem.informacao("Adicione o seu time.", null, false);
				}else{
					
				}
				
				jogador = null;
				Util.openModal("dlg2");
			}
			
		} catch (Exception e) {
			EnviarMensagem.erro("Erro ao cadastrar Time.", null, false);
			e.printStackTrace();
		}
	}

	public List<Esporte> getEsportes() {
		return esportes;
	}

	public void setEsportes(List<Esporte> esportes) {
		this.esportes = esportes;
	}

	public Time getTime() {
		return time;
	}

	public void setTime(Time time) {
		this.time = time;
	}

	public Esporte getEsporte() {
		return esporte;
	}

	public void setEsporte(Esporte esporte) {
		this.esporte = esporte;
	}

	public List<CategoriaEsporte> getCategoriaEsportes() {
		return categoriaEsportes;
	}

	public void setCategoriaEsportes(List<CategoriaEsporte> categoriaEsportes) {
		this.categoriaEsportes = categoriaEsportes;
	}

	public CategoriaEsporte getCategoriaEsporte() {
		return categoriaEsporte;
	}

	public void setCategoriaEsporte(CategoriaEsporte categoriaEsporte) {
		this.categoriaEsporte = categoriaEsporte;
	}

	public Jogador getJogador() {
		return jogador;
	}

	public void setJogador(Jogador jogador) {
		this.jogador = jogador;
	}

	public List<Jogador> getJogadors() {
		return jogadors;
	}

	public void setJogadors(List<Jogador> jogadors) {
		this.jogadors = jogadors;
	}

}
