package br.com.ligaesporteamador.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ligaesporteamador.dao.QuadraCampoDao;
import br.com.ligaesporteamador.model.QuadraCampo;
import br.com.ligaesporteamador.service.QuadraCampoService;

@Service
public class QuadraCampoServiceImpl implements QuadraCampoService{

	@Autowired
	QuadraCampoDao campoDao;
	
	@Override
	public QuadraCampo insertQuadraCampo(QuadraCampo campo) throws Exception {
		return campoDao.insertQuadraCampo(campo);
	}

	@Override
	public QuadraCampo updateQuadraCampo() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteQuadraCampo() throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public QuadraCampo selectQuadraCampo(Long id) throws Exception {
		return campoDao.selectQuadraCampo(id);
	}

}
