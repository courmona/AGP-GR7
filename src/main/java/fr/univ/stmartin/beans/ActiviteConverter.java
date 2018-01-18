package fr.univ.stmartin.beans;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import fr.univ.stmartin.controlleur.ActiviteController;
import fr.univ.stmartin.dao.Activite;

@FacesConverter(value = "activiteConverter")
public class ActiviteConverter implements Converter {

	public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
		try {
			return ActiviteController.selectActiviteById(Integer.parseInt(value));
		} catch (Exception e) {

			e.printStackTrace();
			return null;
		}
	}

	public String getAsString(FacesContext facesContext, UIComponent component, Object o) {
		Activite i = (Activite) o;
		if (null != i)
			return String.valueOf(i.getIdActivites());
		else
			return null;
	}
}
