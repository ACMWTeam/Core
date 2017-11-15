package org.acmw.entity.living.human.player;

import java.util.List;

import org.acmw.data.CustomData;
import org.acmw.data.DataHolder;
import org.bukkit.OfflinePlayer;

public class ACMWUser implements ACMWAccount {

	List<CustomData<? extends DataHolder>> data;
	OfflinePlayer player;
	
	public ACMWUser(OfflinePlayer player) {
		this.player = player;
	}
	
	@Override
	public OfflinePlayer getEntity() {
		return player;
	}
	
	@Override
	public List<CustomData<? extends DataHolder>> getData() {
		return data;
	}

}
