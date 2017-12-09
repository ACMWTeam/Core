package org.acmw.inventory.custom;

import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

public interface CustomItem {
	
	public ItemStack getRAWItemStack();
	public void setCanPickup(boolean check);
	public boolean canPickup();
	public void setPreferedSlot(int slot);
	public int getPreferedSlot();
	public void setAllowedPlaceSlotsInPlayerInventory(int... slots);
	public void setAllowedPlaceSlotsInCustomInventory(int... slots);
	public int[] getAllowedPlaceSlotsInPlayerInventory();
	public int[] getAllowedPlaceSlotsInCustomInventory();
	
	public interface OnClick {
		
		public void onClick(InventoryClickEvent event);
		
	}

}
