package br.com.ligaesporteamador.dao.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import br.com.ligaesporteamador.bd.DataAccessService;
import br.com.ligaesporteamador.dao.EnderecoDao;
import br.com.ligaesporteamador.model.Endereco;

@Repository
public class EnderecoDaoImpl extends DataAccessService<Endereco> implements EnderecoDao{

	@Override
	public Endereco findEnderecoByCep(Endereco endereco) {
	
		Map<String, Object>  params = new HashMap<String, Object>();
		
		String query ="SELECT E FROM Endereco E WHERE E.cep = :CEP";	
		params.put("CEP", endereco.getCep());
		
	    endereco = createQueryUniqueResult(query, params);
		
		return endereco;
	}
	
	

}
