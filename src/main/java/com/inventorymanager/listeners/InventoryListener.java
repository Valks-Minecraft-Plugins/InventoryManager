package com.inventorymanager.listeners;

import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerSwapHandItemsEvent;
import org.bukkit.inventory.ItemStack;

import com.inventorymanager.utils.Utils;

public class InventoryListener implements Listener {
	@EventHandler
	private void itemPlaceEvent(BlockPlaceEvent e) {
		Block b = e.getBlock();
		if (b != null)
			if (Utils.isBlocked(b.getType()))
				e.setCancelled(true);
	}
	
	@EventHandler
	private void offHandSwitchEvent(PlayerSwapHandItemsEvent e) {
		ItemStack item = e.getOffHandItem();
		if (item != null) {
			if (Utils.isBlocked(item.getType()))
				e.setCancelled(true);
		}
	}
	
	@EventHandler
	private void dropItemEvent(PlayerDropItemEvent e) {
		ItemStack item = e.getItemDrop().getItemStack();
		if (item != null)
			if (Utils.isBlocked(item.getType()))
				e.setCancelled(true);
	}
	
	@EventHandler
	private void invClickEvent(InventoryClickEvent e) {
		ItemStack item = e.getCurrentItem();
		if (item != null)
			if (Utils.isBlocked(e.getCurrentItem().getType()))
				e.setCancelled(true);
	}
}
