package fr.univ.stmartin.dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * The persistent class for the transport database table.
 * 
 */
@Entity
@Table(name = "transport")
@NamedQuery(name = "Transport.findAll", query = "SELECT t FROM Transport t")
public class Transport implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(unique = true, nullable = false)
	private int idTransport;

	@Column(length = 50)
	private String moyenDeTransport;

	@Column(nullable = false)
	private int prixTransport;

	// bi-directional many-to-one association to Site
	@OneToMany(mappedBy = "transport")
	private List<Site> sites;

	public Transport() {
	}

	public int getIdTransport() {
		return this.idTransport;
	}

	public void setIdTransport(int idTransport) {
		this.idTransport = idTransport;
	}

	public String getMoyenDeTransport() {
		return this.moyenDeTransport;
	}

	public void setMoyenDeTransport(String moyenDeTransport) {
		this.moyenDeTransport = moyenDeTransport;
	}

	public int getPrixTransport() {
		return this.prixTransport;
	}

	public void setPrixTransport(int prixTransport) {
		this.prixTransport = prixTransport;
	}

	public List<Site> getSites() {
		return this.sites;
	}

	public void setSites(List<Site> sites) {
		this.sites = sites;
	}

	public Site addSite(Site site) {
		getSites().add(site);
		site.setTransport(this);

		return site;
	}

	public Site removeSite(Site site) {
		getSites().remove(site);
		site.setTransport(null);

		return site;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idTransport;
		result = prime * result + ((moyenDeTransport == null) ? 0 : moyenDeTransport.hashCode());
		result = prime * result + prixTransport;
		result = prime * result + ((sites == null) ? 0 : sites.hashCode());
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
		Transport other = (Transport) obj;
		if (idTransport != other.idTransport)
			return false;
		if (moyenDeTransport == null) {
			if (other.moyenDeTransport != null)
				return false;
		} else if (!moyenDeTransport.equals(other.moyenDeTransport))
			return false;
		if (prixTransport != other.prixTransport)
			return false;
		if (sites == null) {
			if (other.sites != null)
				return false;
		} else if (!sites.equals(other.sites))
			return false;
		return true;
	}

}