package fr.univ.stmartin.controlleur;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fr.univ.stmartin.dao.Activite;
import fr.univ.stmartin.dao.Hotel;
import fr.univ.stmartin.dao.Site;

public class HotelController {
	public HotelController() {

	}

	public List<Hotel> selectHotelByVille(String ville) throws Exception {

		List<Hotel> listHotels = new ArrayList<>();

		String selectHotelQuery = "SELECT * FROM hotel where hotel.villeHotel= \"" + ville + "\"";

		try {
			PreparedStatement preparedStatement = ConnextionDb.getInstance().getConnection()
					.prepareStatement(selectHotelQuery);

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {

				Hotel hotelTmp = new Hotel();

				hotelTmp.setIdHotel(rs.getInt("idHotel"));
				hotelTmp.setNomHotel(rs.getString("nomHotel"));
				hotelTmp.setPrixNuit(rs.getInt("prixNuit"));
				hotelTmp.setVilleHotel(rs.getString("villeHotel"));
				hotelTmp.setClassement(rs.getString("classement"));

				listHotels.add(hotelTmp);
			}
			preparedStatement.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.err.println("Connection failed : " + e.getMessage());
			throw e;
		}
		return listHotels;
	}

	public List<Hotel> selectHotelByActiviteClassement(List<String> listClassement, List<Activite> listActivite,
			String variationString) throws Exception {

		List<Hotel> listHotels = new ArrayList<>();
		try {
			StringBuilder builder = new StringBuilder();

			for (int i = 0; i < listActivite.size(); i++) {
				builder.append("?,");
			}

			String selectNomSiteQuery = "SELECT hotel.*  FROM hotel INNER JOIN hotelactivites ON hotel.idHotel = hotelactivites.idHotel where hotelactivites.idActivites in ( "
					+ builder.deleteCharAt(builder.length() - 1).toString() + " )";

			builder = new StringBuilder();

			for (int i = 0; i < listClassement.size(); i++) {
				builder.append("?,");
			}

			selectNomSiteQuery = selectNomSiteQuery + " AND hotel.classement in ( "
					+ builder.deleteCharAt(builder.length() - 1).toString() + " )";

			PreparedStatement preparedStatement = ConnextionDb.getInstance().getConnection()
					.prepareStatement(selectNomSiteQuery);

			int index = 1;
			for (Activite o : listActivite) {
				preparedStatement.setObject(index++, (Object) o.getIdActivites()); // or whatever it applies
			}

			for (Object o : listClassement) {
				preparedStatement.setObject(index++, o); // or whatever it applies
			}

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {

				Hotel hotelTmp = new Hotel();

				hotelTmp.setIdHotel(rs.getInt("idHotel"));
				hotelTmp.setNomHotel(rs.getString("nomHotel"));
				hotelTmp.setPrixNuit(rs.getInt("prixNuit"));
				hotelTmp.setVilleHotel(rs.getString("villeHotel"));
				hotelTmp.setClassement(rs.getString("classement"));

				if (null != variationString && variationString.length() > 0) {
					List<Site> listSites = SiteControlleur.selectSiteSouhaités(hotelTmp.getVilleHotel(),
							variationString);

					if (null != listSites && listSites.size() > 0) {
						for (Site site : listSites) {
							int prixTmp = hotelTmp.getPrixTransportSiteTotal() + site.getTransport().getPrixTransport();
							hotelTmp.setPrixTransportSiteTotal(prixTmp);
						}
						if (!listHotels.contains(hotelTmp))
							listHotels.add(hotelTmp);
					}

				} else {
					if (!listHotels.contains(hotelTmp))
						listHotels.add(hotelTmp);
				}

			}
			preparedStatement.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.err.println("Connection failed : " + e.getMessage());
			throw e;
		}
		return listHotels;
	}

