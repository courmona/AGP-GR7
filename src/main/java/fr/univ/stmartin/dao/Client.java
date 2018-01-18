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
 * The persistent class for the client database table.
 * 
 */
@Entity
@Table(name = "client")
@NamedQuery(name = "Client.findAll", query = "SELECT c FROM Client c")
public class Client implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(unique = true, nullable = false)
	private int idClient;

	@Column(length = 50)
	private String budget;

	@Column(length = 50)
	private String confort;

	@Column(nullable = false)
	private int nbJourSejour;

	@Column(length = 50)
	private String nomClient;

	@Column(length = 50)
	private String varThematique;

	public Client() {
	}

	public int getIdClient() {
		return this.idClient;
	}

	public void setIdClient(int idClient) {
		this.idClient = idClient;
	}

	public String getBudget() {
		return this.budget;
	}

	public void setBudget(String budget) {
		this.budget = budget;
	}

	public String getConfort() {
		return this.confort;
	}

	public void setConfort(String confort) {
		this.confort = confort;
	}

	public int getNbJourSejour() {
		return this.nbJourSejour;
	}

	public void setNbJourSejour(int nbJourSejour) {
		this.nbJourSejour = nbJourSejour;
	}

	public String getNomClient() {
		return this.nomClient;
	}

	public void setNomClient(String nomClient) {
		this.nomClient = nomClient;
	}

	public String getVarThematique() {
		return this.varThematique;
	}

	public void setVarThematique(String varThematique) {
		this.varThematique = varThematique;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((budget == null) ? 0 : budget.hashCode());
		result = prime * result + ((confort == null) ? 0 : confort.hashCode());
		result = prime * result + idClient;
		result = prime * result + nbJourSejour;
		result = prime * result + ((nomClient == null) ? 0 : nomClient.hashCode());
		result = prime * result + ((varThematique == null) ? 0 : varThematique.hashCode());
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
		Client other = (Client) obj;
		if (budget == null) {
			if (other.budget != null)
				return false;
		} else if (!budget.equals(other.budget))
			return false;
		if (confort == null) {
			if (other.confort != null)
				return false;
		} else if (!confort.equals(other.confort))
			return false;
		if (idClient != other.idClient)
			return false;
		if (nbJourSejour != other.nbJourSejour)
			return false;
		if (nomClient == null) {
			if (other.nomClient != null)
				return false;
		} else if (!nomClient.equals(other.nomClient))
			return false;
		if (varThematique == null) {
			if (other.varThematique != null)
				return false;
		} else if (!varThematique.equals(other.varThematique))
			return false;
		return true;
	}

}