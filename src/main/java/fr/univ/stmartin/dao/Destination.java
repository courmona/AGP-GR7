package fr.univ.stmartin.dao;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the destination database table.
 * 
 */
@Entity
@Table(name="destination")
@NamedQuery(name="Destination.findAll", query="SELECT d FROM Destination d")
public class Destination implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private int idDestination;

	@Column(nullable=false, length=50)
	private String nomDestination;

	//bi-directional many-to-one association to Voyage
	@OneToMany(mappedBy="destination")
	private List<Voyage> voyages;

	public Destination() {
	}

	public int getIdDestination() {
		return this.idDestination;
	}

	public void setIdDestination(int idDestination) {
		this.idDestination = idDestination;
	}

	public String getNomDestination() {
		return this.nomDestination;
	}

	public void setNomDestination(String nomDestination) {
		this.nomDestination = nomDestination;
	}

	public List<Voyage> getVoyages() {
		return this.voyages;
	}

	public void setVoyages(List<Voyage> voyages) {
		this.voyages = voyages;
	}

	public Voyage addVoyage(Voyage voyage) {
		getVoyages().add(voyage);
		voyage.setDestination(this);

		return voyage;
	}

	public Voyage removeVoyage(Voyage voyage) {
		getVoyages().remove(voyage);
		voyage.setDestination(null);

		return voyage;
	}

}