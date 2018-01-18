package fr.univ.stmartin.dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * The persistent class for the activites database table.
 * 
 */
@Entity
@Table(name = "activites")
@NamedQuery(name = "Activite.findAll", query = "SELECT a FROM Activite a")
public class Activite implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(unique = true, nullable = false)
	private int idActivites;

	@Column(nullable = false, length = 50)
	private String nomActivites;

	@Column(nullable = false)
	private int prixActivites;

	// bi-directional many-to-many association to Hotel
	@ManyToMany(mappedBy = "activites")
	private List<Hotel> hotels;

	public Activite() {
	}

	public int getIdActivites() {
		return this.idActivites;
	}

	public void setIdActivites(int idActivites) {
		this.idActivites = idActivites;
	}

	public String getNomActivites() {
		return this.nomActivites;
	}

	public void setNomActivites(String nomActivites) {
		this.nomActivites = nomActivites;
	}

	public int getPrixActivites() {
		return this.prixActivites;
	}

	public void setPrixActivites(int prixActivites) {
		this.prixActivites = prixActivites;
	}

	public List<Hotel> getHotels() {
		return this.hotels;
	}

	public void setHotels(List<Hotel> hotels) {
		this.hotels = hotels;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((hotels == null) ? 0 : hotels.hashCode());
		result = prime * result + idActivites;
		result = prime * result + ((nomActivites == null) ? 0 : nomActivites.hashCode());
		result = prime * result + prixActivites;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Activite other = (Activite) obj;
		if (hotels == null) {
			if (other.hotels != null)
				return false;
		} else if (!hotels.equals(other.hotels))
			return false;
		if (idActivites != other.idActivites)
			return false;
		if (nomActivites == null) {
			if (other.nomActivites != null)
				return false;
		} else if (!nomActivites.equals(other.nomActivites))
			return false;
		if (prixActivites != other.prixActivites)
			return false;
		return true;
	}

}