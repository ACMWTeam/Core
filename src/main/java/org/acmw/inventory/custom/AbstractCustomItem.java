package org.acmw.inventory.custom;

import org.bukkit.inventory.ItemStack;

public class AbstractCustomItem implements CustomItem {

	ItemStack itemStack;
	boolean canPickup;
	int preferedSlot;
	int[] allowedPISlots;
	int[] allowedCISlots;
	
	public AbstractCustomItem(ItemStack item, int... slots) {
		this(item, true, -1, new int[0], slots);
	}
	
	public AbstractCustomItem(ItemStack item, boolean canPickup, int[] playerSlots, int... slots) {
		this(item, canPickup, -1, playerSlots, slots);
	}
	
	public AbstractCustomItem(ItemStack item, boolean canPickup, int preferedSlot, int[] playerSlots, int... slots) {
		this.itemStack = item;
		this.canPickup = canPickup;
		this.preferedSlot = preferedSlot;
		this.allowedPISlots = playerSlots;
		this.allowedCISlots = slots;
	}
	
	@Override
	public ItemStack getRAWItemStack() {
		return itemStack;
	}
	
	@Override
	public void setCanPickup(boolean check) {
		canPickup = check;	
	}

	@Override
	public boolean canPickup() {
		return canPickup;
	}

	@Override
	public void setPreferedSlot(int slot) {
		preferedSlot = slot;
	}
	
	@Override
	public int getPreferedSlot() {
		return preferedSlot;
	}

	@Override
	public void setAllowedPlaceSlotsInPlayerInventory(int... slots) {
		allowedPISlots = slots;
	}

	@Override
	public void setAllowedPlaceSlotsInCustomInventory(int... slots) {
		allowedCISlots = slots;
	}

	@Override
	public int[] getAllowedPlaceSlotsInPlayerInventory() {
		return allowedPISlots;
	}

	@Override
	public int[] getAllowedPlaceSlotsInCustomInventory() {
		return allowedCISlots;
	}

}
