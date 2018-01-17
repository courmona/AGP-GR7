package fr.univ.stmartin.bean;

import java.lang.reflect.Array;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Set;

public class JDBCPersistence {
	private static String url = "jdbc:mysql://localhost:1521/voyage";
	private static String user = "root";
	private static String password = "arij";
	private static Connection connection;

	public JDBCPersistence() {
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

	public void afficheNomSite(Set<String> listIdFileContientParole) throws Exception {
		try {
			// String selectNomSiteQuery = "SELECT * FROM site where site.idSite in ?" ;

			StringBuilder builder = new StringBuilder();

			for (int i = 0; i < listIdFileContientParole.size(); i++) {
				builder.append("?,");
			}

			String selectNomSiteQuery = "SELECT *  FROM site where site.idSite in ( "
					+ builder.deleteCharAt(builder.length() - 1).toString() + " )";

			PreparedStatement preparedStatement = connection.prepareStatement(selectNomSiteQuery);

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

		} catch (SQLException se) {
			System.err.println(se.getMessage());
		}
	}

}
