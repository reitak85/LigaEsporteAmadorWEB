package br.com.ligaesporteamador.bo;

import org.apache.commons.lang.StringUtils;

import br.com.ligaesporteamador.model.HorarioJogo;

public class HorarioJogoBO {
	
	
	public String validateForm(HorarioJogo horarioJogo){
		
		String message = "";
		
		if(StringUtils.isEmpty(horarioJogo.getDia())){
			message = "Por favor preencher o campo dia.";
		}else if(horarioJogo.getHoraInicial() == null){
			message = "Por favor preencher o campo horario inicial.";
		}else if(horarioJogo.getHoraFinal() == null){
			message = "Por favor preencher o campo horario final.";
		}
		
		return message;
	}

}
