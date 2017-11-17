package org.acmw.eco;

import java.util.Optional;

import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;

public class EcoCause {
	
	Plugin plugin;
	double amount;
	String reason;
	String on;
	
	public EcoCause(Plugin plugin, double amount, String reason) {
		this.plugin = plugin;
		this.amount = amount;
		this.reason = reason;
	}
	
	public Plugin getPlugin() {
		return plugin;
	}
	
	public double getAmount() {
		return amount;
	}
	
	public String getReason() {
		return reason;
	}
	
	public String getMessage() {
		if(amount > 0) {
			return "You spent " + amount + " on " + reason;
		}else {
			return "You got " + amount + " from " + reason;
		}
	}
	
	@Override
	public String toString() {
		return plugin.getName() + "," + amount + "," + reason;
	}
	
	public static Optional<EcoCause> fromString(String obj){
		String[] split = obj.split(",");
		if(split.length != 2) {
			return Optional.empty();
		}
		String pluginS = split[0];
		double amount = Double.parseDouble(split[1]);
		String reason = split[2];
		for (Plugin plugin : Bukkit.getPluginManager().getPlugins()){
			if(plugin.getName().equals(pluginS)) {
				return Optional.of(new EcoCause(plugin, amount, reason));
			}
		}
		return Optional.empty();
	}

}
