package biblioteka_entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the uzytkownik database table.
 * 
 */
@Entity
@NamedQuery(name="Uzytkownik.findAll", query="SELECT u FROM Uzytkownik u")
public class Uzytkownik implements Serializable {
	private static final long serialVersionUID = 1L;
	
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer ID_uzytkownik;

	private String haslo;

	private String imie;

	private String login;

	@Lob
	private String mail;

	private String nazwisko;

	@Column(name="nr_telefonu")
	private int nrTelefonu;

	//bi-directional many-to-one association to Rezerwacja
	@OneToMany(mappedBy="uzytkownik")
	private List<Rezerwacja> rezerwacjas;

	//bi-directional many-to-one association to Rola
	@ManyToOne
	@JoinColumn(name="ID_rola_uzytkownik")
	private Rola rola;

	public Uzytkownik() {
	}

	public Integer getID_uzytkownik() {
		return this.ID_uzytkownik;
	}

	public void setID_uzytkownik(Integer ID_uzytkownik) {
		this.ID_uzytkownik = ID_uzytkownik;
	}

	public String getHaslo() {
		return this.haslo;
	}

	public void setHaslo(String haslo) {
		this.haslo = haslo;
	}

	public String getImie() {
		return this.imie;
	}

	public void setImie(String imie) {
		this.imie = imie;
	}

	public String getLogin() {
		return this.login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getMail() {
		return this.mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getNazwisko() {
		return this.nazwisko;
	}

	public void setNazwisko(String nazwisko) {
		this.nazwisko = nazwisko;
	}

	public int getNrTelefonu() {
		return this.nrTelefonu;
	}

	public void setNrTelefonu(int nrTelefonu) {
		this.nrTelefonu = nrTelefonu;
	}

	public List<Rezerwacja> getRezerwacjas() {
		return this.rezerwacjas;
	}

	public void setRezerwacjas(List<Rezerwacja> rezerwacjas) {
		this.rezerwacjas = rezerwacjas;
	}

	public Rezerwacja addRezerwacja(Rezerwacja rezerwacja) {
		getRezerwacjas().add(rezerwacja);
		rezerwacja.setUzytkownik(this);

		return rezerwacja;
	}

	public Rezerwacja removeRezerwacja(Rezerwacja rezerwacja) {
		getRezerwacjas().remove(rezerwacja);
		rezerwacja.setUzytkownik(null);

		return rezerwacja;
	}

	public Rola getRola() {
		return this.rola;
	}

	public void setRola(Rola rola) {
		this.rola = rola;
	}

}