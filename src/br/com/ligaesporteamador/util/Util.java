package br.com.ligaesporteamador.util;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.faces.context.FacesContext;

import org.primefaces.context.RequestContext;

public class Util {

	public static Calendar stringToCalendar(String data) throws ParseException {

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Calendar cal = Calendar.getInstance();
		cal.setTime(sdf.parse(data));

		return cal;
	}
	
	public static void redirect(String page) throws IOException{
		FacesContext.getCurrentInstance().getExternalContext().redirect(page);  
	}
	
	public static void openModal(String name) throws Exception {
		RequestContext context = RequestContext.getCurrentInstance();  
		context.execute(name + ".show();");
	}
	
	public static void closeModal(String name) throws Exception {
		RequestContext context = RequestContext.getCurrentInstance();  
		context.execute(name + ".hide();");
	}
	
	public static String getParameter(String name){
		String value = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get(name);
		return value;
	}
}
