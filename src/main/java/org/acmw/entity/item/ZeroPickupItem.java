package org.acmw.entity.item;

import org.bukkit.entity.Item;

public class ZeroPickupItem implements ACMWItem {

	Item item;
	
	public ZeroPickupItem(Item item) {
		this.item = item;
		item.setPickupDelay(-1);
	}
	
	@Override
	public Item getEntity() {
		return item;
	}

}
