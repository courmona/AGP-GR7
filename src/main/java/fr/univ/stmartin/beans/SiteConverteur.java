package fr.univ.stmartin.beans;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import fr.univ.stmartin.controlleur.SiteControlleur;
import fr.univ.stmartin.dao.Site;

@FacesConverter(value = "siteConverteur")
public class SiteConverteur implements Converter {

	public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
		try {
			return SiteControlleur.selectSiteById(Integer.parseInt(value));
		} catch (Exception e) {

			e.printStackTrace();
			return null;
		}
	}

	public String getAsString(FacesContext facesContext, UIComponent component, Object o) {
		Site i = (Site) o;
		if (null != i)
			return String.valueOf(i.getIdSite());
		else
			return null;
	}
}
