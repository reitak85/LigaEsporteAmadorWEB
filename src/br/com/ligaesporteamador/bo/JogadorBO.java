package br.com.ligaesporteamador.bo;

import java.util.Calendar;

import org.apache.commons.lang.StringUtils;

import br.com.ligaesporteamador.model.Jogador;

public class JogadorBO {

	public String validaForm(Jogador jogador){
		String message="";

		if(StringUtils.isEmpty(jogador.getNome())){
			message = "Por favor preencher o campo Nome.";
		}else if(StringUtils.isEmpty(jogador.getPosicao())){
			message = "Por favor preencher o campo Posicao.";
		}else if(StringUtils.isEmpty(jogador.getContato().getEmail())){
			message = "Por favor preencher o campo E-mail.";
		}else if(StringUtils.isEmpty(jogador.getContato().getTelefoneCelular())
				&& StringUtils.isEmpty(jogador.getContato().getTelefoneComercial())
				&& StringUtils.isEmpty(jogador.getContato().getTelefoneResidencial())){
			message = "Por favor preencher pelomenos um Telefone.";
		}

		return message;
	}

	public Jogador insertJogadorValidation(Jogador jogador) throws Exception{

		jogador.setDataDeCriacao(Calendar.getInstance());
		return jogador;
	}

}