	public List<Hotel> selectHotelByActivite(List<Activite> listActivite) throws Exception {

		List<Hotel> listHotels = new ArrayList<>();
		try {
			StringBuilder builder = new StringBuilder();

			for (int i = 0; i < listActivite.size(); i++) {
				builder.append("?,");
			}

			String selectNomSiteQuery = "SELECT hotel.*  FROM hotel INNER JOIN hotelactivites ON hotel.idHotel = hotelactivites.idHotel where hotelactivites.idActivites in ( "
					+ builder.deleteCharAt(builder.length() - 1).toString() + " )";

			PreparedStatement preparedStatement = ConnextionDb.getInstance().getConnection()
					.prepareStatement(selectNomSiteQuery);

			int index = 1;
			for (Activite o : listActivite) {
				preparedStatement.setObject(index++, (Object) o.getIdActivites()); // or whatever it applies
			}

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {

				Hotel hotelTmp = new Hotel();

				hotelTmp.setIdHotel(rs.getInt("idHotel"));
				hotelTmp.setNomHotel(rs.getString("nomHotel"));
				hotelTmp.setPrixNuit(rs.getInt("prixNuit"));
				hotelTmp.setVilleHotel(rs.getString("villeHotel"));
				hotelTmp.setClassement(rs.getString("classement"));

				listHotels.add(hotelTmp);
			}
			preparedStatement.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.err.println("Connection failed : " + e.getMessage());
			throw e;
		}
		return listHotels;
	}

	public List<Hotel> selectHotelByClassement(List<String> listClassement, String variationString) throws Exception {

		List<Hotel> listHotels = new ArrayList<>();
		try {
			StringBuilder builder = new StringBuilder();

			for (int i = 0; i < listClassement.size(); i++) {
				builder.append("?,");
			}

			String selectNomSiteQuery = "SELECT *  FROM hotel where hotel.classement in ( "
					+ builder.deleteCharAt(builder.length() - 1).toString() + " )";

			PreparedStatement preparedStatement = ConnextionDb.getInstance().getConnection()
					.prepareStatement(selectNomSiteQuery);

			int index = 1;
			for (Object o : listClassement) {
				preparedStatement.setObject(index++, o); // or whatever it applies
			}

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {

				Hotel hotelTmp = new Hotel();

				hotelTmp.setIdHotel(rs.getInt("idHotel"));
				hotelTmp.setNomHotel(rs.getString("nomHotel"));
				hotelTmp.setPrixNuit(rs.getInt("prixNuit"));
				hotelTmp.setVilleHotel(rs.getString("villeHotel"));
				hotelTmp.setClassement(rs.getString("classement"));

				if (null != variationString && variationString.length() > 0) {
					List<Site> listSites = SiteControlleur.selectSiteSouhaités(hotelTmp.getVilleHotel(),
							variationString);

					if (null != listSites && listSites.size() > 0) {
						for (Site site : listSites) {
							int prixTmp = hotelTmp.getPrixTransportSiteTotal() + site.getTransport().getPrixTransport();
							hotelTmp.setPrixTransportSiteTotal(prixTmp);
						}
						if (!listHotels.contains(hotelTmp))
							listHotels.add(hotelTmp);
					}

				} else {
					if (!listHotels.contains(hotelTmp))
						listHotels.add(hotelTmp);
				}
			}
			preparedStatement.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.err.println("Connection failed : " + e.getMessage());
			throw e;
		}
		return listHotels;
	}

	public static Hotel selectHotelById(int id) throws Exception {

		Hotel hotelTmp = null;
		String selectHotelQuery = "SELECT * FROM hotel where hotel.idHotel= " + id;

		try {
			PreparedStatement preparedStatement = ConnextionDb.getInstance().getConnection()
					.prepareStatement(selectHotelQuery);

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {

				hotelTmp = new Hotel();

				hotelTmp.setIdHotel(rs.getInt("idHotel"));
				hotelTmp.setNomHotel(rs.getString("nomHotel"));
				hotelTmp.setPrixNuit(rs.getInt("prixNuit"));
				hotelTmp.setVilleHotel(rs.getString("villeHotel"));
				hotelTmp.setClassement(rs.getString("classement"));

			}
			preparedStatement.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.err.println("Connection failed : " + e.getMessage());
			throw e;
		}
		return hotelTmp;
	}

	public List<Hotel> selectAllHotel() throws Exception {

		List<Hotel> listHotels = new ArrayList<>();

		String selectHotelQuery = "SELECT * FROM hotel";
		try {
			PreparedStatement preparedStatement = ConnextionDb.getInstance().getConnection()
					.prepareStatement(selectHotelQuery);

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {

				Hotel hotelTmp = new Hotel();

				hotelTmp.setIdHotel(rs.getInt("idHotel"));
				hotelTmp.setNomHotel(rs.getString("nomHotel"));
				hotelTmp.setPrixNuit(rs.getInt("prixNuit"));
				hotelTmp.setVilleHotel(rs.getString("villeHotel"));
				hotelTmp.setClassement(rs.getString("classement"));

				listHotels.add(hotelTmp);
			}
			preparedStatement.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.err.println("Connection failed : " + e.getMessage());
			throw e;
		}
		return listHotels;
	}

}
