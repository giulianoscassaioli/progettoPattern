package azioni;

public class AzioniFactory {

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
