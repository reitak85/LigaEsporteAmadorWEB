package br.com.ligaesporteamador.dao;

import br.com.ligaesporteamador.model.Endereco;

public interface EnderecoDao {

	public Endereco findEnderecoByCep(Endereco endereco);
}
