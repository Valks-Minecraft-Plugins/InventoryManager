package com.inventorymanager;

import org.bukkit.Server;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import com.inventorymanager.listeners.InventoryListener;
import com.inventorymanager.listeners.UpdateInventory;

public class InventoryManager extends JavaPlugin {
	@Override
	public void onEnable() {
		Server s = getServer();
		
		registerListeners(s);
	}
	
	private void registerListeners(Server s) {
		PluginManager pm = s.getPluginManager();
		
		pm.registerEvents(new InventoryListener(), this);
		pm.registerEvents(new UpdateInventory(), this);
	}
}
