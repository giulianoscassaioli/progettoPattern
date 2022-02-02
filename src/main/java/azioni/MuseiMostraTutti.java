package azioni;

import java.util.List;

import business.GestioneMuseoEJB;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Museo;

public class MuseiMostraTutti implements Azioni{
	
	
	public void esegui(HttpServletRequest request, HttpServletResponse response, GestioneMuseoEJB ej) throws Exception {

	    try {
	    
	    List <Museo> musei=ej.getAllMusei();
		request.setAttribute("lista", musei); 
		request.getServletContext().getRequestDispatcher("/WEB-INF/viewmusei.jsp").forward(request, response);
	    }catch(Exception e) {
		
		request.getServletContext().getRequestDispatcher("/WEB-INF/errore.jsp").forward(request, response);
	    }
	}
}
