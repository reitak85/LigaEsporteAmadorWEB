package br.com.ligaesporteamador.controller;

import java.io.IOException;
import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import br.com.ligaesporteamador.bo.UsuarioBO;
import br.com.ligaesporteamador.model.Usuario;
import br.com.ligaesporteamador.service.UsuarioService;
import br.com.ligaesporteamador.util.EnviarMensagem;
import br.com.ligaesporteamador.util.Util;

@Controller("usuarioController")
@Scope("request")
public class UsuarioController extends UsuarioBO{

	private Usuario usuario;

	@Autowired
	UsuarioService usuarioService;

	public UsuarioController() {
		usuario = new Usuario();
	}

	public void insertUsuario() {
		
		String message = validaPreenchimento(usuario);
		
		if(!message.equals("")){
			EnviarMensagem.atencao(message, null, false);
		}else{
			try {
			
				usuario.setDataDeNascimento(Util.stringToCalendar(usuario.getDataNasc()));
				usuarioService.insertUsuario(usuario);
				Util.redirect("cadastrarTime.html");
				
			}catch (ParseException ep) { 
				ep.printStackTrace();
				EnviarMensagem.erro("Ocorreu um erro tente novamente mais tarde.", null, false);
			}catch (IOException io) {
				io.printStackTrace();
			}catch (Exception e) {
				e.printStackTrace();
				EnviarMensagem.erro("Ocorreu um erro tente novamente mais tarde.", null, false);
			}
		}
		
	}

	public void updateUsuario() {

	}

	public void findUsuario() {

	}

	public void deleteUsuario() {

	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}
