package fr.univ.stmartin.bean;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import fr.univ.stmartin.controlleur.SiteControlleur;
import fr.univ.stmartin.dao.Site;

public class SiteTest {
	@Test
	public void listeSiteByVille() throws Exception {
		List<Site> listSites = SiteControlleur.selectSiteByVille("Cilaos");

		// System.out.println(listhotels.size());

		Assert.assertTrue(listSites.size() > 0);
	}

	@Test
	public void listeSiteTrouveTest() throws Exception {

		List<Site> listSites = SiteControlleur.selectSiteSouhaités("Cilaos", "plage louvre cergy");

		// System.out.println(listhotels.size());

		Assert.assertTrue(listSites.size() == 0);
	}
}