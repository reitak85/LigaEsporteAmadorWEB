package br.com.ligaesporteamador.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ligaesporteamador.dao.CategoriaEsporteDao;
import br.com.ligaesporteamador.model.CategoriaEsporte;
import br.com.ligaesporteamador.model.Esporte;
import br.com.ligaesporteamador.service.CategoriaEsporteService;

@Service
public class CategoriaEsporteServiceImpl implements CategoriaEsporteService{

	@Autowired
	private CategoriaEsporteDao categoriaEsporteDao;
	
	@Override
	public List<CategoriaEsporte> findCategoriaEsporte(Esporte esporte)
			throws Exception {

		return categoriaEsporteDao.findCategoriaEsporte(esporte);
	}

}
