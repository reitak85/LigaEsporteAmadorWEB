package br.com.ligaesporteamador.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ligaesporteamador.dao.EnderecoDao;
import br.com.ligaesporteamador.model.Endereco;
import br.com.ligaesporteamador.service.EnderecoService;

@Service
public class EnderecoServiceImpl implements EnderecoService{

	@Autowired
	EnderecoDao enderecoDao;
	
	@Override
	public Endereco findEnderecoByCep(Endereco endereco) {
		return enderecoDao.findEnderecoByCep(endereco);
	}

	
}
