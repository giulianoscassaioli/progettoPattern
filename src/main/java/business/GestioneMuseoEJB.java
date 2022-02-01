package business;

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

	
	
	
	/*public void saveMuseo(Museo m) {

		em.merge(m);

	}

	public void insertMuseo(Museo m) {

		em.persist(m);

	}

	public void removeMuseo(Museo m) {

		em.remove(em.merge(m));

	}*/

	public Museo getEntityById(int id) {

		return em.find(Museo.class, id);

	}

	public void removeMuseoById(String id) throws Exception {


		if (id == null) {
			throw new Exception("devi inserire un id museo");
		}

		if (id.isBlank()) {
			throw new Exception("devi inserire un id museo");
		}

		removeMuseoById(Integer.valueOf(id));

	}
	
	public void removeMuseoById(int id) throws Exception {

		Museo m = getEntityById((Integer.valueOf(id)));

		if (m == null) {

			throw new Exception("il museo non esiste");

		}

	}

	//getter di tipo lazy quindi setto i dao solo quando li chiamo dal getter
	public ArtistaDao getArtistadao() {
		if(artistadao==null) {
			artistadao=new ArtistaDao(em);
		}
		
		return artistadao;
	}

	public void setArtistadao(ArtistaDao artistadao) {
		
		this.artistadao = artistadao;
	}

	public MuseoDao getMuseodao() {
		if(museodao==null) {
			museodao=new MuseoDao(em);
		}
		return museodao;
	}

	public void setMuseodao(MuseoDao museodao) {
		this.museodao = museodao;
	}

}
