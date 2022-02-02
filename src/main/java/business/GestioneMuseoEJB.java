package business;

import java.util.List;

import org.postgresql.xml.NullErrorHandler;

import dao.ArtistaDao;
import dao.MuseoDao;
import jakarta.ejb.LocalBean;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import model.Museo;

/**
 * Session Bean implementation class GestioneMuseoEJB
 */
@Stateless
@LocalBean

//L'EJB è una rappresentazione del pattern FACADE perche implementa delle funzioni
//che vengono chiamate sempre allo stesso modo dal'esterno
//anche se cambio qualcosa al interno dei metodi del EJB dal esterno non si nota
public class GestioneMuseoEJB implements GestioneMuseoEJBLocal {

	@PersistenceContext(unitName = "calcioPS")
	EntityManager em;

	private ArtistaDao artistadao;
	private MuseoDao museodao;

	public GestioneMuseoEJB() {
		// TODO Auto-generated constructor stub
	}

	public EntityManager getEntityManager() {

		return em;
	}

	public void saveMuseo(Museo m) throws Exception {
		
		if (m.getCitta() == null || m.getNome() == null) {

			throw new Exception("devi inserire per forza una citta e un nome del museo");
		}
		
		saveMuseo(m.getNome(),String.valueOf(m.getId()),m.getCitta());

	}
	
	                                  //un int non puo essere null
	                                  //quindi utlizzo la classe Wrapper
	//public void saveMuseo(String nome,Integer id,String citta)
	public void saveMuseo(String nome,String id,String citta) throws Exception {
		if (nome.isBlank() || id == null || citta.isBlank() ) {

			throw new Exception("devi inserire per forza una citta e un nome del museo");
		}
		
		Museo m= new Museo();
		m.setCitta(citta);
		m.setId(Integer.valueOf(id));
		m.setNome(nome);
		
		getMuseodao().update(m);
		
		
	}

	public void insertMuseo(Museo m) throws Exception {

	
		insertMuseo(m.getNome(),m.getCitta());

	}
	
	public void insertMuseo(String nome,String citta) throws Exception {
		if (nome == null || citta == null) {

			throw new Exception("devi inserire per forza una citta e un nome del museo");
		}
		if (citta.isBlank() || nome.isBlank()) {

			throw new Exception("devi inserire per forza una citta e un nome del museo");
		}
		
		Museo m = new Museo();
		m.setCitta(citta);
	
		m.setNome(nome);
		
		getMuseodao().insert(m);
	}
	
	
	public void removeMuseo(int id) throws Exception {
		
		getMuseodao().deleteByPK(id);
		
		
	}
	
	
	public void removeMuseo(String id) throws Exception {
		
		if(id==null) {
			
			throw new Exception("il parametro id non presente nella form");
		}
		
		if(id.isBlank()) {
			throw new Exception("non hai inserito l'id");
		}
		
		removeMuseo(id);
		
	}
	
	public void removeMuseo(Museo m) throws Exception {
		
		removeMuseo(m.getId());
	}
	
	
	public List<Museo> getAllMusei(){
		
		return getMuseodao().getAll();
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	

	/*public void removeMuseo(Museo m) throws Exception {
		
		getMuseodao().deleteByPK(m.getId());


	}


	public void removeMuseo(String id) throws Exception {

		if (id == null) {
			throw new Exception("devi inserire un id museo");
		}

		if (id.isBlank()) {
			throw new Exception("devi inserire un id museo");
		}

		removeMuseo(Integer.valueOf(id));

	}

	public void removeMuseo(int id) throws Exception {

		getMuseodao().deleteByPK(id);
	}*/
	
	
	//la depreco perche in questo esercizio usiamo il pattern Dao quindi tutti i metodi vanno
	//richiamati tramiti il dao
	@Deprecated
	public Museo getEntityById(int id) {

		return em.find(Museo.class, id);

	}
	
	public Museo getMuseoById(int id) {

		return getMuseodao().retriveByPK(id);

	}
	
	public Museo getMuseoById(String id) throws Exception {

		
		if(id==null || id.isBlank()) {
			
			throw new Exception("Manca id museo");
		}
		
		return getMuseoById(Integer.valueOf(id));

	}
	

	// getter di tipo lazy quindi setto i dao solo quando li chiamo dal getter
	public ArtistaDao getArtistadao() {
		if (artistadao == null) {
			artistadao = new ArtistaDao(em);
		}

		return artistadao;
	}

	public void setArtistadao(ArtistaDao artistadao) {

		this.artistadao = artistadao;
	}

	public MuseoDao getMuseodao() {
		if (museodao == null) {
			museodao = new MuseoDao(em);
		}
		return museodao;
	}

	public void setMuseodao(MuseoDao museodao) {
		this.museodao = museodao;
	}

}
