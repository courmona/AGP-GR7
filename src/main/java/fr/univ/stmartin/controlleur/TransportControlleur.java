package fr.univ.stmartin.controlleur;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import fr.univ.stmartin.dao.Transport;

public class TransportControlleur {

	public static Transport selectTransportById(int id) throws Exception {

		Transport transportTmp = null;
		String selectHotelQuery = "SELECT * FROM transport where transport.idTransport= " + id;

		try {
			PreparedStatement preparedStatement = ConnextionDb.getInstance().getConnection()
					.prepareStatement(selectHotelQuery);

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {

				transportTmp = new Transport();

				transportTmp.setIdTransport(rs.getInt("idTransport"));
				transportTmp.setMoyenDeTransport(rs.getString("moyenDeTransport"));
				transportTmp.setPrixTransport(rs.getInt("prixTransport"));

			}
			preparedStatement.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.err.println("Connection failed : " + e.getMessage());
			throw e;
		}

		return transportTmp;
	}
}
