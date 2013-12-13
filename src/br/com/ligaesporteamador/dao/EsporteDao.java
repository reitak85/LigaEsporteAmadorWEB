package br.com.ligaesporteamador.dao;

import java.util.List;

import org.hibernate.exception.ConstraintViolationException;

import br.com.ligaesporteamador.model.Esporte;

public interface EsporteDao {

	List<Esporte> findEsporte() throws Exception;
	
	void insertEsporte(Esporte esporte) throws Exception, ConstraintViolationException;

	void excluirEsporte(Long id) throws Exception;

	Esporte findEsporteById(Long id) throws Exception;

}
