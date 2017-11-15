package org.acmw.inventory;

import org.bukkit.Bukkit;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;

public interface InventoryUtil {
	
	public static int[] PLAYER_HOTBAR_SLOTS = {};
	public static int[] PLAYER_ROW_2_SLOTS = {};
	public static int[] PLAYER_ROW_3_SLOTS = {};
	public static int[] PLAYER_ROW_4_SLOTS = {};
	public static int PLAYER_SECOND_HAND_SLOT = 0;
	public static int PLAYER_CRAFTING_TOP_LEFT = 0;
	public static int PLAYER_CRAFTING_TOP_RIGHT= 0;
	public static int PLAYER_CRAFTING_BOTTOM_LEFT = 0;
	public static int PLAYER_CRAFTING_BOTTOM_RIGHT = 0;
	public static int PLAYER_ARMOR_SHOES = 0;
	public static int PLAYER_ARMOR_LEGGINGS = 0;
	public static int PLAYER_ARMOR_BODY = 0;
	public static int PLAYER_ARMOR_HELMIT = 0;
	
	
	public static class Creator {
		
		String title;
		int size;
		InventoryType type;
		
		public int getSize() {
			return size;
		}
		
		public Creator setSize(int size) {
			this.size = size;
			return this;
		}
		
		public String getTitle() {
			return title;
		}
		
		public Creator setTitle(String title) {
			this.title = title;
			return this;
		}
		
		public InventoryType getType() {
			return type;
		}
		
		public void setType(InventoryType type) {
			this.type = type;
		}
		
		public Inventory build() {
			if(type == null) {
				if(title == null) {
					return Bukkit.createInventory(null, size);
				}else {
					return Bukkit.createInventory(null, size, title);
				}
			}else {
				if(title == null) {
					return Bukkit.createInventory(null, type);
				}else {
					return Bukkit.createInventory(null, type, title);
				}
			}
		}
		
	}

}
