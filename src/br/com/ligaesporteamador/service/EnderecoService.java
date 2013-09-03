package br.com.ligaesporteamador.service;

import br.com.ligaesporteamador.model.Endereco;

public interface EnderecoService {
	
	public Endereco findEnderecoByCep(Endereco endereco) throws Exception;

}
