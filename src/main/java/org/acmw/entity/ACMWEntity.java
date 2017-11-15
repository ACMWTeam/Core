package org.acmw.entity;

import org.bukkit.entity.Entity;

public interface ACMWEntity <T extends Entity> {
	
	public T getEntity();

}
