package br.com.ligaesporteamador.bo;

import java.util.Calendar;

import org.apache.commons.lang.StringUtils;

import br.com.ligaesporteamador.model.CategoriaEsporte;

public class CategoriaEsporteBO {

	public CategoriaEsporte insertCategoriaValidation(CategoriaEsporte categoriaEsporte)throws Exception{
		
		categoriaEsporte.setDataDeCriacao(Calendar.getInstance());
		
		return categoriaEsporte;
	}
	
	public String validationForm(CategoriaEsporte categoriaEsporte) throws Exception{
		
		String message="";
		
		if(StringUtils.isEmpty(categoriaEsporte.getNome())){
			message="Preencher o campo Nome !";
		}else if(StringUtils.isEmpty(categoriaEsporte.getDescricao())){
			message="Preencher o campo Descrição !";
		}
		
		return message;
	}
}
