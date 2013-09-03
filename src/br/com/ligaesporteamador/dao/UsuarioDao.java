package br.com.ligaesporteamador.dao;

import br.com.ligaesporteamador.model.Usuario;

public interface UsuarioDao {

	Usuario insertUsuario(Usuario usuario) throws Exception;
	
	Usuario updateUsuario(Usuario usuario) throws Exception;
	
	Usuario findUsuario(Usuario usuario) throws Exception;
	
	void deleteUsuario(Usuario usuario) throws Exception;
}
