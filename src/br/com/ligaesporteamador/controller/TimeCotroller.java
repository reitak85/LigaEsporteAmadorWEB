package br.com.ligaesporteamador.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import br.com.ligaesporteamador.model.CategoriaEsporte;
import br.com.ligaesporteamador.model.ComplementoEndereco;
import br.com.ligaesporteamador.model.Endereco;
import br.com.ligaesporteamador.model.Esporte;
import br.com.ligaesporteamador.model.Jogador;
import br.com.ligaesporteamador.model.Time;
import br.com.ligaesporteamador.service.CategoriaEsporteService;
import br.com.ligaesporteamador.service.EnderecoService;
import br.com.ligaesporteamador.service.EsporteService;
import br.com.ligaesporteamador.service.TimeService;

@Controller("timeController")
@Scope("request")
public class TimeCotroller {

	private Time time;
	private Esporte esporte;
	private CategoriaEsporte categoriaEsporte;
	private Endereco endereco;
	private ComplementoEndereco complementoEndereco;
	private Jogador jogador;
	private List<Jogador> jogadors;
	private List<Esporte> esportes;
	private List<CategoriaEsporte> categoriaEsportes;

	@Autowired
	private EsporteService esporteService;

	@Autowired
	private CategoriaEsporteService categoriaEsporteService;

	@Autowired
	private EnderecoService enderecoService;
	
	@Autowired
	private TimeService timeService;

	public TimeCotroller() {

		time = new Time();
		esporte = new Esporte();
		categoriaEsporte = new CategoriaEsporte();
		endereco = new Endereco();
		complementoEndereco = new ComplementoEndereco();
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

			endereco.setCep(endereco.getCep().replace("-", ""));
			endereco = enderecoService.findEnderecoByCep(endereco);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void insertTime() {

	}
	
	public void addJogador(){
		
		try {
			
			jogadors.add(jogador);
			time.setJogador(jogadors);
			timeService.insertTime(time);
			
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

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public ComplementoEndereco getComplementoEndereco() {
		return complementoEndereco;
	}

	public void setComplementoEndereco(ComplementoEndereco complementoEndereco) {
		this.complementoEndereco = complementoEndereco;
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
