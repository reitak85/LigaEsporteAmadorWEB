package br.com.ligaesporteamador.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ligaesporteamador.dao.LoginDao;
import br.com.ligaesporteamador.model.UsuarioSistema;
import br.com.ligaesporteamador.service.LoginService;

@Service
public class LoginServiceImpl implements LoginService{

	@Autowired
	LoginDao loginDao;
	
	@Override
	public UsuarioSistema logar(UsuarioSistema userSistema) throws Exception {
		return loginDao.logar(userSistema);
	}

	
	
	
}
