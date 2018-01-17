package fr.univ.stmartin.dao;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the hotel database table.
 * 
 */
@Entity
@Table(name="hotel")
@NamedQuery(name="Hotel.findAll", query="SELECT h FROM Hotel h")
public class Hotel implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private int idHotel;

	@Column(length=50)
	private String classement;

	@Column(length=50)
	private String nomHotel;

	private int prixNuit;

	@Column(length=50)
	private String villeHotel;

	//bi-directional many-to-one association to Voyage
	@OneToMany(mappedBy="hotel")
	private List<Voyage> voyages;

	public Hotel() {
	}

	public int getIdHotel() {
		return this.idHotel;
	}

	public void setIdHotel(int idHotel) {
		this.idHotel = idHotel;
	}

	public String getClassement() {
		return this.classement;
	}

	public void setClassement(String classement) {
		this.classement = classement;
	}

	public String getNomHotel() {
		return this.nomHotel;
	}

	public void setNomHotel(String nomHotel) {
		this.nomHotel = nomHotel;
	}

	public int getPrixNuit() {
		return this.prixNuit;
	}

	public void setPrixNuit(int prixNuit) {
		this.prixNuit = prixNuit;
	}

	public String getVilleHotel() {
		return this.villeHotel;
	}

	public void setVilleHotel(String villeHotel) {
		this.villeHotel = villeHotel;
	}

	public List<Voyage> getVoyages() {
		return this.voyages;
	}

	public void setVoyages(List<Voyage> voyages) {
		this.voyages = voyages;
	}

	public Voyage addVoyage(Voyage voyage) {
		getVoyages().add(voyage);
		voyage.setHotel(this);

		return voyage;
	}

	public Voyage removeVoyage(Voyage voyage) {
		getVoyages().remove(voyage);
		voyage.setHotel(null);

		return voyage;
	}

}