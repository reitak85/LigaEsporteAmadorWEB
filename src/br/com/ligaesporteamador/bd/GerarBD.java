package br.com.ligaesporteamador.bd;


import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.hibernate.ejb.Ejb3Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import br.com.ligaesporteamador.model.BaseEntity;
import br.com.ligaesporteamador.model.CategoriaEsporte;
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
			List<String> listDefault = new ArrayList<String>();
			listDefault.add("Nenhum");
			listDefault.add("Masculino");
			listDefault.add("Feminino");
			List<String> listCatFut = new ArrayList<String>();
			listCatFut.add("Nenhum");
			listCatFut.add("Sub 09");
			listCatFut.add("Sub 11");
			listCatFut.add("Sub 13");
			listCatFut.add("Sub 15");
			listCatFut.add("Sub 17");
			createEsporte("Futebol", "Futebol", listCatFut);
			createEsporte("Basquete", "Basquete", listDefault);
			createEsporte("Tênis", "Tenis", listDefault);
			createEsporte("Vôlei", "Vôlei", listDefault);
			createEsporte("Handbol", "Handbol", listDefault);
			createEsporte("Rugby", "Rugby", listDefault);
			
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
	
	public void createEsporte(String esportee, String desc, List<String> categorias) throws Exception{
		Esporte esporte = new Esporte();
		esporte.setNome(esportee);
		esporte.setDescricao(desc);
		create(esporte);
		List<Esporte> listEsportes = (List)createQuery("SELECT e FROM Esporte e where e.nome='"+esportee+"'");
		esporte = listEsportes.isEmpty() ? null : listEsportes.get(0);
		System.out.println(esporte);
		for (String categoria : categorias) {
			CategoriaEsporte c = new CategoriaEsporte();
			c.setEsporte(esporte);
			c.setNome(categoria);
			c.setDescricao(categoria);
			create(c);
		}
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
