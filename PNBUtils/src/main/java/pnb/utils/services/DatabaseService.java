package pnb.utils.services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.google.inject.Singleton;

@Singleton
public class DatabaseService {
	private String connectionString;
	private Connection conn;
	
	public void initializeService(String dbPath) throws SQLException {
		this.connectionString = "jdbc:h2:" + dbPath;
		
		this.conn = DriverManager.getConnection(connectionString, "sa", "");
		
	}
	
	public void shutdownService() throws SQLException {
		conn.close();
	}
}
