package biblioteka_entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the ksiazka database table.
 * 
 */
@Entity
@NamedQuery(name="Ksiazka.findAll", query="SELECT k FROM Ksiazka k")
public class Ksiazka implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int ID_ksiazka;

	private String autor;

	@Temporal(TemporalType.DATE)
	private Date rok_wydania;

	private String tytul;

	//bi-directional many-to-one association to Kategoria
	@ManyToOne
	@JoinColumn(name="ID_kategoria_ksiazk")
	private Kategoria kategoria;

	//bi-directional many-to-one association to Rezerwacja
	@OneToMany(mappedBy="ksiazka")
	private List<Rezerwacja> rezerwacjas;

	public Ksiazka() {
	}

	public int getID_ksiazka() {
		return this.ID_ksiazka;
	}

	public void setID_ksiazka(int ID_ksiazka) {
		this.ID_ksiazka = ID_ksiazka;
	}

	public String getAutor() {
		return this.autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public Date getRok_wydania() {
		return this.rok_wydania;
	}

	public void setRok_wydania(Date rok_wydania) {
		this.rok_wydania = rok_wydania;
	}

	public String getTytul() {
		return this.tytul;
	}

	public void setTytul(String tytul) {
		this.tytul = tytul;
	}

	public Kategoria getKategoria() {
		return this.kategoria;
	}

	public void setKategoria(Kategoria kategoria) {
		this.kategoria = kategoria;
	}

	public List<Rezerwacja> getRezerwacjas() {
		return this.rezerwacjas;
	}

	public void setRezerwacjas(List<Rezerwacja> rezerwacjas) {
		this.rezerwacjas = rezerwacjas;
	}

	public Rezerwacja addRezerwacja(Rezerwacja rezerwacja) {
		getRezerwacjas().add(rezerwacja);
		rezerwacja.setKsiazka(this);

		return rezerwacja;
	}

	public Rezerwacja removeRezerwacja(Rezerwacja rezerwacja) {
		getRezerwacjas().remove(rezerwacja);
		rezerwacja.setKsiazka(null);

		return rezerwacja;
	}

}