package me.sd5.pvplogger;

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
		if( !(event.getDamager() instanceof Player) && !(event.getEntity() instanceof Player) )
			return;
		
		PLDatabase.writeEntry((Player) event.getDamager(), (Player) event.getEntity(), event.getDamage());
	}

}
