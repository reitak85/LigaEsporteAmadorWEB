package br.com.ligaesporteamador.util;


import java.util.ResourceBundle;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public class EnviarMensagem{

    private static ResourceBundle bundle;

    public EnviarMensagem(){ 	
    }

    private static void enviar(String idCompletoComponente, String msg, javax.faces.application.FacesMessage.Severity tipoMessage, boolean buscarBundle){
        
    	try{
            
    		String mensagem = "";
            
            if(buscarBundle){
                
            	bundle = ResourceBundle.getBundle("idioma", FacesContext.getCurrentInstance().getViewRoot().getLocale());
                mensagem = buscarBundle ? bundle.getString(msg) : msg;
                
            }else{
            	
                mensagem = msg;
            }
            
            FacesMessage fm = new FacesMessage(tipoMessage, mensagem, mensagem);
            FacesContext fc = FacesContext.getCurrentInstance();
            fc.addMessage(idCompletoComponente, fm);
        }
    	
        catch(Exception e){	
            e.printStackTrace();
        }
    }

    public static void erro(String msg, String idCompletoComponente, boolean buscarBundle){
    	
        enviar(idCompletoComponente, msg, FacesMessage.SEVERITY_ERROR, buscarBundle);
    }

    public static void informacao(String msg, String idCompletoComponente, boolean buscarBundle){
    	
        enviar(idCompletoComponente, msg, FacesMessage.SEVERITY_INFO, buscarBundle);
    }

    public static void atencao(String msg, String idCompletoComponente, boolean buscarBundle){
    	
        enviar(idCompletoComponente, msg, FacesMessage.SEVERITY_WARN, buscarBundle);
    }
}
