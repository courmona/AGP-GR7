package fr.univ.stmartin.dao;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * The persistent class for the site database table.
 * 
 */
@Entity
@Table(name = "site")
@NamedQuery(name = "Site.findAll", query = "SELECT s FROM Site s")
public class Site implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(unique = true, nullable = false)
	private int idSite;

	@Column(nullable = false, length = 50)
	private String nomSite;

	@Column(nullable = false, length = 50)
	private String villeSite;

	// bi-directional many-to-one association to Transport
	@ManyToOne
	@JoinColumn(name = "idTransport")
	private Transport transport;

	public Site() {
	}

	public int getIdSite() {
		return this.idSite;
	}

	public void setIdSite(int idSite) {
		this.idSite = idSite;
	}

	public String getNomSite() {
		return this.nomSite;
	}

	public void setNomSite(String nomSite) {
		this.nomSite = nomSite;
	}

	public String getVilleSite() {
		return this.villeSite;
	}

	public void setVilleSite(String villeSite) {
		this.villeSite = villeSite;
	}

	public Transport getTransport() {
		return this.transport;
	}

	public void setTransport(Transport transport) {
		this.transport = transport;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idSite;
		result = prime * result + ((nomSite == null) ? 0 : nomSite.hashCode());
		result = prime * result + ((transport == null) ? 0 : transport.hashCode());
		result = prime * result + ((villeSite == null) ? 0 : villeSite.hashCode());
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
		Site other = (Site) obj;
		if (idSite != other.idSite)
			return false;
		if (nomSite == null) {
			if (other.nomSite != null)
				return false;
		} else if (!nomSite.equals(other.nomSite))
			return false;
		if (transport == null) {
			if (other.transport != null)
				return false;
		} else if (!transport.equals(other.transport))
			return false;
		if (villeSite == null) {
			if (other.villeSite != null)
				return false;
		} else if (!villeSite.equals(other.villeSite))
			return false;
		return true;
	}

}