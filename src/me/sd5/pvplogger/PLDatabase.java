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
		System.out.println("[PVPLogger] Connecting to database...");
		try {
			connection = DriverManager.getConnection(PLConfig.dbUrl, PLConfig.dbUser, PLConfig.dbPassword);
			statement = connection.createStatement();
			System.out.println("[PVPLogger] Successfully connected to database!");
		} catch (SQLException e) {
			System.out.println("[PVPLogger] Could not connect to database!");
			return;
		}
		
		System.out.println("[PVPLogger] Creating MySQL table...");
		try {
		    String sql = "CREATE TABLE pvplogger("
		        + "date       DATE, "
		        + "time       TIME, "
		        + "x          INTEGER, "
		        + "y          INTEGER, "
		        + "z          INTEGER, "
		        + "world      VARCHAR(255), "
		        + "attacker   VARCHAR(255), "
		        + "victim     VARCHAR(255), "
		        + "damage     INTEGER, "
		        + "weapon     VARCHAR(255), "
		        + "fatal      BOOL)";

		    statement.executeUpdate(sql);		
			System.out.println("[PVPLogger] Successfully created MySQL table!");
		} catch(SQLException e) {
			System.out.println("[PVPLogger] MySQL table already exists!");
			return;
		}
	}
	
}
