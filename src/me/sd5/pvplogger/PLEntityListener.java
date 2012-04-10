package me.sd5.pvplogger;

import org.bukkit.entity.Arrow;
import org.bukkit.entity.Player;
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
		if(event.getEntity() instanceof Player) {
			if(event.getDamager() instanceof Player) {
				PLDatabase.writeEntry((Player) event.getDamager(), (Player) event.getEntity(), event.getDamage());
			}
			if(event.getDamager() instanceof Arrow) {
				if(((Arrow) event.getDamager()).getShooter() instanceof Player) {
					PLDatabase.writeEntry((Player) ((Arrow) event.getDamager()).getShooter(), (Player) event.getEntity(), event.getDamage());
				}
			}
		}
	}

}
