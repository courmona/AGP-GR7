package fr.univ.stmartin.controlleur;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import fr.univ.stmartin.dao.Destination;

public class DestiniationControlleur {

	public static Destination selectHotelById(int id) throws Exception {

		Destination destinationTmp = null;

		String selectHotelQuery = "SELECT * FROM destination where destination.idDestination= " + id;

		try {

			PreparedStatement preparedStatement = ConnextionDb.getInstance().getConnection()
					.prepareStatement(selectHotelQuery);

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {

				destinationTmp = new Destination();

				destinationTmp.setIdDestination(rs.getInt("idDestination"));
				destinationTmp.setNomDestination(rs.getString("nomDestination"));

			}
			preparedStatement.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.err.println("Connection failed : " + e.getMessage());
			throw e;
		}
		return destinationTmp;
	}

}
