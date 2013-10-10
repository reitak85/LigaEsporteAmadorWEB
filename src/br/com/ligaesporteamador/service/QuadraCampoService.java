package br.com.ligaesporteamador.service;

import br.com.ligaesporteamador.model.QuadraCampo;

public interface QuadraCampoService {
	
	public QuadraCampo insertQuadraCampo(QuadraCampo campo) throws Exception;
	
	public QuadraCampo updateQuadraCampo() throws Exception;
	
	public void deleteQuadraCampo() throws Exception;
	
	public QuadraCampo selectQuadraCampo(Long id) throws Exception;

}
