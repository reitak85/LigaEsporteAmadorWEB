package br.com.ligaesporteamador.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import br.com.ligaesporteamador.model.UsuarioSistema;
import br.com.ligaesporteamador.service.LoginService;
import br.com.ligaesporteamador.util.EnviarMensagem;
import br.com.ligaesporteamador.util.MD5;
import br.com.ligaesporteamador.util.Util;

@Controller("loginController")
@Scope("request")
public class LoginController {

	
	@Autowired
	private LoginService loginService;
	
	private UsuarioSistema userSistema;
	private UsuarioSistema user;

	public LoginController() {
		userSistema = new UsuarioSistema();
		user = new UsuarioSistema();
	}
	
	public void logar(){
		
		try {
			
			user = loginService.logar(userSistema);
			
			if (user.getEmail().equalsIgnoreCase(MD5.criptografar(userSistema.getEmail()))
					&& user.getSenha().equals(userSistema.getSenha())) {
				
				Util.redirect("welcome.html");
				
			}else{
				EnviarMensagem.erro("Usuario ou senha invalidos.", null, false);
			}
			
		} catch (Exception e) {
			EnviarMensagem.erro("Erro ao logar usuario.", null, false);
			e.printStackTrace();
		}
		
	}

	public UsuarioSistema getUserSistema() {
		return userSistema;
	}

	public void setUserSistema(UsuarioSistema userSistema) {
		this.userSistema = userSistema;
	}

}
