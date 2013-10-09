package br.com.ligaesporteamador.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import br.com.ligaesporteamador.bo.TimeBO;
import br.com.ligaesporteamador.model.CategoriaEsporte;
import br.com.ligaesporteamador.model.Esporte;
import br.com.ligaesporteamador.model.Jogador;
import br.com.ligaesporteamador.model.Time;
import br.com.ligaesporteamador.model.Usuario;
import br.com.ligaesporteamador.service.CategoriaEsporteService;
import br.com.ligaesporteamador.service.EnderecoService;
import br.com.ligaesporteamador.service.EsporteService;
import br.com.ligaesporteamador.service.JogadorService;
import br.com.ligaesporteamador.service.TimeService;
import br.com.ligaesporteamador.service.UsuarioService;
import br.com.ligaesporteamador.util.EnviarMensagem;
import br.com.ligaesporteamador.util.Util;

@Controller("timeController")
@Scope("session")
public class TimeController extends TimeBO {

	private Time time;
	private Esporte esporte;
	private CategoriaEsporte categoriaEsporte;
	private Jogador jogadores;
	private Usuario usuario;
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

	@Autowired
	private UsuarioService usuarioService;

	public TimeController() {

		usuario = new Usuario();
		time = new Time();
		esporte = new Esporte();
		categoriaEsporte = new CategoriaEsporte();
		jogadores = new Jogador();
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

	public void cancelJogador(){
		try {
			jogadores = new Jogador();
			Util.closeModal("dlg2");
		} catch (Exception e) {
			EnviarMensagem.erro("Erro ao fechar o popup.", null, false);
			e.printStackTrace();
		}
	}

	public void saveJogador() {
		try {

			String message = validaForm(jogadores);

			if (!message.equals("")) {
				EnviarMensagem.atencao(message, null, false);
			} else {

				jogadores.setTime(time);
				jogadores = insertDateValidation(jogadores);

				jogadores = jogadorService.insertJogador(jogadores);
				jogadors = jogadorService.findJogador(jogadores);
				jogadores = new Jogador();

				EnviarMensagem.informacao("Jogador incluido com sucesso!", null, false);

				Util.closeModal("dlg2");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void deletejogador(){
		
		try {
			
			String id = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("id_jogador");
			FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().remove("id_jogador");
			jogadorService.deleteJogador(Long.parseLong(id));
			jogadors = jogadorService.findJogador(jogadores);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void insertTime() {

		String message = validaFormTime(time);

		if (!message.equals("")) {
			EnviarMensagem.atencao(message, null, false);
		} else {
			try {

					Long idUser = Long.parseLong(Util.getAttribute("userID"));
					

					usuario = usuarioService.findUsuario(idUser);
					time.setUsuario(usuario);
				
				if (time.getId() != null) {
					time = updatetDateValidation(time);
				} else {
					time = insertDateValidation(time);
				}

				time = timeService.insertTime(time);
				EnviarMensagem.informacao("Adicione o seu time.", null, false);

				Util.openModal("dlg2");

			} catch (Exception e) {
				EnviarMensagem.erro("Erro ao cadastrar Time.", null, false);
				e.printStackTrace();
			}
		}

	}

	public void proximo() {
		try {
			Util.removeAttribute("userID");
			FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("timeController");
			Util.redirect("cadastrarQuadraCampo.html");
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

	public List<Jogador> getJogadors() {
		return jogadors;
	}

	public void setJogadors(List<Jogador> jogadors) {
		this.jogadors = jogadors;
	}

	public Jogador getJogadores() {
		return jogadores;
	}

	public void setJogadores(Jogador jogadores) {
		this.jogadores = jogadores;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}
