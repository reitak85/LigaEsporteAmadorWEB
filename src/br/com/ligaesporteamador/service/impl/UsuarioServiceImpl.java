package br.com.ligaesporteamador.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ligaesporteamador.dao.UsuarioDao;
import br.com.ligaesporteamador.model.Usuario;
import br.com.ligaesporteamador.service.UsuarioService;

@Service
public class UsuarioServiceImpl implements UsuarioService{

	@Autowired
	UsuarioDao usuarioDao;
	
	@Override
	public Usuario insertUsuario(Usuario usuario) throws Exception {
		return usuarioDao.insertUsuario(usuario);
	}

	@Override
	public Usuario updateUsuario(Usuario usuario) throws Exception {
		return usuarioDao.updateUsuario(usuario);
	}

	@Override
	public Usuario findUsuario(Usuario usuario) throws Exception {
		
		return usuarioDao.findUsuario(usuario);
	}

	@Override
	public void deleteUsuario(Usuario usuario) throws Exception {
		usuarioDao.deleteUsuario(usuario);
	}

}
