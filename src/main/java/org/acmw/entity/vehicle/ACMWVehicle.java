package org.acmw.entity.vehicle;

import org.acmw.CorePlugin;
import org.acmw.entity.ACMWEntity;
import org.bukkit.entity.Vehicle;
import org.bukkit.util.Vector;

public interface ACMWVehicle <T extends Vehicle> extends ACMWEntity<T> {

	@Override
	public T getEntity();
	
	public int getMaxSpeed();
	public void setMaxSpeed(int max);
	
	public default double getSpeed() {
		Vector vector = getEntity().getVelocity();
		return CorePlugin.getPlugin().getSpeed(vector);
	}
	
}
