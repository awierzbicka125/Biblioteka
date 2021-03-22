package biblioteka.dao;

import java.util.List;
import java.util.Map;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;


import biblioteka_entities.Rezerwacja;

@Stateless
public class RezerwacjaDAO {
	
	@PersistenceContext
	EntityManager em;
	
	public void create(Rezerwacja rezerwacja) {
		em.persist(rezerwacja);
	}

	public Rezerwacja merge(Rezerwacja rezerwacja) {
		return em.merge(rezerwacja);
	}

	public void remove(Rezerwacja rezerwacja) {
		em.remove(em.merge(rezerwacja));
	}

	public Rezerwacja find(Object id) {
		return em.find(Rezerwacja.class, id);
	}
	

public List<Rezerwacja> getFullList() {
	List<Rezerwacja> list = null;

	Query query = em.createQuery("select p from Person p");

	try {
		list = query.getResultList();
	} catch (Exception e) {
		e.printStackTrace();
	}

	return list;
}

public List<Rezerwacja> getList(Map<String, Object> searchParams) {
	List<Rezerwacja> list = null;
	//TODO complicated database search
	
	// 1. Build query string with parameters
	String select = "select p ";
	String from = "from Rezerwacja p ";
	String where = "";
	String orderby = "order by p.surname asc, p.name";

	// search for surname
	String surname = (String) searchParams.get("surname");
	if (surname != null) {
		if (where.isEmpty()) {
			where = "where ";
		} else {
			where += "and ";
		}
		where += "p.surname like :surname ";
	}
	
	// ... other parameters ... 

	// 2. Create query object
	Query query = em.createQuery(select + from + where + orderby);

	// 3. Set configured parameters
	if (surname != null) {
		query.setParameter("surname", surname+"%");
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