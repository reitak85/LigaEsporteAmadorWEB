package br.com.ligaesporteamador.service;

import java.util.List;

import br.com.ligaesporteamador.model.Jogador;

public interface JogadorService {

	public Jogador insertJogador(Jogador jogador) throws Exception;
	
	public List<Jogador> findJogador(Jogador jogador) throws Exception;
	
	public void deleteJogador(Long id) throws Exception;
}
