package fr.univ.stmartin.beans;

import java.io.Serializable;
import java.util.List;

import fr.univ.stmartin.dao.Activite;
import fr.univ.stmartin.dao.Destination;
import fr.univ.stmartin.dao.Hotel;

public class VoyageOffre implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Hotel hotel;

	private String prixTotal;

	private boolean confortable;

	private Destination destination;

	private int nombreJour;

	private List<Activite> listActivite;

	public VoyageOffre() {

	}

	public int getPrixOffre() {

		int prixTotal = nombreJour * this.hotel.getPrixNuit();

		prixTotal = prixTotal + this.hotel.getPrixTransportSiteTotal();

		for (Activite activite : listActivite) {
			prixTotal = prixTotal + activite.getPrixActivites();
		}

		this.prixTotal = String.valueOf(prixTotal);
		return prixTotal;
	}

	public Hotel getHotel() {
		return hotel;
	}

	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}

	public String getPrixTotal() {
		return prixTotal;
	}

	public void setPrixTotal(String prixTotal) {
		this.prixTotal = prixTotal;
	}

	public boolean isConfortable() {
		return confortable;
	}

	public void setConfortable(boolean confortable) {
		this.confortable = confortable;
	}

	public Destination getDestination() {
		return destination;
	}

	public void setDestination(Destination destination) {
		this.destination = destination;
	}

	public int getNombreJour() {
		return nombreJour;
	}

	public void setNombreJour(int nombreJour) {
		this.nombreJour = nombreJour;
	}

	public List<Activite> getListActivite() {
		return listActivite;
	}

	public void setListActivite(List<Activite> listActivite) {
		this.listActivite = listActivite;
	}

}
