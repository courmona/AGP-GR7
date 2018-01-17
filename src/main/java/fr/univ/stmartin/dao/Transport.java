package fr.univ.stmartin.dao;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the transport database table.
 * 
 */
@Entity
@Table(name="transport")
@NamedQuery(name="Transport.findAll", query="SELECT t FROM Transport t")
public class Transport implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private int idTransport;

	@Column(length=50)
	private String moyenDeTransport;

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

}