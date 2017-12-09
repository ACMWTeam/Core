package org.acmw.listeners.vehicle;

import java.util.Optional;

import org.acmw.CorePlugin;
import org.acmw.entity.vehicle.ACMWVehicle;
import org.acmw.entity.vehicle.train.ACMWTrain;
import org.bukkit.block.Block;
import org.bukkit.entity.Vehicle;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.vehicle.VehicleMoveEvent;

public class TrainListener implements Listener {

	@EventHandler
	public void onVehicleMoveEvent(VehicleMoveEvent event) {
		Vehicle bVehicle = event.getVehicle();
		Optional<ACMWVehicle<Vehicle>> opVehicle = CorePlugin.getPlugin().getVehicle(bVehicle);
		if(!opVehicle.isPresent()) {
			return;
		}
		ACMWVehicle<Vehicle> vehicle = opVehicle.get();
		if(!(vehicle instanceof TrainListener)) {
			return;
		}
		ACMWTrain<Vehicle> train = (ACMWTrain<Vehicle>)vehicle;
		Block track = train.getTrack();
		//check if powered rail and not powered. If so stop the cart, if not keep the cart moving (requires new material api)
	}
	
}
