package br.com.ligaesporteamador.dao.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import br.com.ligaesporteamador.bd.DataAccessService;
import br.com.ligaesporteamador.dao.LoginDao;
import br.com.ligaesporteamador.model.UsuarioSistema;

@Repository
public class LoginDaoImpl extends DataAccessService<UsuarioSistema> implements LoginDao{

	@Override
	public UsuarioSistema logar(UsuarioSistema userSistema) throws Exception {
		
		Map<String, Object>  params = new HashMap<String, Object>();
		String query ="SELECT u FROM UsuarioSistema u WHERE u.email = :email";	
		params.put("email", userSistema.getEmail());
		
	    userSistema = createQueryUniqueResult(query, params);
		
		return userSistema;
	}

	
	
}
