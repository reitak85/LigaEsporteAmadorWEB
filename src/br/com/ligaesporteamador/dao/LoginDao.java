package br.com.ligaesporteamador.dao;

import br.com.ligaesporteamador.model.UsuarioSistema;

public interface LoginDao {
	
	public UsuarioSistema logar(UsuarioSistema userSistema) throws Exception;

}
