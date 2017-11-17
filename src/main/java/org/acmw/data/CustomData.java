package org.acmw.data;

import org.acmw.exception.InvalidCreateParameters;
import org.bukkit.plugin.java.JavaPlugin;

public interface CustomData <T extends DataHolder>{

	//gets the name of the custom data. This should attempt to be unique to the class.
	public String getName();
	//gets the plugin the custom data comes from.
	public JavaPlugin getPlugin();
	//Due to the fact constructor is not allowed parameters. This will be run on initiation with the DataHolder and other parameters.
	public void onCreation(T holder, Object... parameters) throws InvalidCreateParameters;
	
	public <H extends DataHolder> CustomData<H> clone(Class<H> holderClass);
	
	public <H extends DataHolder> CustomData<H> clone(H holder);
	
	public <H extends DataHolder> CustomData<H> clone(CustomData<H> holder);
	
	//gets the full ID of the custom data.
	public default String getID() {
		return getPlugin().getName() + "-" + getName();
	}	
}
