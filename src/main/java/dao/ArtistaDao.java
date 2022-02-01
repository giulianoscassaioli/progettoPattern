package dao;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import model.Artista;
import model.Museo;

public class ArtistaDao {

	private EntityManager em;

	public ArtistaDao(EntityManager em) {
		this.em = em;
	}

	public void insert(Artista a) {

		em.persist(a);

	}

	public void insert(String nome, String citta,String dataN) {

		
		Artista a = new Artista();
		a.setCognome(citta);
		a.setNome(nome);
		a.setDataN(dataN);

		insert(a);

	}

	public Artista retriveByPK(int id) {

		return em.find(Artista.class, id);

	}

	@SuppressWarnings("unchecked")
	public List<Artista> getAll() {

		Query q = em.createQuery("select a from Artista a");
		return q.getResultList();

	}

	public void update(Artista a ) {

		em.merge(a);

	}

	public void update(int id, String nome, String citta,String dataN) {

		
		Artista a = new Artista();
		a.setCognome(citta);
		a.setNome(nome);
		a.setDataN(dataN);

		insert(a);

		em.merge(a);

	}

	public void deleteByPK(int id) throws Exception {
		if (exist(id)) {
			em.remove(em.find(Artista.class, id));
		} else {
			throw new Exception("il museo non esiste");
		}

	}

	public boolean exist(int id) {

		if (em.find(Artista.class, id) == null)
			return false;
		else
			return true;

		// scrittura alternativa compatta
		// return em.find(Museo.class, id)!=null;

	}

}
