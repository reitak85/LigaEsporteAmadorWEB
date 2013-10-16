package br.com.ligaesporteamador.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ligaesporteamador.dao.HorarioJogoDao;
import br.com.ligaesporteamador.model.HorarioJogo;
import br.com.ligaesporteamador.service.HorarioJogoService;

@Service
public class HorarioJogoServiceImpl implements HorarioJogoService{

	@Autowired
	HorarioJogoDao horarioJogoDao;
	
	@Override
	public HorarioJogo saveHorarioJogo(HorarioJogo horarioJogo) throws Exception {
		return horarioJogoDao.saveHorarioJogo(horarioJogo);
	}

	@Override
	public List<HorarioJogo> findHorarioJogo(HorarioJogo horarioJogo)
			throws Exception {
		return horarioJogoDao.findHorarioJogos(horarioJogo);
	}

}
