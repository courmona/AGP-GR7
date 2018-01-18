package fr.univ.stmartin.dao;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * The persistent class for the destination database table.
 * 
 */
@Entity
@Table(name = "destination")
@NamedQuery(name = "Destination.findAll", query = "SELECT d FROM Destination d")
public class Destination implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(unique = true, nullable = false)
	private int idDestination;

	@Column(nullable = false, length = 50)
	private String nomDestination;

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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idDestination;
		result = prime * result + ((nomDestination == null) ? 0 : nomDestination.hashCode());
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
		Destination other = (Destination) obj;
		if (idDestination != other.idDestination)
			return false;
		if (nomDestination == null) {
			if (other.nomDestination != null)
				return false;
		} else if (!nomDestination.equals(other.nomDestination))
			return false;
		return true;
	}

}