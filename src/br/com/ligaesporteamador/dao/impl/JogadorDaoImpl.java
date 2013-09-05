package br.com.ligaesporteamador.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.ligaesporteamador.bd.DataAccessService;
import br.com.ligaesporteamador.dao.JogadorDao;
import br.com.ligaesporteamador.model.Jogador;

@Repository
public class JogadorDaoImpl extends DataAccessService<Jogador> implements JogadorDao{

	@Override
	public void insertJogador(Jogador jogador) throws Exception {
		create(jogador);
	}

	@Override
	public List<Jogador> findJogador(Jogador jogador) throws Exception {
		
		StringBuffer query = new StringBuffer();
		query.append("select j from jogador j where j.time = ");
		query.append(jogador.getTime().getId());
		
		return createQuery(query.toString());
	}
	
	

	
}
