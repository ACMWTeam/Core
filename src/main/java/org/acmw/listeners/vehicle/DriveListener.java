package org.acmw.listeners.vehicle;

import java.util.Optional;

import org.acmw.CorePlugin;
import org.acmw.entity.vehicle.ACMWDrivable;
import org.acmw.entity.vehicle.ACMWVehicle;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Vehicle;
import org.bukkit.event.Listener;
import org.bukkit.event.vehicle.VehicleMoveEvent;
import org.bukkit.util.Vector;

public class DriveListener implements Listener {
	
	public void onVehicleMove(VehicleMoveEvent event) {
		Optional<ACMWVehicle<Vehicle>> opVehicle = CorePlugin.getPlugin().getVehicle(event.getVehicle());
		if(!opVehicle.isPresent()) {
			return;
		}
		ACMWVehicle<Vehicle> vehicle = opVehicle.get();
		if(!(vehicle instanceof ACMWDrivable)) {
			return;
		}
		Block block = vehicle.getEntity().getLocation().getBlock().getRelative((int)vehicle.getEntity().getVelocity().getX(), (int)vehicle.getEntity().getVelocity().getY(), (int)vehicle.getEntity().getVelocity().getZ());
		if(vehicle.getSpeed() > vehicle.getMaxSpeed()) {
			Vector vector = vehicle.getEntity().getVelocity();
			if(vector.getX() > 0) {
				vector.setX(vector.getX() + 0.1);
			}
			if(vector.getZ() > 0) {
				vector.setZ(vector.getZ() + 0.1);
			}
			vehicle.getEntity().setVelocity(vector);
		}else if (vehicle.getSpeed() < vehicle.getMaxSpeed()) {
			Vector vector = vehicle.getEntity().getVelocity();
			if(vector.getX() > 0) {
				vector.setX(vector.getX() + 0.1);
			}
			if(vector.getZ() > 0) {
				vector.setZ(vector.getZ() + 0.1);
			}
			vehicle.getEntity().setVelocity(vector);
		}
		if(!block.getType().equals(Material.AIR)) {
			vehicle.getEntity().setVelocity(vehicle.getEntity().getVelocity().add(new Vector(0, 2, 0)));
		}
	}

}
