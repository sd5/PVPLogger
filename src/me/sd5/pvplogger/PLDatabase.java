package me.sd5.pvplogger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class PLDatabase {
	
	private Connection connection;
	private Statement statement;
	private ResultSet resultSet;
	
	public PLDatabase() {
		try {
			connection = DriverManager.getConnection(PLConfig.dbUrl, PLConfig.dbUser, PLConfig.dbPassword);
			statement = connection.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		System.out.println("Creating MySQL table...");
		try {
			statement.execute("CREATE TABLE " + PLConfig.dbTable);
			System.out.print("Sucessfully created MySQL table!");
		} catch(SQLException e) {
			System.out.println("MySQL table already exists!");
		}
	}
	
}
