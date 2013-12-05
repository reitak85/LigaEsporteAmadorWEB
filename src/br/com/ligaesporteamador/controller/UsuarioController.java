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
import br.com.ligaesporteamador.util.MD5;
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

	public void insertUsuario() throws Exception {
		
		String message = validaPreenchimento(usuario);
		
		Usuario user = usuarioService.findUsuarioDuplicado(usuario);
		
		
		
		if(!message.equals("")){
			EnviarMensagem.atencao(message, null, false);
		}else if(user !=null && user.getCpf().length()>0 ) {
			EnviarMensagem.atencao("Usuario com esse CPF já se encontra cadastrado : " + user.getCpf(), null, false);
		}else{
			try {
			
				if(usuario.getId() != null){
					usuario = updateDateValidation(usuario);
				}else{
					usuario = insertDateValidation(usuario);
				}
				
				usuario.setDataDeNascimento(Util.stringToCalendar(usuario.getDataNasc()));
				usuario.setSenha(MD5.criptografar(usuario.getSenha()));
				usuario = usuarioService.insertUsuario(usuario);
				
				Util.setAttribute("userID", usuario.getId());
				
				Util.redirect("cadastrarTime.html");
				
			}catch (ParseException ep) { 
				ep.printStackTrace();
				EnviarMensagem.erro("Ocorreu um erro tente novamente mais tarde.", null, false);
			}catch (IOException io) {
				EnviarMensagem.erro("Ocorreu um erro tente novamente mais tarde.", null, false);
				io.printStackTrace();
			}catch (Exception e) {
				e.printStackTrace();
				EnviarMensagem.erro("Ocorreu um erro tente novamente mais tarde.", null, false);
			}
		}
		
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}
