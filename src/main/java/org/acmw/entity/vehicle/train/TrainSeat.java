package org.acmw.entity.vehicle.train;

import org.acmw.entity.vehicle.ACMWVehicle;
import org.bukkit.entity.Minecart;

public class TrainSeat implements ACMWVehicle<Minecart> {

	Minecart minecart;
	int maxSpeed = 3;
	
	public TrainSeat(Minecart minecart) {
		this.minecart = minecart;
	}
	
	@Override
	public Minecart getEntity() {
		return minecart;
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
