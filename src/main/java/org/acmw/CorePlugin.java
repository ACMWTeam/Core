package org.acmw;

import org.bukkit.plugin.java.JavaPlugin;

public class CorePlugin extends JavaPlugin {
	
	static CorePlugin plugin;
	
	public void onEnable() {
		plugin = this;
 		 
	}

	public static CorePlugin getPlugin() {
		return plugin;
	}
	
}
