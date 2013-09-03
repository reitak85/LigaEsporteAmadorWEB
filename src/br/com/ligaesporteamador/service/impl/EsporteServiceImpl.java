package br.com.ligaesporteamador.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ligaesporteamador.dao.EsporteDao;
import br.com.ligaesporteamador.model.Esporte;
import br.com.ligaesporteamador.service.EsporteService;

@Service
public class EsporteServiceImpl implements EsporteService{

	@Autowired
	EsporteDao esporteDao;
	
	@Override
	public List<Esporte> findEsporte() throws Exception {
		return esporteDao.findEsporte();
	}

}
