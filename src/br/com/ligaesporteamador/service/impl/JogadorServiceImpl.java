package br.com.ligaesporteamador.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ligaesporteamador.dao.JogadorDao;
import br.com.ligaesporteamador.model.Jogador;
import br.com.ligaesporteamador.service.JogadorService;

@Service
public class JogadorServiceImpl implements JogadorService{

	@Autowired
	JogadorDao jogadorDao;
	
	@Override
	public Jogador insertJogador(Jogador jogador) throws Exception {
		return jogadorDao.insertJogador(jogador);
	}

	@Override
	public List<Jogador> findJogador(Jogador jogador) throws Exception {
		return jogadorDao.findJogador(jogador);
	}

}
