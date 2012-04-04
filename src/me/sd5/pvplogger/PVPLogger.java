package me.sd5.pvplogger;

import org.bukkit.plugin.java.JavaPlugin;

public class PVPLogger extends JavaPlugin {
	
	public PLEntityListener entityListener = new PLEntityListener(this);
	
	public void onEnable() {
		PLConfig.load(getConfig());
		getServer().getPluginManager().registerEvents(entityListener, this);
	}
	
}
