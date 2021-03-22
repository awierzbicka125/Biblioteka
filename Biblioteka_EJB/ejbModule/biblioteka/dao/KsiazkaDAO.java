package biblioteka.dao;


import java.util.List;
import java.util.Map;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;



import biblioteka_entities.Ksiazka;

@Stateless
public class KsiazkaDAO {
	
	@PersistenceContext
	EntityManager em;
	
	public void create(Ksiazka ksiazka) {
		em.persist(ksiazka);
	}

	public Ksiazka merge(Ksiazka ksiazka) {
		return em.merge(ksiazka);
	}

	public void remove(Ksiazka ksiazka) {
		em.remove(em.merge(ksiazka));
	}

	public Ksiazka find(Object id) {
		return em.find(Ksiazka.class, id);
	}
	
	public List<Ksiazka> getFullList() {
		List<Ksiazka> list = null;

		Query query = em.createQuery("select p from Ksiazka p");

		try {
			list = query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}

	public List<Ksiazka> getList(Map<String, Object> searchParams) {
		List<Ksiazka> list = null;

		// 1. Build query string with parameters
		String select = "select p ";
		String from = "from Ksiazka p ";
		String where = "";
		

		// search for surname
		String tytul = (String) searchParams.get("tytul");
		if (tytul != null) {
			if (where.isEmpty()) {
				where = "where ";
			} else {
				where += "and ";
			}
			where += "p.tytul like :tytul ";
		}
		
		// ... other parameters ... 

		// 2. Create query object
		Query query = em.createQuery(select + from + where);

		// 3. Set configured parameters
		if (tytul != null) {
			query.setParameter("tytul", tytul+"%");
		}

		// ... other parameters ... 

		// 4. Execute query and retrieve list of Person objects
		try {
			list = query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	}


