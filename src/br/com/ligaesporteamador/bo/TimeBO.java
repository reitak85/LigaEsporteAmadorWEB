package br.com.ligaesporteamador.bo;

import java.util.Calendar;

import org.apache.commons.lang.StringUtils;

import br.com.ligaesporteamador.model.Time;

public class TimeBO extends JogadorBO{

	public String validaFormTime(Time time) {
		String message = "";
		
		if(time.getEsporte().getId() == null){
			message = "Preencher o campo Esporte.";
		}else if(time.getCategoria().getId() == null){
			message = "Preencher o campo Categoria.";
		}else if(StringUtils.isEmpty(time.getComplementoEndereco().getEndereco().getCep())){
			message = "Preencher o campo CEP.";
		}else if(StringUtils.isEmpty(time.getComplementoEndereco().getNumero())){
			message = "Preencher o campo Número.";
		}else if(StringUtils.isEmpty(time.getComplementoEndereco().getComplemento())){
			message = "Preencher o campo Complemento.";
		}else if(StringUtils.isEmpty(time.getNomeDoTime())){
			message = "Preencher o campo Nome do Time.";
		}else if(time.getCategoriaTime() == null){
			message = "Preencher o campo Categoria.";
		}
		
		return message;
	}
	
	public Time insertDateValidation(Time time) throws Exception{
		time.setDataDeCriacao(Calendar.getInstance());
		return time;
	}
	
	public Time updatetDateValidation(Time time) throws Exception{
		time.setDataDeAtualizacao(Calendar.getInstance());
		return time;
	}
}
