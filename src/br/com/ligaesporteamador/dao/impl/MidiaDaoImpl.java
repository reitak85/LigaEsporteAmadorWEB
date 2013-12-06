package br.com.ligaesporteamador.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.ligaesporteamador.bd.DataAccessService;
import br.com.ligaesporteamador.dao.MidiaDao;
import br.com.ligaesporteamador.model.Midia;

@Repository
public class MidiaDaoImpl extends DataAccessService<Midia> implements MidiaDao{

	@Override
	public void cadastrarMidia(Midia midia) throws Exception {
		
	}

	@Override
	public List<Midia> buscarMidia(Midia midia) throws Exception {
		return null;
	}

	@Override
	public void alterarMidia(Midia midia) throws Exception {
		
	}

	@Override
	public void excluirMidia(Midia midia) throws Exception {
		
	}

}
