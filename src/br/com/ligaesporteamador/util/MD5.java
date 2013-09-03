package br.com.ligaesporteamador.util;


import org.springframework.security.authentication.encoding.Md5PasswordEncoder;

public class MD5 {

	public static String criptografar(String texto){
		
        Md5PasswordEncoder md = new Md5PasswordEncoder();
        texto = md.encodePassword(texto, null); 
        
        return texto; 
    }

}
