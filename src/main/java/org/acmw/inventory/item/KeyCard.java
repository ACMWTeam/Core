package org.acmw.inventory.item;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.acmw.data.CustomData;
import org.acmw.data.DataHolder;
import org.acmw.permission.RankedPermission;
import org.acmw.util.StringGenerator;
import org.bukkit.inventory.ItemStack;

public class KeyCard implements DataHolder {
	
	RankedPermission permission;
	String id;
	ItemStack item;
	List<CustomData<? extends DataHolder>> data = new ArrayList<>();
	
	public KeyCard(String id, RankedPermission permission) {
		this.permission = permission;
		this.id = id;
	}
	
	public String getID() {
		return id;
	}
	
	public ItemStack getItem() {
		return item;
	}
	
	public RankedPermission getPermission() {
		return permission;
	}
	
	@Override
	public List<CustomData<? extends DataHolder>> getData() {
		return data;
	}
	
	public static String generateUniquieID() {
		while(true) {
			String generated = StringGenerator.generateString(8);
			File[] files = new File("").listFiles(); 
			if(files != null) {
				for(File file : files) {
					String filename = file.getPath().substring(file.getPath().length() - 5);
					if(filename.equals(generated)) {
						continue;
					}
				}
			}
			return generated;
		}
	}
}
