package br.com.ligaesporteamador.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean(name="galleriaController")
@RequestScoped
public class GalleriaController {
 
    private List<String> images;    
  
    @PostConstruct  
    public void init() {  
        images = new ArrayList<String>();  
  
        for(int i=1;i<=4;i++) {  
            images.add("consult"+i+".jpg");  
        }  

    }  
       
    public List<String> getImages() {  
        return images;  
    }  
    
}  
