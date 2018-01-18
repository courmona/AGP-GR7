package fr.univ.stmartin.controlleur;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnextionDb {

	private static ConnextionDb mySelf;

	private static String url = "jdbc:mysql://localhost:3306/voyage";
	private static String user = "root";
	private static String password = "admin";
	private static Connection connection;

	public static ConnextionDb getInstance() {

		if (null == mySelf) {
			mySelf = new ConnextionDb();
		}

		return mySelf;
	}

	private ConnextionDb() {
		if (connection == null) {
			try {
				connection = DriverManager.getConnection(url, user, password);
			} catch (Exception e) {
				System.err.println("Connection failed : " + e.getMessage());
			}
		}
	}

	public Connection getConnection() {
		return connection;
	}

}
