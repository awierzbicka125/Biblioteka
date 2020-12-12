package biblioteka_entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the kategoria database table.
 * 
 */
@Entity
@NamedQuery(name="Kategoria.findAll", query="SELECT k FROM Kategoria k")
public class Kategoria implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int ID_Kategoria;

	private int ilosc_ksiazek;

	private String nazwa_Kategorii;

	//bi-directional many-to-one association to Ksiazka
	@OneToMany(mappedBy="kategoria")
	private List<Ksiazka> ksiazkas;

	public Kategoria() {
	}

	public int getID_Kategoria() {
		return this.ID_Kategoria;
	}

	public void setID_Kategoria(int ID_Kategoria) {
		this.ID_Kategoria = ID_Kategoria;
	}

	public int getIlosc_ksiazek() {
		return this.ilosc_ksiazek;
	}

	public void setIlosc_ksiazek(int ilosc_ksiazek) {
		this.ilosc_ksiazek = ilosc_ksiazek;
	}

	public String getNazwa_Kategorii() {
		return this.nazwa_Kategorii;
	}

	public void setNazwa_Kategorii(String nazwa_Kategorii) {
		this.nazwa_Kategorii = nazwa_Kategorii;
	}

	public List<Ksiazka> getKsiazkas() {
		return this.ksiazkas;
	}

	public void setKsiazkas(List<Ksiazka> ksiazkas) {
		this.ksiazkas = ksiazkas;
	}

	public Ksiazka addKsiazka(Ksiazka ksiazka) {
		getKsiazkas().add(ksiazka);
		ksiazka.setKategoria(this);

		return ksiazka;
	}

	public Ksiazka removeKsiazka(Ksiazka ksiazka) {
		getKsiazkas().remove(ksiazka);
		ksiazka.setKategoria(null);

		return ksiazka;
	}

}