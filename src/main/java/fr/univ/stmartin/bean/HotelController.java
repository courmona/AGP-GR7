package fr.univ.stmartin.bean;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import fr.univ.stmartin.dao.Hotel;

public class HotelController {
	private static String url = "jdbc:mysql://localhost:1521/voyage";
	private static String user = "root";
	private static String password = "arij";
	private static Connection connection;

	public HotelController() {
		prepareConnection();
	}

	private void prepareConnection() {
		if (connection == null) {
			try {
				connection = DriverManager.getConnection(url, user, password);
			} catch (Exception e) {
				System.err.println("Connection failed : " + e.getMessage());
			}
		}
	}

	public List<Hotel> selectHotelByVille(String ville) throws Exception {

		List<Hotel> listHotels = new ArrayList<>();

		String selectHotelQuery = "SELECT * FROM hotel where hotel.villeHotel= \"" + ville + "\"";

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(selectHotelQuery);

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

	public List<Hotel> selectHotelByClassement(List<String> listClassement) throws Exception {

		List<Hotel> listHotels = new ArrayList<>();
		try {
			StringBuilder builder = new StringBuilder();

			for (int i = 0; i < listClassement.size(); i++) {
				builder.append("?,");
			}

			String selectNomSiteQuery = "SELECT *  FROM hotel where hotel.classement in ( "
					+ builder.deleteCharAt(builder.length() - 1).toString() + " )";

			PreparedStatement preparedStatement = connection.prepareStatement(selectNomSiteQuery);

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
	public Hotel selectHotelById(int id) throws Exception {

		Hotel hotelTmp = null;
		String selectHotelQuery = "SELECT * FROM hotel where hotel.idHotel= "+ id;

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(selectHotelQuery);

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
			PreparedStatement preparedStatement = connection.prepareStatement(selectHotelQuery);

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
