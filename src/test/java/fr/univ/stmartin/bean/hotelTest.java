package fr.univ.stmartin.bean;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import fr.univ.stmartin.controlleur.HotelController;
import fr.univ.stmartin.dao.Activite;
import fr.univ.stmartin.dao.Hotel;

public class hotelTest {

	@Test
	public void listehotelByVille() throws Exception {
		HotelController HotelController = new HotelController();
		List<Hotel> listhotels = HotelController.selectHotelByVille("Petite ile");

		// System.out.println(listhotels.size());

		Assert.assertTrue(listhotels.size() == 0);
	}

	@Test
	public void listehotelByclassement() throws Exception {
		HotelController HotelController = new HotelController();

		List<String> listClassement = new ArrayList<>();
		listClassement.add("5");
		listClassement.add("4");

		List<Hotel> listhotels = HotelController.selectHotelByClassement(listClassement, null);

		Assert.assertTrue(listhotels.size() > 0);

		for (Hotel hotel : listhotels) {
			// System.out.println(hotel.getClassement()+ hotel.getIdHotel());
			Assert.assertTrue(hotel.getClassement().equals("5") || hotel.getClassement().equals("4"));
		}

	}

	@Test
	public void listehotelByActiviterClassement() throws Exception {
		HotelController HotelController = new HotelController();

		List<Activite> listActivite = new ArrayList<>();
		Activite act = new Activite();
		act.setIdActivites(6);
		listActivite.add(act);

		List<String> listClassement = new ArrayList<>();
		listClassement.add("5");
		listClassement.add("4");

		List<Hotel> listhotels = HotelController.selectHotelByActiviteClassement(listClassement, listActivite, null);

		Assert.assertTrue(listhotels.size() == 2);

	}

	@Test
	public void listehotelByActiviter() throws Exception {
		HotelController HotelController = new HotelController();

		List<Activite> listActivite = new ArrayList<>();
		Activite act = new Activite();
		act.setIdActivites(6);
		listActivite.add(act);

		List<Hotel> listhotels = HotelController.selectHotelByActivite(listActivite);

		Assert.assertTrue(listhotels.size() == 2);

	}

	@Test
	public void listehotelById() throws Exception {
		HotelController HotelController = new HotelController();
		Hotel hotel = HotelController.selectHotelById(2);

		Assert.assertTrue(hotel.getIdHotel() == 2);
	}

	@Test
	public void selectAllHotelTest() throws Exception {
		HotelController HotelController = new HotelController();
		List<Hotel> listhotels = HotelController.selectAllHotel();

		// System.out.println(listhotels.size());

		Assert.assertTrue(listhotels.size() > 0);
	}

}
