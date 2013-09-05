package br.com.ligaesporteamador.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.ligaesporteamador.bd.DataAccessService;
import br.com.ligaesporteamador.dao.EsporteDao;
import br.com.ligaesporteamador.model.Esporte;

@Repository
public class EsporteDaoImpl extends DataAccessService<Esporte> implements EsporteDao{
	
	@Override
	public List<Esporte> findEsporte() throws Exception {	
		return createQuery("SELECT e FROM Esporte e");
	}

	@Override
	public void insertEsporte(Esporte esporte) throws Exception {
		create(esporte);
	}

}
