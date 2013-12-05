package br.com.ligaesporteamador.dao.impl;

import java.util.HashMap;
import java.util.Map;

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
	public Usuario findUsuario(Long id) throws Exception {

		Map<String, Object>  params = new HashMap<String, Object>();

		String query ="SELECT U FROM Usuario U WHERE U.id = :USUARIO_ID";	
		params.put("USUARIO_ID", id);

		return createQueryUniqueResultID(query, params);
	}
	
	@Override
	public Usuario findUsuarioDuclicado(Usuario usuario) throws Exception {

		Map<String, Object>  params = new HashMap<String, Object>();

		String query ="SELECT U FROM Usuario U WHERE U.cpf = :cpf";	
		params.put("cpf", usuario.getCpf());

		return createQueryUniqueResult(query, params);
	}

	@Override
	public void deleteUsuario(Usuario usuario) throws Exception {
	}

}
