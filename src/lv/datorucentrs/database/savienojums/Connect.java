package lv.datorucentrs.database.savienojums;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connect {
	public static Connection connection = null;

	public Connection connect(String nameDB) throws ClassNotFoundException, SQLException {
		Class.forName("org.postgresql.Driver");

		connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/" + nameDB, "postgres", "admin");
		System.out.println("Izveidots savienojums ar DB!");
		return connection;

	}
	
	public static void disconnect() throws SQLException {
		if (connection !=null) {
			connection.close();
			System.out.println("Savienojums ar DB ir partraukts");
		}
	}

}