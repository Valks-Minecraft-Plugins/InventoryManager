package com.inventorymanager.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerLevelChangeEvent;
import org.bukkit.event.player.PlayerRespawnEvent;

import com.inventorymanager.utils.Utils;

public class UpdateInventory implements Listener {
	public static int minSlots = 5;
	
	@EventHandler
	private void playerLevelChangeEvent(PlayerLevelChangeEvent e) {
		Utils.updateInventory(e.getPlayer(), minSlots + e.getNewLevel());
	}
	
	@EventHandler
	private void playerJoinEvent(PlayerJoinEvent e) {
		Player p = e.getPlayer();
		Utils.updateInventory(p, minSlots + p.getLevel());
	}
	
	@EventHandler
	private void playerRespawnEvent(PlayerRespawnEvent e) {
		Player p = e.getPlayer();
		Utils.updateInventory(p, minSlots + p.getLevel());
	}
}
