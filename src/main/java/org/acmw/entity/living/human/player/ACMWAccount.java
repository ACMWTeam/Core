package org.acmw.entity.living.human.player;

import org.acmw.data.DataHolder;
import org.bukkit.OfflinePlayer;

public interface ACMWAccount extends DataHolder {
	
	public OfflinePlayer getEntity();

}
