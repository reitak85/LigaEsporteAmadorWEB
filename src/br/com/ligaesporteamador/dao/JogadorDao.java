package br.com.ligaesporteamador.dao;

import java.util.List;

import br.com.ligaesporteamador.model.Jogador;

public interface JogadorDao {

	public Jogador insertJogador(Jogador jogador) throws Exception;
	
	public List<Jogador> findJogador(Jogador jogador) throws Exception;
	
	public void deleteJogador(Long id) throws Exception;
}
