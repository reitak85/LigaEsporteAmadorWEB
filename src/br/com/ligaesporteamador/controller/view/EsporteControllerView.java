package br.com.ligaesporteamador.controller.view;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import br.com.ligaesporteamador.model.Esporte;
import br.com.ligaesporteamador.service.EsporteService;
import br.com.ligaesporteamador.util.EnviarMensagem;
import br.com.ligaesporteamador.util.Util;

@Controller("esporteControllerView")
@Scope("request")
public class EsporteControllerView {

	@Autowired
	private EsporteService esporteService;

	private List<Esporte> esportes;
	private Esporte esporte;

	public EsporteControllerView() {
		esportes = new ArrayList<Esporte>();
		esporte = new Esporte();
	}

	@PostConstruct
	public void findAllEsporte() {

		try {
			esportes = esporteService.findEsporte();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void excluirEsporte() {

		try {
			Long id = Long.parseLong(Util.getParam("idExcluir"));
			esporteService.excluirEsporte(id);
			esportes = esporteService.findEsporte();
			EnviarMensagem
					.atencao("Esporte excluido com sucesso!", null, false);
		} catch (Exception e) {
			e.printStackTrace();
			EnviarMensagem.atencao("Erro ao excluir esporte!", null, false);
		}
	}

	public void openModal() {
		try {
			Long id = Long.parseLong(Util.getParam("idAlterar"));
			esporte = esporteService.findEsporteById(id);
			Util.openModal("dlg2");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void closeModal() {
		try {
			Util.closeModal("dlg2");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void editarEsporte() {

	}

	public List<Esporte> getEsportes() {
		return esportes;
	}

	public void setEsportes(List<Esporte> esportes) {
		this.esportes = esportes;
	}

	public Esporte getEsporte() {
		return esporte;
	}

	public void setEsporte(Esporte esporte) {
		this.esporte = esporte;
	}

}
