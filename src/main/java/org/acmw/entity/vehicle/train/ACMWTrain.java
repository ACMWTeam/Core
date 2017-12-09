package org.acmw.entity.vehicle.train;

import org.acmw.entity.vehicle.ACMWVehicle;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Vehicle;

public interface ACMWTrain <T extends Vehicle> extends ACMWVehicle<T> {

	public default Block getTrack() {
		return getEntity().getLocation().getBlock().getRelative(BlockFace.DOWN);
	}
	
}
