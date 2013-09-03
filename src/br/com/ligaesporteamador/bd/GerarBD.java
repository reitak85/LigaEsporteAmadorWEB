package br.com.ligaesporteamador.bd;


import org.hibernate.ejb.Ejb3Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

@Controller("gerarBD")
@Scope("request")
public class GerarBD{

	public void geraBanco() {

		try {
			recriaSchema();
		} catch (Exception e) {
			e.printStackTrace();
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
