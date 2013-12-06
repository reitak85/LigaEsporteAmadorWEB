package br.com.ligaesporteamador.dao;

import java.util.List;

import br.com.ligaesporteamador.model.Midia;

public interface MidiaDao {

	public void cadastrarMidia(Midia midia) throws Exception;

	public List<Midia> buscarMidia(Midia midia) throws Exception;

	public void alterarMidia(Midia midia) throws Exception;

	public void excluirMidia(Midia midia) throws Exception;

}
