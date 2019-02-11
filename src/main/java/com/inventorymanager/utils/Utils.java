package com.inventorymanager.utils;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import net.md_5.bungee.api.ChatColor;

public class Utils {
	/*
	 * Inventory slots. 9 - Hot bar Slots 27 - Middle Main Slots 4 - Armor Slots 1 -
	 * Off hand Slot
	 */
	public static void updateInventory(Player p, int divider) {
		Inventory inv = p.getInventory();
		for (int i = inv.getSize(); i >= divider; i--) {
			switch (i) {
			case 41:
			case 40:
			case 39:
			case 38:
			case 37:
			case 36:
				break;
			default:
				inv.setItem(i, blocker());
			}
		}

		for (int i = 0; i < divider; i++) {
			if (inv.getItem(i) != null)
				if (inv.getItem(i).getType() == blocker().getType())
					inv.setItem(i, new ItemStack(Material.AIR));
		}
	}

	public static boolean isBlocked(Material type) {
		return type == blocker().getType();
	}

	public static ItemStack blocker() {
		ItemStack glass = new ItemStack(Material.BLACK_STAINED_GLASS_PANE);
		ItemMeta im = glass.getItemMeta();
		im.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&fBlocked"));
		List<String> list = new ArrayList<String>();
		list.add(ChatColor.translateAlternateColorCodes('&', "&7Gain more &flevels &7to unlock."));
		im.setLore(list);
		glass.setItemMeta(im);
		return glass;
	}
}
