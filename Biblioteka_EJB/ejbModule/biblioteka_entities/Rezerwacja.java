package biblioteka_entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the rezerwacja database table.
 * 
 */
@Entity
@NamedQuery(name="Rezerwacja.findAll", query="SELECT r FROM Rezerwacja r")
public class Rezerwacja implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int ID_rezerwacji;

	@Temporal(TemporalType.DATE)
	private Date data_Rezerwacji;

	//bi-directional many-to-one association to Uzytkownik
	@ManyToOne
	@JoinColumn(name="ID_uzytkownik_rezerwacja")
	private Uzytkownik uzytkownik;

	//bi-directional many-to-one association to Ksiazka
	@ManyToOne
	@JoinColumn(name="ID_ksiazka_rezerwacja")
	private Ksiazka ksiazka;

	public Rezerwacja() {
	}

	public int getID_rezerwacji() {
		return this.ID_rezerwacji;
	}

	public void setID_rezerwacji(int ID_rezerwacji) {
		this.ID_rezerwacji = ID_rezerwacji;
	}

	public Date getData_Rezerwacji() {
		return this.data_Rezerwacji;
	}

	public void setData_Rezerwacji(Date data_Rezerwacji) {
		this.data_Rezerwacji = data_Rezerwacji;
	}

	public Uzytkownik getUzytkownik() {
		return this.uzytkownik;
	}

	public void setUzytkownik(Uzytkownik uzytkownik) {
		this.uzytkownik = uzytkownik;
	}

	public Ksiazka getKsiazka() {
		return this.ksiazka;
	}

	public void setKsiazka(Ksiazka ksiazka) {
		this.ksiazka = ksiazka;
	}

}