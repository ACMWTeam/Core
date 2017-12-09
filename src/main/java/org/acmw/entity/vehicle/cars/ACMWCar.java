package org.acmw.entity.vehicle.cars;

import java.util.Optional;

import org.acmw.entity.living.human.player.ACMWUser;
import org.acmw.entity.vehicle.ACMWDrivable;
import org.bukkit.entity.Vehicle;

public interface ACMWCar <T extends Vehicle> extends ACMWDrivable<T> {
	
	public Optional<ACMWUser> getOwner();
	public void setOwner(ACMWUser user);

}
