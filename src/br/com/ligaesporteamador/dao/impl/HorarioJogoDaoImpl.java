package br.com.ligaesporteamador.dao.impl;

import br.com.ligaesporteamador.bd.DataAccessService;
import br.com.ligaesporteamador.dao.HorarioJogoDao;
import br.com.ligaesporteamador.model.HorarioJogo;

public class HorarioJogoDaoImpl extends DataAccessService<HorarioJogo> implements HorarioJogoDao{

	@Override
	public void saveHorarioJogo(HorarioJogo horarioJogo) throws Exception {
		create(horarioJogo);
	}

}
