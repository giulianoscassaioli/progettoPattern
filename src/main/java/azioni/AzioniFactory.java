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





	public Azioni create(String operazione) {

		switch (operazione) {
		case "/museo/cancella":

			// instanzio un classe senza assegnarla ad una variabile
			// utlizzo la stessa istanza per eseguire il metodo
			//new MuseoCancella().esegui(request, response, gm);// <---manca il MuseoCancella m= new...
			return new MuseoCancella();
			//break;
		case "/museo/inserisci":

			//new MuseoInserisci().esegui(request, response, gm);

			return new MuseoInserisci();

		case "/museo/aggiorna":

			//new MuseoAggiorna().esegui(request, response, gm);
			return new MuseoAggiorna();

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
}
