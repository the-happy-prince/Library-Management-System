//This class is responsible for establishing connection with the database

package library.management.system;

import java.sql.*;

public class EstablishConnection {
	Connection connection = null;
	Statement statement;
	public EstablishConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql:///libproject", "prince","");
			statement = connection.createStatement();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
