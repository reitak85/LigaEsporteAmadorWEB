package br.com.ligaesporteamador.controller;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.ligaesporteamador.model.Time;
import br.com.ligaesporteamador.service.TimeService;

public class QuadraCampoController {

	@Autowired
	TimeService timeService;

	private Time time;

	public QuadraCampoController() {
		time = new Time();
	}

	public void insertQuadraCampo() {

		try {

//			time = timeService.findTime(idTime);

		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Time getTime() {
		return time;
	}

	public void setTime(Time time) {
		this.time = time;
	}

}
