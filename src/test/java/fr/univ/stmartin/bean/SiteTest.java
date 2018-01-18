package fr.univ.stmartin.bean;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import fr.univ.stmartin.dao.Hotel;
import fr.univ.stmartin.dao.Site;

public class SiteTest {
	@Test
	public void listeSiteByVille() throws Exception {
		SiteController SiteController = new SiteController();
		List<Site> listSites = SiteController.selectSiteByVille("Cilaos");
		
		//System.out.println(listhotels.size());
		
		Assert.assertTrue(listSites.size() > 0);
	}
}
