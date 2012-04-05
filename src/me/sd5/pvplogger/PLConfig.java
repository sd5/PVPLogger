package me.sd5.pvplogger;

import org.bukkit.configuration.file.FileConfiguration;

public class PLConfig {
	
	private static FileConfiguration config;
	
	//Settings
	public static String dbUrl = null;
	public static String dbUser = null;
	public static String dbPassword = null;
	public static String dbTable = null;
	
	public static void load(PVPLogger plugin) {
		config = plugin.getConfig();
		config.options().copyDefaults(true);
		config.options().header("PVPLogger config file.");
		plugin.saveConfig();
		
		dbUrl = "jdbc:mysql://" + config.getString("mysql-connection.host") + ":" + config.getString("mysql-connection.port") + "/" + config.getString("mysql-connection.database");
		dbUser = config.getString("mysql-connection.user");
		dbPassword = config.getString("mysql-connection.password");
		dbTable = config.getString("mysql-connection.table");
	}
	
}
