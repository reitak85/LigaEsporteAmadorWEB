package br.com.ligaesporteamador.util;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

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

	public static void setAttribute(String name, Object value){
		FacesContext fc = FacesContext.getCurrentInstance();
		HttpSession session = (HttpSession) fc.getExternalContext().getSession(true);
		session.setAttribute(name, value);
	}

	public static String getAttribute(String name){
		String att ="";
		FacesContext fc = FacesContext.getCurrentInstance();
		HttpSession session = (HttpSession) fc.getExternalContext().getSession(true);
		att = session.getAttribute(name).toString();
		
		return att;
	}
	
	public static void removeAttribute(String name){
		FacesContext fc = FacesContext.getCurrentInstance();
		HttpSession session = (HttpSession) fc.getExternalContext().getSession(true);
		session.removeAttribute(name);
	}
	
	public static String getParam(String value){
		
		return FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get(value);
	}

}
