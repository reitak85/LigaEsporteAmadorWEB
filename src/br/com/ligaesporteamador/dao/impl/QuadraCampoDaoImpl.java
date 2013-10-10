package br.com.ligaesporteamador.dao.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import br.com.ligaesporteamador.bd.DataAccessService;
import br.com.ligaesporteamador.dao.QuadraCampoDao;
import br.com.ligaesporteamador.model.QuadraCampo;

@Repository
public class QuadraCampoDaoImpl extends DataAccessService<QuadraCampo>  implements QuadraCampoDao{

	@Override
	public QuadraCampo insertQuadraCampo(QuadraCampo campo) throws Exception {
		return create(campo);
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
		
		Map<String, Object>  params = new HashMap<String, Object>();

		String query ="SELECT U FROM QuadraCampo U WHERE U.id = :QUADRA_ID";	
		params.put("QUADRA_ID", id);

		return createQueryUniqueResultID(query, params);
	}

}
