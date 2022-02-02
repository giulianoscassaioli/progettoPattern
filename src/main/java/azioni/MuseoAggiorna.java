package azioni;

import business.GestioneMuseoEJB;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class MuseoAggiorna implements Azioni{

	
	//per il principo del facade non devo usare oggetti nelle classi di azioni
	//ma devo usare i metodi creati nel session bean
	public void esegui(HttpServletRequest request, HttpServletResponse response, GestioneMuseoEJB ej) throws Exception {

		String nome=request.getParameter("nome");
        String id= request.getParameter("id");
	    String citta=request.getParameter("citta");
	    String messaggio=null;
	    
	    try {
	    messaggio="Museo aggiornato correttamente!";
		ej.saveMuseo(nome,id,citta);
		request.setAttribute("messaggio", messaggio);
		
		request.getServletContext().getRequestDispatcher("/WEB-INF/landing.jsp").forward(request, response);
	    }catch(Exception e) {
		
		request.getServletContext().getRequestDispatcher("/WEB-INF/errore.jsp").forward(request, response);
	    }
	 
	}

}
