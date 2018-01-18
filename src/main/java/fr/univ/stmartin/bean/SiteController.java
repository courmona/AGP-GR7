package fr.univ.stmartin.bean;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fr.univ.stmartin.dao.Hotel;
import fr.univ.stmartin.dao.Site;

public class SiteController {
	private static String url = "jdbc:mysql://localhost:1521/voyage";
	private static String user = "root";
	private static String password = "arij";
	private static Connection connection;

	public SiteController() {
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
	
	
	public List<Site> selectSiteByVille(String ville) throws Exception {

		List<Site> listSites = new ArrayList<>();

		String selectSiteQuery = "SELECT * FROM site where site.villeSite = \"" + ville + "\"";

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(selectSiteQuery);

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {

				Site siteTmp = new Site();
				siteTmp.setIdSite(rs.getInt("idSite"));
				siteTmp.setNomSite(rs.getString("nomSite"));
				siteTmp.setVilleSite(rs.getString("villeSite"));
				listSites.add(siteTmp);
			}
			preparedStatement.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.err.println("Connection failed : " + e.getMessage());
			throw e;
		}
		return listSites;
	}
	
	
	
	
	
	
	
}
