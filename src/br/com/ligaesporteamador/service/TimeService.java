package br.com.ligaesporteamador.service;

import br.com.ligaesporteamador.model.Time;

public interface TimeService {

	Time insertTime(Time time) throws Exception;
	
	Time updateTime(Time time) throws Exception;
	
	Time findTime(Long idTime) throws Exception;
	
	void deleteTime(Time time) throws Exception;

}
