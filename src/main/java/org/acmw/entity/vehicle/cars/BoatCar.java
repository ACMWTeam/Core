package org.acmw.entity.vehicle.cars;

import java.util.Optional;

import org.acmw.entity.living.human.player.ACMWUser;
import org.bukkit.entity.Boat;

public class BoatCar implements ACMWCar <Boat>{

	Boat boat;
	int maxSpeed;
	ACMWUser g_owner;
	
	public BoatCar(Boat boat) {
		this.boat = boat;
	}
	
	@Override
	public Boat getEntity() {
		return boat;
	}

	@Override
	public Optional<ACMWUser> getOwner() {
		return Optional.ofNullable(g_owner);
	}

	@Override
	public void setOwner(ACMWUser user) {
		g_owner = user;
	}
	
	@Override
	public int getMaxSpeed() {
		return maxSpeed;
	}
	
	@Override
	public void setMaxSpeed(int max) {
		maxSpeed = max;	
	}

}
