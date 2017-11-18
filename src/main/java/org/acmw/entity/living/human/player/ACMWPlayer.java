package org.acmw.entity.living.human.player;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.acmw.data.CustomData;
import org.acmw.data.DataHolder;
import org.acmw.entity.ACMWEntity;
import org.bukkit.entity.Player;

public class ACMWPlayer implements ACMWAccount, ACMWEntity<Player>{

	Player player;
	List<CustomData<? extends DataHolder>> data;
	
	private static final List<ACMWPlayer> ONLINE_PLAYERS = new ArrayList<>();

	protected ACMWPlayer(Player player) {
		this.player = player;
		this.data = new ArrayList<>();
		load();
	}
	
	public boolean isOnline() {
		return ONLINE_PLAYERS.contains(this);
	}
	
	public void setOnline(boolean check) {
		if(check) {
			ONLINE_PLAYERS.remove(this);
		}else {
			ONLINE_PLAYERS.add(this);
		}
	}
	
	@Override
	public List<CustomData<? extends DataHolder>> getData() {
		return data;
	}

	@Override
	public Player getEntity() {
		return player;
	}
	
	public static Set<ACMWPlayer> getOnlinePlayers(){
		return new HashSet<>(ONLINE_PLAYERS);
	}
	
	public static ACMWPlayer getPlayer(Player player) {
		Optional<ACMWPlayer> opPlayer = ONLINE_PLAYERS.stream().filter(f -> f.player.equals(player)).findAny();
		if(opPlayer.isPresent()) {
			return opPlayer.get();
		}else {
			return new ACMWPlayer(player);
		}
	}
	
}
