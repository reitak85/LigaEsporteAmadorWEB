package br.com.ligaesporteamador.dao.impl;

import org.springframework.stereotype.Repository;

import br.com.ligaesporteamador.bd.DataAccessService;
import br.com.ligaesporteamador.dao.UsuarioDao;
import br.com.ligaesporteamador.model.Usuario;

@Repository
public class UsuarioDaoImpl extends DataAccessService<Usuario> implements UsuarioDao{

	@Override
	public Usuario insertUsuario(Usuario usuario) throws Exception {
		return create(usuario);
	}

	@Override
	public Usuario updateUsuario(Usuario usuario) throws Exception {
		return update(usuario);
	}

	@Override
	public Usuario findUsuario(Usuario usuario) throws Exception {
		return find(usuario.getId());
	}

	@Override
	public void deleteUsuario(Usuario usuario) throws Exception {
		delete(usuario.getId());
	}

}
