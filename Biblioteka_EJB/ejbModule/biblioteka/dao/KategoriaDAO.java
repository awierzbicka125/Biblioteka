package biblioteka.dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import biblioteka_entities.Kategoria;

@Stateless
public class KategoriaDAO {
	
	@PersistenceContext
	EntityManager em;
	
	public void create(Kategoria kategoria) {
		em.persist(kategoria);
	}

	public Kategoria merge(Kategoria kategoria) {
		return em.merge(kategoria);
	}

	public void remove(Kategoria kategoria) {
		em.remove(em.merge(kategoria));
	}

	public Kategoria find(Object id) {
		return em.find(Kategoria.class, id);
	}
	}
