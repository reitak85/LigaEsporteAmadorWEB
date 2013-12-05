package br.com.ligaesporteamador.service;

import br.com.ligaesporteamador.model.Usuario;

public interface UsuarioService {

	Usuario insertUsuario(Usuario usuario) throws Exception;
	
	Usuario updateUsuario(Usuario usuario) throws Exception;
	
	Usuario findUsuario(Long id) throws Exception;
	
	void deleteUsuario(Usuario usuario) throws Exception;

	Usuario findUsuarioDuplicado(Usuario usuario) throws Exception;
}
