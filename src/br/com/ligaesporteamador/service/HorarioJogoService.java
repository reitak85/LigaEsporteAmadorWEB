package br.com.ligaesporteamador.service;

import java.util.List;

import br.com.ligaesporteamador.model.HorarioJogo;

public interface HorarioJogoService {
	
	public void saveHorarioJogo(HorarioJogo horarioJogo) throws Exception;
	
	public List<HorarioJogo> findHorarioJogo(HorarioJogo horarioJogo) throws Exception;

}
