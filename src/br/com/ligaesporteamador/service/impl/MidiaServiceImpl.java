package br.com.ligaesporteamador.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ligaesporteamador.dao.MidiaDao;
import br.com.ligaesporteamador.model.Midia;
import br.com.ligaesporteamador.service.MidiaService;

@Service
public class MidiaServiceImpl implements MidiaService {

	@Autowired
	private MidiaDao midiaDao;
	
	@Override
	public void cadastrarMidia(Midia midia) throws Exception {
		midiaDao.cadastrarMidia(midia);
	}

	@Override
	public List<Midia> buscarMidia(Midia midia) throws Exception {
		return midiaDao.buscarMidia(midia);
	}

	@Override
	public void alterarMidia(Midia midia) throws Exception {
		midiaDao.alterarMidia(midia);
	}

	@Override
	public void excluirMidia(Midia midia) throws Exception {
		midiaDao.excluirMidia(midia);
	}

}
