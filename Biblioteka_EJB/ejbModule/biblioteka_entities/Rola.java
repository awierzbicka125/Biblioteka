package biblioteka_entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the rola database table.
 * 
 */
@Entity
@NamedQuery(name="Rola.findAll", query="SELECT r FROM Rola r")
public class Rola implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int ID_rola;

	private String nazwa_Roli;

	//bi-directional many-to-one association to Uzytkownik
	@OneToMany(mappedBy="rola")
	private List<Uzytkownik> uzytkowniks;

	public Rola() {
	}

	public int getID_rola() {
		return this.ID_rola;
	}

	public void setID_rola(int ID_rola) {
		this.ID_rola = ID_rola;
	}

	public String getNazwa_Roli() {
		return this.nazwa_Roli;
	}

	public void setNazwa_Roli(String nazwa_Roli) {
		this.nazwa_Roli = nazwa_Roli;
	}

	public List<Uzytkownik> getUzytkowniks() {
		return this.uzytkowniks;
	}

	public void setUzytkowniks(List<Uzytkownik> uzytkowniks) {
		this.uzytkowniks = uzytkowniks;
	}

	public Uzytkownik addUzytkownik(Uzytkownik uzytkownik) {
		getUzytkowniks().add(uzytkownik);
		uzytkownik.setRola(this);

		return uzytkownik;
	}

	public Uzytkownik removeUzytkownik(Uzytkownik uzytkownik) {
		getUzytkowniks().remove(uzytkownik);
		uzytkownik.setRola(null);

		return uzytkownik;
	}

}