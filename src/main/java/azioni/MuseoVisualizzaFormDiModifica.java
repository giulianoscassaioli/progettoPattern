package azioni;

import business.GestioneMuseoEJB;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Museo;

public class MuseoVisualizzaFormDiModifica implements Azioni {

	@Override
	public void esegui(HttpServletRequest request, HttpServletResponse response, GestioneMuseoEJB ej) throws Exception {
		
		String id = request.getParameter("id");
		
		try {
			Museo m =ej.getMuseoById(id);
			request.setAttribute("museo", m);
			request.getServletContext().getRequestDispatcher("/WEB-INF/editmuseo.jsp").forward(request, response);
			
			
		}catch(Exception e ) {
			
			
		}
		
		
		
		
	}
	
	
	

}
