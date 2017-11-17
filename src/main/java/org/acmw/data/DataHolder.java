package org.acmw.data;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.acmw.exception.InvalidCreateParameters;
import org.bukkit.configuration.ConfigurationSection;

public interface DataHolder {

	//gets all the data being held
	public List<CustomData<? extends DataHolder>> getData();
	
	//gets all the data of a type
	@SuppressWarnings("unchecked")
	public default <T extends CustomData<? extends DataHolder>> Set<T> getData(Class<T> type){
		return (Set<T>)getData().stream().filter(d -> type.isInstance(d)).collect(Collectors.toSet());
	}
	
	//gets the first data of a type
	@SuppressWarnings("unchecked")
	public default <T extends CustomData<? extends DataHolder>> Optional<T> getFirstData(Class<T> type){
		return (Optional<T>)getData().stream().filter(d -> type.isInstance(d)).findFirst();
	}
	
	@SuppressWarnings("unchecked")
	public default <H extends DataHolder, T extends CustomData<H>> CustomData<H> createData(Class<T> type, H holder, Object... parameters) throws InvalidCreateParameters {
		try {
			T crea = type.newInstance();
			crea.onCreation(holder, parameters);
			addData(crea);
			return crea;
		} catch (InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@SuppressWarnings("unchecked")
	public default <H extends DataHolder, T extends SerializableData<? extends DataHolder>> SerializableData<H> loadData(Class<T> type, H holder, ConfigurationSection section) {
		try {
			T data = type.newInstance();
			SerializableData<H> serial = (SerializableData<H>) data.clone(holder);
			serial.onLoad(section);
			addData(serial);
			return serial;
		} catch (InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	//adds custom data
	//@DataHolder is for chaining
	@SuppressWarnings("unchecked")
	public default DataHolder addData(CustomData<? extends DataHolder>... data) {
		for(CustomData<? extends DataHolder> data2 : data) {
			getData().add(data2);
		}
		return this;
	}
	
	//removes custom data
	//@DataHolder is for chaining
	@SuppressWarnings("unchecked")
	public default DataHolder removeData(CustomData<? extends DataHolder>... data) {
		for(CustomData<? extends DataHolder> data2 : data) {
			getData().remove(data2);
		}
		return this;
	}
	
	//removes all custom data of selected types
	//@DataHolder is for chaining
	@SuppressWarnings("unchecked")
	public default DataHolder removeData(Class<? extends CustomData<? extends DataHolder>>... data) {
		for(Class<? extends CustomData<? extends DataHolder>> klass : data) {
			Set<CustomData<? extends DataHolder>> set = getData().stream().filter(d -> klass.isInstance(d)).collect(Collectors.toSet());
			getData().removeAll(set);
		}
		return this;
	}
}
