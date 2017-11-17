package org.acmw.data;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.bukkit.configuration.ConfigurationSection;

public interface SerializableData<T extends DataHolder> extends CustomData<T> {
	
	public void onSave(ConfigurationSection config);
	public void onLoad(ConfigurationSection config);

	public static class SerializableGenerator <T extends SerializableData<? extends DataHolder>>{
		
		Class<? extends SerializableData<? extends DataHolder>> data;
		String id;
		
		public static final List<SerializableGenerator<? extends SerializableData<? extends DataHolder>>> GENERATOR_DATA = new ArrayList<>();
		
		public SerializableGenerator(Class<? extends SerializableData<? extends DataHolder>> klass, String id) {
			this.data = klass;
			this.id = id;
		}
		
		public Class<? extends SerializableData<? extends DataHolder>> getDataClass(){
			return data;
		}
		
		public String getID() {
			return id;
		}
		
		public static void register(SerializableGenerator<? extends SerializableData<? extends DataHolder>> gen) {
			GENERATOR_DATA.add(gen);
		}
		
		public static Optional<SerializableGenerator<? extends SerializableData<? extends DataHolder>>> get(String id) {
			return GENERATOR_DATA.stream().filter(f -> f.id.equals(id)).findAny();
		}
		
		@SuppressWarnings("unchecked")
		public static <T extends SerializableData<? extends DataHolder>> Optional<SerializableGenerator<T>> get(Class<T> type){
			Optional<SerializableGenerator<? extends SerializableData<? extends DataHolder>>> opGen = GENERATOR_DATA.stream().filter(f -> f.data.isAssignableFrom(type)).findAny();
			if(opGen.isPresent()) {
				return Optional.of((SerializableGenerator<T>)opGen.get());
			}
			return Optional.empty();
		}
		
	}
	
}
