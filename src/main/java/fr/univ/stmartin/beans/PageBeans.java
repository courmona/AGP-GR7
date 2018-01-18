package fr.univ.stmartin.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import fr.univ.stmartin.controlleur.ActiviteController;
import fr.univ.stmartin.controlleur.DestiniationControlleur;
import fr.univ.stmartin.controlleur.HotelController;
import fr.univ.stmartin.dao.Activite;
import fr.univ.stmartin.dao.Hotel;

@ManagedBean
@SessionScoped
public class PageBeans implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String nbrJours;

	private boolean confort;

	private String budjet;

	private String variationthematique;

	private List<Activite> listActivite;

	private List<Activite> listActivitechoisi;

	private List<VoyageOffre> listVoyageOffre;

	public PageBeans() {

	}

	@PostConstruct
	public void init() {
		listActivite = ActiviteController.selectAllActivite();

	}

	public String rechercheOffres() throws Exception {

		listVoyageOffre = new ArrayList<>();

		List<String> listClassement = new ArrayList<>();

		if (this.confort) {
			listClassement.add("4");
			listClassement.add("5");
		} else {
			listClassement.add("1");
			listClassement.add("2");
			listClassement.add("3");
			listClassement.add("4");
			listClassement.add("5");
		}

		HotelController hotelController = new HotelController();

		List<Hotel> listHotels = null;

		if (null != listActivitechoisi && listActivitechoisi.size() > 0) {
			listHotels = hotelController.selectHotelByActiviteClassement(listClassement, listActivitechoisi,
					this.variationthematique);
		} else {
			listHotels = hotelController.selectHotelByClassement(listClassement, this.variationthematique);
		}

		for (Hotel hotel : listHotels) {
			VoyageOffre voyageTmp = new VoyageOffre();
			voyageTmp.setHotel(hotel);
			voyageTmp.setDestination(DestiniationControlleur.selectHotelById(1));
			voyageTmp.setNombreJour(Integer.valueOf(this.nbrJours));
			voyageTmp.setListActivite(listActivitechoisi);

			if (voyageTmp.getPrixOffre() <= Integer.parseInt(this.budjet)) {
				listVoyageOffre.add(voyageTmp);
			}

		}

		return null;
	}

	public String getNbrJours() {
		return nbrJours;
	}

	public void setNbrJours(String nbrJours) {
		this.nbrJours = nbrJours;
	}

	public boolean isConfort() {
		return confort;
	}

	public void setConfort(boolean confort) {
		this.confort = confort;
	}

	public String getBudjet() {
		return budjet;
	}

	public void setBudjet(String budjet) {
		this.budjet = budjet;
	}

	public String getVariationthematique() {
		return variationthematique;
	}

	public void setVariationthematique(String variationthematique) {
		this.variationthematique = variationthematique;
	}

	public List<Activite> getListActivite() {
		return listActivite;
	}

	public void setListActivite(List<Activite> listActivite) {
		this.listActivite = listActivite;
	}

	public List<Activite> getListActivitechoisi() {
		return listActivitechoisi;
	}

	public void setListActivitechoisi(List<Activite> listActivitechoisi) {
		this.listActivitechoisi = listActivitechoisi;
	}

	public List<VoyageOffre> getListVoyageOffre() {
		return listVoyageOffre;
	}

	public void setListVoyageOffre(List<VoyageOffre> listVoyageOffre) {
		this.listVoyageOffre = listVoyageOffre;
	}

}
