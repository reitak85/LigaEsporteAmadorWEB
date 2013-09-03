package br.com.ligaesporteamador.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ligaesporteamador.dao.TimeDao;
import br.com.ligaesporteamador.model.Time;
import br.com.ligaesporteamador.service.TimeService;

@Service
public class TimeServiceImpl implements TimeService{

	@Autowired
	TimeDao timeDao;
	
	@Override
	public Time insertTime(Time time) throws Exception {
		return timeDao.insertTime(time);
	}

	@Override
	public Time updateTime(Time time) throws Exception {
		return null;
	}

	@Override
	public Time findTime(Time time) throws Exception {
		return null;
	}

	@Override
	public void deleteTime(Time time) throws Exception {
		
	}



}
