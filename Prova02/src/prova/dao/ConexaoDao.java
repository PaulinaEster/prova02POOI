package prova.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoDao {

	static final String DATA_BASE_URL = "jdbc:mysql://localhost:3306/veiculosdb";
	
	static final String USERNAME = "root";

	static final String PASSWORD = "";
	
	Connection connection = null; 
	
	public Connection getConnection() throws SQLException {
		connection = DriverManager.getConnection(DATA_BASE_URL, USERNAME, PASSWORD);
		return connection;
	}
	
}
