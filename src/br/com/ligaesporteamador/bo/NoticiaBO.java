package br.com.ligaesporteamador.bo;

import java.util.Calendar;

import br.com.ligaesporteamador.model.Noticia;

public class NoticiaBO {

	public Noticia insertNoticiaValidation(Noticia noticia)throws Exception{
		
		noticia.setDataDeCriacao(Calendar.getInstance());
		
		return noticia;
	}

	public Noticia updateNoticiaValidation(Noticia noticia)throws Exception{
		
		noticia.setDataDeAtualizacao(Calendar.getInstance());
		
		return noticia;
	}
	
	public String validationInsertForm(Noticia noticia) throws Exception{
		
		String message="";
		/*
		if(StringUtils.isEmpty(noticia.getNome())){
			message="Preencher o campo Nome !";
		}else if(StringUtils.isEmpty(noticia.getDescricao())){
			message="Preencher o campo Descrição !";
		}
		
		 * 
		 */
		return message;
	}

	public String validationUpdateForm(Noticia noticia) throws Exception{
		
		String message="";
		/*
		if(StringUtils.isEmpty(noticia.getNome())){
			message="Preencher o campo Nome !";
		}else if(StringUtils.isEmpty(noticia.getDescricao())){
			message="Preencher o campo Descrição !";
		}
		
		 * 
		 */
		return message;
	}
}
