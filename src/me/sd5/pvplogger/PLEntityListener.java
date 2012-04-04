package me.sd5.pvplogger;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class PLEntityListener implements Listener {
	
	private PVPLogger plugin;
	
	public PLEntityListener(PVPLogger plugin) {
		this.plugin = plugin;
	}
	
	@EventHandler
	public void onEntityDamageByEntity(EntityDamageByEntityEvent event) {
		
	}

}
