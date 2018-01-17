package fr.univ.stmartin.dao;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the site database table.
 * 
 */
@Entity
@Table(name="site")
@NamedQuery(name="Site.findAll", query="SELECT s FROM Site s")
public class Site implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private int idSite;

	@Column(nullable=false, length=50)
	private String nomSite;

	@Column(nullable=false, length=50)
	private String villeSite;

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

}