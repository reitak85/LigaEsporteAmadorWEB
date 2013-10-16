package br.com.ligaesporteamador.dao;

import java.util.List;

import br.com.ligaesporteamador.model.HorarioJogo;

public interface HorarioJogoDao {
	
	public HorarioJogo saveHorarioJogo(HorarioJogo horarioJogo) throws Exception;

	public List<HorarioJogo> findHorarioJogos(HorarioJogo horarioJogo) throws Exception;

}
