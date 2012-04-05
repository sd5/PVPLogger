package me.sd5.pvplogger;

import org.bukkit.plugin.java.JavaPlugin;

public class PVPLogger extends JavaPlugin {
	
	public PLDatabase database;
	public PLEntityListener entityListener = new PLEntityListener(this);
	
	public void onEnable() {
		PLConfig.load(this);
		database = new PLDatabase();
		getServer().getPluginManager().registerEvents(entityListener, this);
	}
	
}
