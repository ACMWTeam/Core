package org.acmw.inventory.custom;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.bukkit.inventory.Inventory;

public class AbstractCustomInventory implements CustomInventory {

	Inventory inventory;
	List<CustomItem> items = new ArrayList<>();
	
	public AbstractCustomInventory(Inventory inventory, CustomItem... items) {
		this.inventory = inventory;
		this.items.addAll(Arrays.asList(items));
	}
	
	@Override
	public Inventory getRAWInventory() {
		return inventory;
	}

	@Override
	public Set<CustomItem> getItems() {
		return new HashSet<>(items);
	}

	@Override
	public void addItem(CustomItem item, int slot) {
		items.add(item);
		inventory.setItem(slot, item.getRAWItemStack());
	}
	
	@Override
	public void addItemInEmptySlot(CustomItem item) {
		items.add(item);
		inventory.addItem(item.getRAWItemStack());
	}

	@Override
	public void removeItem(CustomItem item) {
		items.remove(item);
		inventory.remove(item.getRAWItemStack());
	}	

}
