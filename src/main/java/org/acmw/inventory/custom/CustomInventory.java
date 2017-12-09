package org.acmw.inventory.custom;

import java.util.Optional;
import java.util.Set;

import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public interface CustomInventory {
	
	public Inventory getRAWInventory();
	public Set<CustomItem> getItems();
	public void addItem(CustomItem item, int slot);
	public void addItemInEmptySlot(CustomItem item);
	public void removeItem(CustomItem item);
	
	public default void removeItem(int slot) {
		ItemStack item = getRAWInventory().getItem(slot);
		if(item == null) {
			return;
		}
		Optional<CustomItem> opItem = getItems().stream().filter(i -> i.getRAWItemStack().equals(item)).findFirst();
		if(!opItem.isPresent()) {
			return;
		}
		removeItem(opItem.get());
	}
	
	public default void addItem(CustomItem item) {
		switch(item.getPreferedSlot()) {
		case -1: addItemInEmptySlot(item); return;
		default: addItem(item, item.getPreferedSlot()); return;
		}
	}
	

}
