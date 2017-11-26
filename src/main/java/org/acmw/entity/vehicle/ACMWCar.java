package org.acmw.entity.vehicle;

import java.util.Optional;

import org.acmw.entity.living.human.player.ACMWUser;
import org.bukkit.entity.Vehicle;

public interface ACMWCar <T extends Vehicle> extends ACMWVehicle<T> {
	
	public Optional<ACMWUser> getOwner();
	public void setOwner(ACMWUser user);

}
