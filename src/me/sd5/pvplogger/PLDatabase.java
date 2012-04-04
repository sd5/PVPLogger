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
	
	public void init() {
		try {
			connection = DriverManager.getConnection(PLConfig.dbUrl, PLConfig.dbUser, PLConfig.dbPassword);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
