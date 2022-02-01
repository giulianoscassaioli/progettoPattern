package azioni;

import business.GestioneMuseoEJB;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public interface Azioni {
	
	public void esegui(HttpServletRequest request, HttpServletResponse response, GestioneMuseoEJB ej) throws Exception;

}
