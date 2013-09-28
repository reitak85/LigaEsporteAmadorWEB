package br.com.ligaesporteamador.bo;

import java.util.Calendar;

import org.apache.commons.lang.StringUtils;

import br.com.ligaesporteamador.model.Usuario;
import br.com.ligaesporteamador.util.ValidaCPF;

public class UsuarioBO {

	public String validaPreenchimento(Usuario usuario) {

		String message = "";

		if (!usuario.isTermoContrato()) {

			message = "Para se Cadastrar é necessario aceitar o termo de contrato.";

		} else if (StringUtils.isBlank(usuario.getNome())) {

			message = "Por favor preencher o campo Nome !";

		} else if (StringUtils.isBlank(usuario.getSobreNome())) {

			message = "Por favor preencher o campo Sobre Nome !";

		} else if (StringUtils.isBlank(usuario.getDataNasc())) {

			message = "Por favor preencher o campo Data de Nascimento !";

		} else if (StringUtils.isBlank(usuario.getCpf())) {

			message = "Por favor preencher o campo CPF !";

		}else if(!ValidaCPF.isCPF(usuario.getCpf().replace(".", "").replace("-", ""))){ 
		
		}else if (StringUtils.isBlank(usuario.getSexo())) {

			message = "Por favor preencher o campo Sexo !";

		} else if (StringUtils.isBlank(usuario.getContato().getEmail())) {

			message = "Por favor preencher o campo E-mail !";

		} else if (usuario.isEnvioSms()
				&& StringUtils.isBlank(usuario.getContato()
						.getTelefoneCelular())) {

			message = "Por favor preencher o campo Telefone Celular !";

		} else if (StringUtils.isBlank(usuario.getContato()
				.getTelefoneCelular())
				&& StringUtils.isBlank(usuario.getContato()
						.getTelefoneResidencial())
				&& StringUtils.isBlank(usuario.getContato()
						.getTelefoneComercial())) {
			message = "Por favor preencher pelomenos um Telefone !";
		} else if (!usuario.getSenha().equals(usuario.getConfirmarSenha())) {
			message = "Os campos senha e confirmar senha n‹o conferem !";
		} else if (StringUtils.isEmpty(usuario.getSenha())) {
			message = "Por Favor preencher o campo senha !";
		}

		return message;
	}
	
	
	public Usuario insertDateValidation(Usuario usuario) throws Exception{
		usuario.setDataDeCriacao(Calendar.getInstance());
		return usuario;
	}
	
	public Usuario updateDateValidation(Usuario usuario) throws Exception{
		usuario.setDataDeAtualizacao(Calendar.getInstance());
		return usuario;
	}

}
