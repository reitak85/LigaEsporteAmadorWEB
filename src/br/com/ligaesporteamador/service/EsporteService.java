package br.com.ligaesporteamador.service;

import java.util.List;

import org.hibernate.exception.ConstraintViolationException;

import br.com.ligaesporteamador.model.Esporte;

public interface EsporteService {
	
	List<Esporte> findEsporte()throws Exception;
	
	void insertEsporte(Esporte esporte)throws Exception, ConstraintViolationException;
	
	public void excluirEsporte(Long id) throws Exception;

	Esporte findEsporteById(Long id) throws Exception;
}
