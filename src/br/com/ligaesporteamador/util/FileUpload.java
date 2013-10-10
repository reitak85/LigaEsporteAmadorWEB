package br.com.ligaesporteamador.util;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.Locale;


public class FileUpload {
	
	
	@SuppressWarnings("deprecation")
	public static void createDir(String esporte, String categoria, String extensao, String nameArquivo) throws IOException{
		
		Calendar c = Calendar.getInstance(new Locale("pt", "BR"));
		int dia = c.get(Calendar.DATE);  
        int mes = c.get(Calendar.MONTH) + 1;  
        int ano = c.get(Calendar.YEAR);
       
		String path = "C:/ligaesporteamador/noticia/";
		
		path = path.concat(categoria).concat("/");
		path = path.concat(esporte).concat("/");
		path = path.concat(String.valueOf(ano)).concat("/");
		path = path.concat(String.valueOf(mes)).concat("/");
		path = path.concat(String.valueOf(dia)).concat("/");
		
		File file = new File(path);
		
		if(!file.exists()){
			file.mkdirs();
		}
		
		
		nameArquivo =  nameArquivo.concat(String.valueOf(c.getTime().getHours()));
		nameArquivo =  nameArquivo.concat(String.valueOf(c.getTime().getMinutes()));
		nameArquivo =  nameArquivo.concat(String.valueOf(c.getTime().getSeconds()));
		
		File arquivo = new File(file.getAbsolutePath().concat("/"+nameArquivo.concat(extensao)));
		
		if(arquivo.exists()){
			arquivo.delete();
			arquivo.createNewFile();
		}else{
			arquivo.createNewFile();
		}
		
	}

}
