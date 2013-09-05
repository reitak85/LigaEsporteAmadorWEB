package br.com.ligaesporteamador.bo;

import java.util.Calendar;

import org.apache.commons.lang.StringUtils;

import br.com.ligaesporteamador.model.Esporte;

public class EsporteBO {
	
	public Esporte insertEsorteValidation(Esporte esporte) throws Exception{
		
		esporte.setDataDeCriacao(Calendar.getInstance());
		
		return esporte;
	}
	
	public String validationForm(Esporte esporte) throws Exception{
		
		String message="";
		
		if(StringUtils.isEmpty(esporte.getNome())){
			message="Preencher o campo Nome !";
		}else if(StringUtils.isEmpty(esporte.getDescricao())){
			message="Preencher o campo Descrição !";
		}
		
		return message;
	}

}
