package br.com.ligaesporteamador.service;

import br.com.ligaesporteamador.model.UsuarioSistema;

public interface LoginService {
	
	public UsuarioSistema logar(UsuarioSistema userSistema) throws Exception;

}
