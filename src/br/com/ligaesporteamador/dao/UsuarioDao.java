package br.com.ligaesporteamador.dao;

import br.com.ligaesporteamador.model.Usuario;

public interface UsuarioDao {

	Usuario insertUsuario(Usuario usuario) throws Exception;
	
	Usuario updateUsuario(Usuario usuario) throws Exception;
	
	Usuario findUsuario(Long id) throws Exception;
	
	void deleteUsuario(Usuario usuario) throws Exception;
	
	public Usuario findUsuarioDuclicado(Usuario usuario) throws Exception;
}
