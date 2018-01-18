package fr.univ.stmartin.controlleur;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Set;

public class JDBCPersistence {

	public JDBCPersistence() {

	}

	public void afficheNomSite(Set<String> listIdFileContientParole) throws Exception {
		try {
			// String selectNomSiteQuery = "SELECT * FROM site where site.idSite in ?" ;

			StringBuilder builder = new StringBuilder();

			for (int i = 0; i < listIdFileContientParole.size(); i++) {
				builder.append("?,");
			}

			String selectNomSiteQuery = "SELECT *  FROM site where site.idSite in ( "
					+ builder.deleteCharAt(builder.length() - 1).toString() + " )";

			PreparedStatement preparedStatement = ConnextionDb.getInstance().getConnection()
					.prepareStatement(selectNomSiteQuery);

			int index = 1;
			for (Object o : listIdFileContientParole) {
				preparedStatement.setObject(index++, o); // or whatever it applies
			}

			ResultSet rs = preparedStatement.executeQuery();

			System.out.println("liste des noms sites touristiques trouvés sont: ");

			while (rs.next()) {
				String idSite = rs.getString("idSite");
				String nomSite = rs.getString("nomSite");

				System.out.println("idSite: " + idSite);
				System.out.println("nomSite:" + nomSite);
			}
			preparedStatement.close();
		} catch (SQLException se) {
			System.err.println(se.getMessage());
		}
	}

}
