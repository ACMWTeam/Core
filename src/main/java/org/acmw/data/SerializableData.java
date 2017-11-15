package org.acmw.data;

public interface SerializableData<T extends DataHolder> extends CustomData<T> {
	
	public void onSave();
	public void onLoad();

}
