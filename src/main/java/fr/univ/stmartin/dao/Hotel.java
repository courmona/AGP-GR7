package fr.univ.stmartin.dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * The persistent class for the hotel database table.
 * 
 */
@Entity
@Table(name = "hotel")
@NamedQuery(name = "Hotel.findAll", query = "SELECT h FROM Hotel h")
public class Hotel implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(unique = true, nullable = false)
	private int idHotel;

	@Column(length = 50)
	private String classement;

	@Column(length = 50)
	private String nomHotel;

	private int prixNuit;

	@Column(length = 50)
	private String villeHotel;

	// bi-directional many-to-many association to Activite
	@ManyToMany
	@JoinTable(name = "hotelactivites", joinColumns = {
			@JoinColumn(name = "idHotel", nullable = false) }, inverseJoinColumns = {
					@JoinColumn(name = "idActivites", nullable = false) })
	private List<Activite> activites;

	@Transient
	private int prixTransportSiteTotal;

	@Transient
	private List<Site> listSiteAVisite;
	
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

	public List<Activite> getActivites() {
		return this.activites;
	}

	public void setActivites(List<Activite> activites) {
		this.activites = activites;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((activites == null) ? 0 : activites.hashCode());
		result = prime * result + ((classement == null) ? 0 : classement.hashCode());
		result = prime * result + idHotel;
		result = prime * result + ((nomHotel == null) ? 0 : nomHotel.hashCode());
		result = prime * result + prixNuit;
		result = prime * result + ((villeHotel == null) ? 0 : villeHotel.hashCode());
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
		Hotel other = (Hotel) obj;
		if (activites == null) {
			if (other.activites != null)
				return false;
		} else if (!activites.equals(other.activites))
			return false;
		if (classement == null) {
			if (other.classement != null)
				return false;
		} else if (!classement.equals(other.classement))
			return false;
		if (idHotel != other.idHotel)
			return false;
		if (nomHotel == null) {
			if (other.nomHotel != null)
				return false;
		} else if (!nomHotel.equals(other.nomHotel))
			return false;
		if (prixNuit != other.prixNuit)
			return false;
		if (villeHotel == null) {
			if (other.villeHotel != null)
				return false;
		} else if (!villeHotel.equals(other.villeHotel))
			return false;
		return true;
	}

	public int getPrixTransportSiteTotal() {
		return prixTransportSiteTotal;
	}

	public void setPrixTransportSiteTotal(int prixTransportSiteTotal) {
		this.prixTransportSiteTotal = prixTransportSiteTotal;
	}

	public List<Site> getListSiteAVisite() {
		return listSiteAVisite;
	}

	public void setListSiteAVisite(List<Site> listSiteAVisite) {
		this.listSiteAVisite = listSiteAVisite;
	}

}