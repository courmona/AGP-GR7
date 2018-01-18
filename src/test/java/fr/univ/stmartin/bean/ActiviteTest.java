package fr.univ.stmartin.bean;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import fr.univ.stmartin.controlleur.ActiviteController;
import fr.univ.stmartin.dao.Activite;

public class ActiviteTest {

	@Test
	public void selectAllActiviteTest() throws Exception {
		List<Activite> listActivite = ActiviteController.selectAllActivite();

		// System.out.println(listhotels.size());

		Assert.assertTrue(listActivite.size() > 0);
	}
}
