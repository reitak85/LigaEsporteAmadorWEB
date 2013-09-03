package br.com.ligaesporteamador.dao;

import br.com.ligaesporteamador.model.Time;

public interface TimeDao {

	Time insertTime(Time time) throws Exception;
	
	Time updateTime(Time time) throws Exception;
	
	Time findTime(Time time) throws Exception;
	
	void deleteTime(Time time) throws Exception;
}
