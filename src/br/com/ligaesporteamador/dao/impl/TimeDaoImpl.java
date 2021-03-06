package br.com.ligaesporteamador.dao.impl;

import org.springframework.stereotype.Repository;

import br.com.ligaesporteamador.bd.DataAccessService;
import br.com.ligaesporteamador.dao.TimeDao;
import br.com.ligaesporteamador.model.Time;

@Repository
public class TimeDaoImpl extends DataAccessService<Time> implements TimeDao{
	
	public TimeDaoImpl() {
	}

	@Override
	public Time insertTime(Time time) throws Exception {
		return create(time);
	}

	@Override
	public Time updateTime(Time time) throws Exception {
		return update(time);
	}

	@Override
	public Time findTime(Long idTime) throws Exception {
		return em.find(Time.class, idTime);
	}

	@Override
	public void deleteTime(Time time) throws Exception {
		 Object ref = this.em.getReference(Time.class, time.getId());
	     this.em.remove(ref);
	}
}
