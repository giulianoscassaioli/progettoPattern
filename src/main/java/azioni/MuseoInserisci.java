package azioni;

import java.io.IOException;

import business.GestioneMuseoEJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class MuseoInserisci implements Azioni {

	@Override
	public void esegui(HttpServletRequest request, HttpServletResponse response, GestioneMuseoEJB ej) throws Exception, IOException {
	    
		String nome=request.getParameter("nome");
    
	    String citta=request.getParameter("citta");
	    String messaggio=null;
	    try {
		    messaggio="Museo inserito correttamente!";
		    ej.insertMuseo(nome,citta);
			request.setAttribute("messaggio", messaggio);
			
			request.getServletContext().getRequestDispatcher("/WEB-INF/landing.jsp").forward(request, response);
		    }catch(Exception e) {
		    	
		    messaggio="Errore museo non inserito!";
		    request.setAttribute("messaggio", messaggio);
			request.getServletContext().getRequestDispatcher("/WEB-INF/errore.jsp").forward(request, response);
		    }
	    
		
       
	}

}
