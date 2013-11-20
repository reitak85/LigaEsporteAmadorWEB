package br.com.ligaesporteamador.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;

import org.primefaces.event.FileUploadEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import br.com.ligaesporteamador.bo.NoticiaBO;
import br.com.ligaesporteamador.model.Esporte;
import br.com.ligaesporteamador.model.Noticia;
import br.com.ligaesporteamador.service.EsporteService;
import br.com.ligaesporteamador.service.NoticiaService;
import br.com.ligaesporteamador.util.EnviarMensagem;

@Controller("noticiaController")
@Scope("request")
public class NoticiaController extends NoticiaBO {
	
	@Autowired
	private EsporteService esporteService;

	@Autowired
	private NoticiaService noticiaService;

	private List<Esporte> esportes;
	private Noticia noticia;
	
	private static String caminhoImagem;

	public NoticiaController() {
		esportes = new ArrayList<Esporte>();
		noticia = new Noticia();
		noticia.setEsporte(new Esporte());
	}

	@PostConstruct
	public void findEsportes() {
		try {
			esportes = esporteService.findEsporte();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void insertNoticia() {
		try {
			
			noticia = insertNoticiaValidation(noticia);
			String message = validationInsertForm(noticia);

			if (!message.equals("")) {
				EnviarMensagem.atencao(message, null, false);
			} else {
				
				noticia.setImagem(caminhoImagem);
				noticiaService.insertNoticia(noticia);
				EnviarMensagem.informacao("Notícia cadastrada com sucesso.", null, false);
				
				caminhoImagem="";
				noticia = new Noticia();

			}

		} catch (Exception e) {
			EnviarMensagem.erro("Erro ao cadastrar not’cia.", null, false);
			e.printStackTrace();
		}
	}

	public void updateNoticia() {
		try {

			noticia = updateNoticiaValidation(noticia);
			String message = validationUpdateForm(noticia);

			if (!message.equals("")) {
				EnviarMensagem.atencao(message, null, false);
			} else {
				noticiaService.insertNoticia(noticia);
				EnviarMensagem.informacao("Not’cia cadastrada com sucesso.", null, false);

			}

		} catch (Exception e) {
			EnviarMensagem.erro("Erro ao cadastrar not’cia.", null, false);
			e.printStackTrace();
		}
	}
	
	public void handleFileUpload(FileUploadEvent event) {
		try {
			
            FacesContext facesContext = FacesContext.getCurrentInstance();    
            ServletContext scontext = (ServletContext) facesContext.getExternalContext().getContext();    
            
            scontext.getRealPath("");
            
            String path = "/Users/luizhenriquedesousasantos/Documents/Desenvolvimento/workspace"+scontext.getContextPath()+"/WebContent/resources/liga/";
			String img = "/resources/liga/";
			
			Calendar c = Calendar.getInstance(new Locale("pt", "BR"));
			int dia = c.get(Calendar.DATE);  
	        int mes = c.get(Calendar.MONTH) + 1;  
	        int ano = c.get(Calendar.YEAR);
	       
			
			path = path.concat(String.valueOf(ano)).concat("/");
			path = path.concat(String.valueOf(mes)).concat("/");
			path = path.concat(String.valueOf(dia)).concat("/");
			
			img = img.concat(String.valueOf(ano)).concat("/");
			img = img.concat(String.valueOf(mes)).concat("/");
			img = img.concat(String.valueOf(dia)).concat("/");
			
			File targetFolder = new File(path);
			
			
			if(!targetFolder.exists()){
				targetFolder.mkdirs();
			}
			
			caminhoImagem = img+"/"+event.getFile().getFileName(); 
			
			
			InputStream inputStream = event.getFile().getInputstream();
			OutputStream out = new FileOutputStream(new File(targetFolder,
					event.getFile().getFileName()));
			
			int read = 0;
			
			byte[] bytes = new byte[2048];

			while ((read = inputStream.read(bytes)) != -1) {
				out.write(bytes, 0, read);
			}
			
			inputStream.close();
			
			out.flush();
			out.close();
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}  
	
	public List<Esporte> getEsportes() {
		return esportes;
	}

	public void setEsportes(List<Esporte> esportes) {
		this.esportes = esportes;
	}

	public Noticia getNoticia() {
		return noticia;
	}

	public void setNoticia(Noticia noticia) {
		this.noticia = noticia;
	}

}
