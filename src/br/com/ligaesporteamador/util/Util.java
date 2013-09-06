package br.com.ligaesporteamador.util;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Map;

import javax.faces.context.FacesContext;
import javax.net.ssl.HttpsURLConnection;
import javax.servlet.http.HttpServletRequest;

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
	
	public static String getParameter(String nome) throws Exception {
		HttpServletRequest request = (HttpServletRequest) FacesContext 
				.getCurrentInstance().getExternalContext().getRequest(); 

		return request.getParameter(nome); 
	}
	
	public static void sendPost(String url, Map<String, String> paramters) throws Exception {
		 
		URL obj = new URL(url);
		HttpsURLConnection con = (HttpsURLConnection) obj.openConnection();
 
		//add reuqest header
		con.setRequestMethod("POST");
		String urlParameters = "";
		
		
		for (Map.Entry<String, String> entry : paramters.entrySet()) {
			
			if(paramters.size() > 1){
				urlParameters=entry.getKey()+"="+entry.getValue()+"&";
			}else{
				urlParameters=entry.getKey()+"="+entry.getValue();
			}
		}
 
		// Send post request
		con.setDoOutput(true);
		DataOutputStream wr = new DataOutputStream(con.getOutputStream());
		wr.writeBytes(urlParameters);
		wr.flush();
		wr.close();
 
		int responseCode = con.getResponseCode();
		System.out.println("\nSending 'POST' request to URL : " + url);
		System.out.println("Post parameters : " + urlParameters);
		System.out.println("Response Code : " + responseCode);
 
		BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();
 
		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		
		in.close();
 
	}

}
