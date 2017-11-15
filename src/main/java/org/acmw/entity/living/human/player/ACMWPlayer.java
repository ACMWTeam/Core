package org.acmw.entity.living.human.player;

import java.util.List;

import org.acmw.data.CustomData;
import org.acmw.data.DataHolder;
import org.acmw.entity.ACMWEntity;
import org.bukkit.entity.Player;

public class ACMWPlayer implements ACMWAccount, ACMWEntity<Player>{

	Player player;
	List<CustomData<? extends DataHolder>> data;

	@Override
	public List<CustomData<? extends DataHolder>> getData() {
		return data;
	}

	@Override
	public Player getEntity() {
		return player;
	};
	
}
