package fr.univ.stmartin.dao;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the client database table.
 * 
 */
@Entity
@Table(name="client")
@NamedQuery(name="Client.findAll", query="SELECT c FROM Client c")
public class Client implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private int idClient;

	@Column(length=50)
	private String activite;

	@Column(length=50)
	private String budget;

	@Column(length=50)
	private String confort;

	@Column(nullable=false)
	private int nbJourSejour;

	@Column(length=50)
	private String nomClient;

	@Column(length=50)
	private String varThematique;

	//bi-directional many-to-one association to Voyage
	@ManyToOne
	@JoinColumn(name="idVoyage", nullable=false)
	private Voyage voyage;

	public Client() {
	}

	public int getIdClient() {
		return this.idClient;
	}

	public void setIdClient(int idClient) {
		this.idClient = idClient;
	}

	public String getActivite() {
		return this.activite;
	}

	public void setActivite(String activite) {
		this.activite = activite;
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

	public Voyage getVoyage() {
		return this.voyage;
	}

	public void setVoyage(Voyage voyage) {
		this.voyage = voyage;
	}

}