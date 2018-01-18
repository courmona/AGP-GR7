package fr.univ.stmartin.controlleur;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fr.univ.stmartin.dao.Activite;

public class ActiviteController {

	public static List<Activite> selectAllActivite() {

		List<Activite> listActivite = new ArrayList<>();

		String selectHotelQuery = "SELECT * FROM activites ";

		try {

			PreparedStatement preparedStatement = ConnextionDb.getInstance().getConnection()
					.prepareStatement(selectHotelQuery);

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {

				Activite activiteTmp = new Activite();

				activiteTmp.setIdActivites(rs.getInt("idActivites"));
				activiteTmp.setNomActivites(rs.getString("nomActivites"));
				activiteTmp.setPrixActivites(rs.getInt("prixActivites"));
				listActivite.add(activiteTmp);
			}

			preparedStatement.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.err.println("Connection failed : " + e.getMessage());

		}
		return listActivite;
	}

	public static Activite selectActiviteById(int id) throws Exception {

		Activite activiteTmp = null;
		String selectHotelQuery = "SELECT * FROM activites where activites.idActivites= " + id;

		try {
			PreparedStatement preparedStatement = ConnextionDb.getInstance().getConnection()
					.prepareStatement(selectHotelQuery);

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {

				activiteTmp = new Activite();

				activiteTmp.setIdActivites(rs.getInt("idActivites"));
				activiteTmp.setNomActivites(rs.getString("nomActivites"));
				activiteTmp.setPrixActivites(rs.getInt("prixActivites"));

			}
			preparedStatement.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.err.println("Connection failed : " + e.getMessage());
			throw e;
		}
		return activiteTmp;
	}
}
