package azioni;

import business.GestioneMuseoEJB;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


public class MuseoCancella implements Azioni{
	
	
     public void esegui(HttpServletRequest request, HttpServletResponse response,GestioneMuseoEJB ej) throws Exception {
	 
    	 //utlizzando il dao
    	 //ej.getMuseodao().deleteByPK(Integer.valueOf(request.getParameter("id")));
    	 //modo alternativo se non utlizzo il pattern dao
        // ej.removeMuseoById(request.getParameter("id"));
    	 
    	 //utlizzando il metodo del pattern facade 
    	 //che ho implementato nel ejb
    	 ej.removeMuseo(request.getParameter("id"));
    	 
    	
    	
    }
	
	

}
