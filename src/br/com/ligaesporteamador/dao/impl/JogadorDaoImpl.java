package br.com.ligaesporteamador.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import br.com.ligaesporteamador.bd.DataAccessService;
import br.com.ligaesporteamador.dao.JogadorDao;
import br.com.ligaesporteamador.model.Jogador;

@Repository
public class JogadorDaoImpl extends DataAccessService<Jogador> implements JogadorDao{

	@Override
	public Jogador insertJogador(Jogador jogador) throws Exception {
		return create(jogador);
	}

	@Override
	public List<Jogador> findJogador(Jogador jogador) throws Exception {

		Map<String, Object>  params = new HashMap<String, Object>();
		
		String query ="SELECT J FROM Jogador J WHERE J.time.id = :TIME_ID";	
		params.put("TIME_ID", jogador.getTime().getId());
		
		return createQueryById(query, params);
		
	}
	
}
