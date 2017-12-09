package org.acmw;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.acmw.entity.vehicle.ACMWVehicle;
import org.acmw.inventory.custom.CustomInventory;
import org.bukkit.entity.Vehicle;
import org.bukkit.inventory.Inventory;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.util.Vector;

public class CorePlugin extends JavaPlugin {
	
	static CorePlugin plugin;
	List<ACMWVehicle<? extends Vehicle>> vehicles = new ArrayList<>();
	List<CustomInventory> inventories = new ArrayList<>();
	
	public void onEnable() {
		plugin = this;
 		 
	}

	public static CorePlugin getPlugin() {
		return plugin;
	}
	
	public void register(ACMWVehicle<? extends Vehicle> vehicle) {
		vehicles.add(vehicle);
	}
	
	public void register(CustomInventory inventory) {
		inventories.add(inventory);
	}
	
	public double getSpeed(Vector vector) {
		if((vector.getX() > vector.getY()) && (vector.getX() > vector.getZ())) {
			return vector.getX();
		}else if ((vector.getY() > vector.getX()) && (vector.getY() > vector.getZ())) {
			return vector.getY();
		}else {
			return vector.getZ();
		}
	}
	
	public List<ACMWVehicle<? extends Vehicle>> getVehicles(){
		return vehicles;
	}
	
	@SuppressWarnings("unchecked")
	public <T extends Vehicle> Optional<ACMWVehicle<T>> getVehicle(T op){
		Optional<ACMWVehicle<? extends Vehicle>> opVehicle = getVehicles().stream().filter(e -> e.getEntity().equals(op)).findAny();
		if(opVehicle.isPresent()) {
			return Optional.of((ACMWVehicle<T>)opVehicle.get());
		}
		return Optional.empty();
	}
	
	public List<CustomInventory> getInventories(){
		return inventories;
	}
	
	public Optional<CustomInventory> getInventory(Inventory inventory){
		return getInventories().stream().filter(i -> i.getRAWInventory().equals(inventory)).findAny();
	}
	
}
