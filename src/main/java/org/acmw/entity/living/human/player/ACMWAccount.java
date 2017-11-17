package org.acmw.entity.living.human.player;

import java.io.File;
import java.io.IOException;
import java.util.Optional;
import java.util.Set;

import org.acmw.data.DataHolder;
import org.acmw.data.SerializableData;
import org.acmw.data.SerializableData.SerializableGenerator;
import org.bukkit.OfflinePlayer;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.YamlConfiguration;

public interface ACMWAccount extends DataHolder {
	
	public OfflinePlayer getEntity();
	
	public default void save() {
		YamlConfiguration config = YamlConfiguration.loadConfiguration(getFile());
		getData().stream().forEach(d -> {
			if(d instanceof SerializableData) {
				SerializableData<? extends DataHolder> data = (SerializableData<? extends DataHolder>)d;
				ConfigurationSection section = config.getConfigurationSection("Data." + data.getID());
				data.onSave(section);
			}
		});
		try {
			config.save(getFile());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public default void load() {
		YamlConfiguration config = YamlConfiguration.loadConfiguration(getFile());
		Set<String> ids = config.getConfigurationSection("Data").getKeys(false);
		for(String id : ids) {
			Optional<SerializableGenerator<? extends SerializableData<? extends DataHolder>>> opGen = SerializableData.SerializableGenerator.get(id);
			if(opGen.isPresent()) {
				SerializableGenerator<? extends SerializableData<? extends DataHolder>> generator = opGen.get();
				loadData(generator.getDataClass(), this, config.getConfigurationSection("Data." + id));
			}
		}
	}

	public default File getFile() {
		return new File("plugins/ACMW/Core/PlayerData/" + getEntity().getUniqueId().toString() + ".yml");
	};
}
