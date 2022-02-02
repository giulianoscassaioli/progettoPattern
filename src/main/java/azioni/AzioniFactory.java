package azioni;

public class AzioniFactory {
 
	//questo progetto implementa i patterns sia di tipo Singleton che di tipo FactoryMethod
	//utlizzo un istanza di questa classe privata e statica
	//private static AzioniFactory instance= new AzioniFactory();//----strategia Singleton eager
	private static AzioniFactory instance=null;//<-----strategia Singleton di tipo lazy
	//implemento il Singleton 
	//faccio il costruttore privato
	private AzioniFactory() {
		
	}
	
	//strategia Singleton di tipo lazy
	public static AzioniFactory getInstance() {
		if(instance==null) {
			instance=new AzioniFactory();
		}
		return instance;
	}


	public static void setInstance(AzioniFactory instance) {
		AzioniFactory.instance = instance;
	}

//implemento il singleton anche per le istanza delle classi che svolgno le azioni

	private MuseoCancella mc;
	
	private MuseoInserisci mi;
	
	private MuseoAggiorna ma;
	
	private MuseoVisualizzaFormDiModifica mv;
	
	private  MuseiMostraTutti mm;
	

	public Azioni create(String operazione) {

		switch (operazione) {
		case "/museo/cancella":

			// instanzio un classe senza assegnarla ad una variabile
			// utlizzo la stessa istanza per eseguire il metodo
			//new MuseoCancella().esegui(request, response, gm);// <---manca il MuseoCancella m= new...
			//return new MuseoCancella();
			
			//implemento il singleton 
			return getMc();
			//break;
			
		case "/museo/inserisci":

			//new MuseoInserisci().esegui(request, response, gm);

			//return new MuseoInserisci();
			//implemento il singleton 
			return getMi();

		case "/museo/aggiorna":

			//new MuseoAggiorna().esegui(request, response, gm);
			//return new MuseoAggiorna();
			//implemento il singleton 
			return getMa();
		case "/museo/edit":

			//new MuseoAggiorna().esegui(request, response, gm);
			//return new MuseoAggiorna();
			//implemento il singleton 
			return getMv();
			
		case "/museo/lista":

			//new MuseoAggiorna().esegui(request, response, gm);
			//return new MuseoAggiorna();
			//implemento il singleton 
			return getMm();

		/*case "/dipinti/cancella":
			dipintoCancella(request, response);
			return new MuseoCancella();

		case "/dipinti/aggiungi":
			dipintoAggiungi(request, response);
			return new MuseoCancella();

		case "/dipinti/aggiorna":
			dipintoAggiorna(request, response);
			return new MuseoCancella();*/

		}
		return null;

	}

	
	//per implementare il singleton instazio anche dei tipi di getter lazy
	public MuseoCancella getMc() {
		
		if(mc==null) {
			mc=new MuseoCancella();
		}
		return mc;
	}



	public MuseoInserisci getMi() {
		if(mi==null) {
			mi=new MuseoInserisci();
		}
		return mi;
	}

	

	public MuseoAggiorna getMa() {
		if(ma==null) {
			ma=new MuseoAggiorna();
		}
		return ma;
	}

	public MuseoVisualizzaFormDiModifica getMv() {
		if(mv==null) {
			mv=new MuseoVisualizzaFormDiModifica();
		}
		return mv;
	}

	

	public MuseiMostraTutti getMm() {
		if(mm==null) {
			mm=new MuseiMostraTutti();
		}
	
		return mm;
	}

	
	

	
	
	
}
