package br.com.ligaesporteamador.dao.impl;

import java.util.List;

import org.hibernate.exception.ConstraintViolationException;
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
	public void insertEsporte(Esporte esporte) throws Exception, ConstraintViolationException {
		create(esporte);
	}

	@Override
	public void excluirEsporte(Long id) throws Exception {
		Esporte esporte = em.find(Esporte.class, id);
		remove(esporte);
	}

	@Override
	public Esporte findEsporteById(Long id) throws Exception{
		return em.find(Esporte.class, id);
	}

}
