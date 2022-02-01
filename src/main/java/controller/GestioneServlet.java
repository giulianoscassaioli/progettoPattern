package controller;

import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Museo;

import java.io.IOException;

import azioni.Azioni;
import azioni.AzioniFactory;
import azioni.MuseoAggiorna;
import azioni.MuseoCancella;
import azioni.MuseoInserisci;
import business.GestioneMuseoEJB;



/**
 * Servlet implementation class GestioneServlet
 */
@WebServlet("/gestione/*")
public class GestioneServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GestioneServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	
	@EJB
	GestioneMuseoEJB gm;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String operazione= request.getPathInfo(); //recupera l'azione che noi volgiamo eseguire nel formato /entity/azione
		
		                                           //ad esempio per cancellare un museo sara /museo/cancella
												  //esempio di invocazione della servelt
		                                          // /gestione/museo/cancella

		//siccome ho fatto la classe AzioneFactory nella quale ho implementato lo switch sotto
		//li dentro allora posso procedere cosi
		
		new AzioniFactory().create(operazione).esegui(request, response, gm);
		// siccome AzioniFactory resituisce un oggetto di tipo azioni posso richiamre il metodo esegui su di esso
		//scritto in maniera meno compatta serebbe questo
		/*AzioniFactory factory=new AzioniFactory();//<----------
		Azioni azioneCorrente= factory.create(operazione);
		azioneCorrente.esegui(request, response, gm);*/
		
		
		
		
		
		/*try {							//<----sposto tutto questo blocca nella classe AzioniFactory 
		switch (operazione) {
		
		 
		       case "/museo/cancella":
		    	   
		    	   //instanzio un classe senza assegnarla ad una variabile
		    	   //utlizzo la stessa istanza per eseguire il metodo
		    	   new MuseoCancella().esegui(request, response, gm);//<---manca il MuseoCancella m= new...
		    	   
			      break;
		       case "/museo/inserisci":
		    	   
		    	   
		    	   new MuseoInserisci().esegui(request, response, gm);
		    	 
			
					break;
		       
		       case "/museo/aggiorna":
		    	   
		    	   new MuseoAggiorna().esegui(request, response, gm);
					break;
		      
		       case "/dipinti/cancella":
		    	   dipintoCancella(request, response);
					break;
		      
		       case "/dipinti/aggiungi":
		    	   dipintoAggiungi(request, response);
					break;
		      
		       case "/dipinti/aggiorna":
		    	   dipintoAggiorna(request, response);
					break;
					
		   }*/
		

		
		
		
		
		}
		
		
	
	

     
     private boolean museoAggiungi(HttpServletRequest request, HttpServletResponse response) throws Exception {
 		String nome=request.getParameter("nome");
 		String citta=request.getParameter("citta");
 		
 		
 		//isblanck è uguale a  equals("") e  equals(" ") <---se vengono inseriti spazi
 		if( nome.isBlank()) {
 			throw new Exception("il nome del museo è obbligatorio");
 			
 		}
 		
 		if( citta.isBlank()) {
 			throw new Exception("il nome della citta è obbligatorio");
 			
 		}
 		
 		Museo m = new Museo();
 		gm.getEntityManager().persist(m);
 		
 		
    	 
 		return false;
 	}
     
     private boolean dipintoCancella(HttpServletRequest request, HttpServletResponse response) {
 		
 		return false;
 	}
 	
      private boolean dipintoAggiorna(HttpServletRequest request, HttpServletResponse response) {
 		
 		return false;
 	}
      
      private boolean dipintoAggiungi(HttpServletRequest request, HttpServletResponse response) {
  		
  		return false;
  	}
    
   
}
