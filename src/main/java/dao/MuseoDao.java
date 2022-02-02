package dao;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import model.Museo;

public class MuseoDao {

	private EntityManager em;

	public MuseoDao(EntityManager em) {
		this.em = em;
	}

	public void insert(Museo m) {

		em.persist(m);

	}

	public void insert(String nome, String citta) {

		Museo m = new Museo();

		m.setCitta(citta);
		m.setNome(nome);

		insert(m);

	}

	public Museo retriveByPK(int id) {

		return em.find(Museo.class, id);

	}

	@SuppressWarnings("unchecked")
	public List<Museo> getAll() {

		Query q = em.createQuery("select m from Museo m");
		return q.getResultList();

	}

	public void update(Museo m) {

		em.merge(m);

	}

	public void update(int id, String nome, String citta) {

		Museo m = new Museo();

		m.setCitta(citta);
		m.setNome(nome);
		m.setId(id);

		em.merge(m);

	}

	public void deleteByPK(int id) throws Exception {
		if (exists(id)) {
			em.remove(em.find(Museo.class, id));
		} else {
			throw new Exception("il museo non esiste");
		}

	}

	public boolean exists(int id) {

		if (em.find(Museo.class, id) == null)
			return false;
		else
			return true;

		// scrittura alternativa compatta
		// return em.find(Museo.class, id)!=null;

	}
	

}
