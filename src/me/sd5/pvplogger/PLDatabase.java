package me.sd5.pvplogger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.bukkit.entity.Player;

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
		    String sql = "CREATE TABLE pvplogger ("
		        + "date           VARCHAR(255), "
		        + "attacker       VARCHAR(255), "
		        + "attacker_world VARCHAR(255), "
		        + "attacker_x     INTEGER, "
		        + "attacker_y     INTEGER, "
		        + "attacker_z     INTEGER, "
		        + "victim         VARCHAR(255), "
		        + "victim_world   VARCHAR(255), "
		        + "victim_x       INTEGER, "
		        + "victim_y       INTEGER, "
		        + "victim_z       INTEGER, "
		        + "weapon         VARCHAR(255), "
		        + "damage         INTEGER, "
		        + "fatal          BOOL)";

		    statement.executeUpdate(sql);		
			System.out.println("[PVPLogger] Successfully created MySQL table!");
		} catch(SQLException e) {
			System.out.println("[PVPLogger] MySQL table already exists!");
			return;
		}
	}
	
	public static void writeEntry(Player p1, Player p2, int damage) {
		String date = getDate();
		String attacker = p1.getName();
		String attacker_world = p1.getLocation().getWorld().toString();
		int attacker_x = p1.getLocation().getBlockX();
		int attacker_y = p1.getLocation().getBlockY();
		int attacker_z = p1.getLocation().getBlockZ();
		String victim = p2.getName();
		int victim_x = p2.getLocation().getBlockX();
		int victim_y = p2.getLocation().getBlockZ();
		int victim_z = p2.getLocation().getBlockZ();
		String weapon = p1.getItemInHand().getType().toString().toLowerCase();
		boolean fatal = (p2.getHealth() > 0) ? false : true;
	}
	
	private static String getDate() {
		Date date = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return dateFormat.format(date);
	}
	
}
