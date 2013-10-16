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

import org.primefaces.event.FileUploadEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import br.com.ligaesporteamador.bo.HorarioJogoBO;
import br.com.ligaesporteamador.model.HorarioJogo;
import br.com.ligaesporteamador.model.ImagenQuadraCampo;
import br.com.ligaesporteamador.model.QuadraCampo;
import br.com.ligaesporteamador.model.Time;
import br.com.ligaesporteamador.service.EnderecoService;
import br.com.ligaesporteamador.service.HorarioJogoService;
import br.com.ligaesporteamador.service.QuadraCampoService;
import br.com.ligaesporteamador.service.TimeService;
import br.com.ligaesporteamador.util.EnviarMensagem;
import br.com.ligaesporteamador.util.Util;

@Controller("quadraCampoController")
@Scope("session")
public class QuadraCampoController extends HorarioJogoBO{

	@Autowired
	QuadraCampoService quadraCampoService;

	@Autowired
	private EnderecoService enderecoService;
	
	@Autowired 
	private HorarioJogoService horarioJogoService;
	
	@Autowired
	private TimeService timeService;

	private QuadraCampo quadraCampo;
	
	private HorarioJogo horarioJogo;
	
	private Time time;
	
	private List<HorarioJogo> horarioJogos;
	
	private static List<ImagenQuadraCampo> ImagenQuadraCampo = new ArrayList<ImagenQuadraCampo>();
	

	public QuadraCampoController() {

		quadraCampo = new QuadraCampo();
		horarioJogo = new HorarioJogo();
		horarioJogos = new ArrayList<HorarioJogo>();
		time = new Time();
	}

	public void insertQuadraCampo() {

		try {
			
			if(!ImagenQuadraCampo.isEmpty()){
				quadraCampo.setImagenQuadraCampos(ImagenQuadraCampo);
			}
			
			Long timeID = Long.parseLong(Util.getAttribute("timeID"));
			
			
			time  = timeService.findTime(timeID);
			
			quadraCampo = quadraCampoService.insertQuadraCampo(quadraCampo);
			
			EnviarMensagem.informacao("Adicionar horario dos jogos.", null, false);
			
			horarioJogo = new HorarioJogo();
			
			Util.openModal("dlg2");

		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void proximo(){
		try {
			Util.redirect("cadastrarPlano.html");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void saveHorarioJogo(){
		
		try {
			
			String message = validateForm(horarioJogo);
			
			if(!message.equals("")){
				EnviarMensagem.atencao(message, null, false);
			}else{
				
				horarioJogo.setQuandraCampo(quadraCampo);
				
				horarioJogo = horarioJogoService.saveHorarioJogo(horarioJogo);
				horarioJogos = horarioJogoService.findHorarioJogo(horarioJogo);
			}
			
			
			Util.closeModal("dlg2");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void closeHorarioJogo(){
		try {
			
			horarioJogo = new HorarioJogo();
			Util.closeModal("dlg2");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void findEnderecoByCep() {
		try {

			quadraCampo.getComplementoEndereco().setEndereco(
					enderecoService.findEnderecoByCep(quadraCampo
							.getComplementoEndereco().getEndereco()));

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void handleFileUpload(FileUploadEvent event) {
		try {
			
			String user = "/usuario_"+Util.getAttribute("userID");
			File targetFolder = new File("Documents/ligaesporteamador/quadra_campo/imagem"+user);
			
			if(!targetFolder.exists()){
				targetFolder.mkdirs();
			}
			
			InputStream inputStream = event.getFile().getInputstream();
			OutputStream out = new FileOutputStream(new File(targetFolder,
					event.getFile().getFileName()));
			
			
			ImagenQuadraCampo quadra = new ImagenQuadraCampo();
			quadra.setCaminhoImagem(targetFolder+"/"+event.getFile().getFileName());
			quadra.setDataDeCriacao(Calendar.getInstance(new Locale("pt", "BR")));
			quadra.setDescricao("Imagen da Quadra");
			quadra.setLegenda("Quadra Campo");
			
			ImagenQuadraCampo.add(quadra);
			
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

	public QuadraCampo getQuadraCampo() {
		return quadraCampo;
	}

	public void setQuadraCampo(QuadraCampo quadraCampo) {
		this.quadraCampo = quadraCampo;
	}

	public HorarioJogo getHorarioJogo() {
		return horarioJogo;
	}

	public void setHorarioJogo(HorarioJogo horarioJogo) {
		this.horarioJogo = horarioJogo;
	}

	public List<HorarioJogo> getHorarioJogos() {
		return horarioJogos;
	}

	public void setHorarioJogos(List<HorarioJogo> horarioJogos) {
		this.horarioJogos = horarioJogos;
	}

	public Time getTime() {
		return time;
	}

	public void setTime(Time time) {
		this.time = time;
	}
	
}
