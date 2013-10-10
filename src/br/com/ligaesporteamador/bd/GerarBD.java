package br.com.ligaesporteamador.bd;


import java.util.Calendar;

import org.hibernate.ejb.Ejb3Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import br.com.ligaesporteamador.model.BaseEntity;
import br.com.ligaesporteamador.model.Esporte;
import br.com.ligaesporteamador.model.UsuarioSistema;
import br.com.ligaesporteamador.util.MD5;

@Controller("gerarBD")
@Scope("request")
public class GerarBD extends DataAccessService<BaseEntity>{

	private UsuarioSistema usuarioSistema;
	

	public void geraBanco() {
		
		usuarioSistema = new UsuarioSistema();
		
		try {
			
			recriaSchema();
			createUser();
			//createEsporte("Futebol", "Futebol");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void createUser() throws Exception{
		
		usuarioSistema.setNome("Admin");
		usuarioSistema.setEmail("admin@admin.com.br");
		usuarioSistema.setDataDeCriacao(Calendar.getInstance());
		usuarioSistema.setSenha(MD5.criptografar("123Admin"));
		
		create(usuarioSistema);
	}
	
	public void createEsporte(String esportee, String desc) throws Exception{
		Esporte esporte = new Esporte();
		esporte.setNome(esportee);
		esporte.setDescricao(desc);
		create(esporte);
	}

	public void recriaSchema() throws Exception {

		System.out.println("Recriando Schema...");
		Ejb3Configuration cfg = new Ejb3Configuration();
		cfg.configure("ligaesporteamador", null);
		org.hibernate.cfg.Configuration hbmcfg = cfg
				.getHibernateConfiguration();
		SchemaExport schemaExport = new SchemaExport(hbmcfg);

		System.out.println((new StringBuilder("schemaExport = ")).append(
				schemaExport.getClass()).toString());
		schemaExport.create(true, true);
		System.out.println("Recriado!!!");
	}

	public static void main(String[] args) {
		new GerarBD().geraBanco();
	}

}
