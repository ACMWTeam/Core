package org.acmw.data.customdata.entity.player;

import org.acmw.CorePlugin;
import org.acmw.data.CustomData;
import org.acmw.data.DataHolder;
import org.acmw.entity.living.human.player.ACMWPlayer;
import org.acmw.exception.InvalidCreateParameters;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.util.Vector;

public class BoxedArea implements CustomData<ACMWPlayer>{
	
	World world;
	Vector pos1;
	Vector pos2;
	
	public World getWorld() {
		return world;
	}
	
	public Vector getPos1() {
		return pos1;
	}
	
	public Vector getPos2() {
		return pos2;
	}
	
	public BoxedArea setPos1(Vector pos) {
		pos1 = pos;
		return this;
	}
	
	public BoxedArea setPos2(Vector pos) {
		pos2 = pos;
		return this;
	}
	
	public BoxedArea setWorld(World world) {
		this.world = world;
		return this;
	}
	
	@Override
	public String getName() {
		return "BoxedArea";
	}

	@Override
	public JavaPlugin getPlugin() {
		return CorePlugin.getPlugin();
	}
		
	@SuppressWarnings("unchecked")
	@Override
	public <H extends DataHolder> CustomData<H> clone(CustomData<H> holder) {
		BoxedArea boxedArea = (BoxedArea)holder;
		boxedArea.pos1 = this.pos1;
		boxedArea.pos2 = this.pos2;
		boxedArea.world = this.world;
		return (CustomData<H>)boxedArea;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public <H extends DataHolder> CustomData<H> clone(H holder) {
		if(!(holder instanceof ACMWPlayer)) {
			return null;
		}
		BoxedArea area = new BoxedArea();
		area.pos1 = this.pos1;
		area.pos2 = this.pos2;
		area.world = this.world;
		return (CustomData<H>)area;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public <H extends DataHolder> CustomData<H> clone(Class<H> holder) {
		if(!(holder.isAssignableFrom(ACMWPlayer.class))) {
			return null;
		}
		BoxedArea area = new BoxedArea();
		area.pos1 = this.pos1;
		area.pos2 = this.pos2;
		area.world = this.world;
		return (CustomData<H>)area;
	}

	@Override
	public void onCreation(ACMWPlayer holder, Object... parameters) throws InvalidCreateParameters {
		if(parameters.length == 0) {
			return;
		}
		for(int A = 0; A < parameters.length; A++) {
			Object obj = parameters[A];
			if(obj instanceof World) {
				world = (World)obj;
			}
			if(obj instanceof Vector) {
				if((pos1 == null) && (pos2 == null)) {
					pos1 = (Vector)obj;
				}else if((pos1 != null) && (pos2 == null)) {
					pos2 = (Vector)obj;
				}else {
					new Exception("Too many Vector's on creation").printStackTrace();
				}
			}
			if(obj instanceof Location) {
				if((pos1 == null) && (pos2 == null)) {
					Location loc = (Location)obj;
					pos1 = new Vector(loc.getBlockX(), loc.getBlockY(), loc.getBlockZ());
					world = loc.getWorld();
				}else if((pos1 != null) && (pos2 == null)) {
					Location loc = (Location)obj;
					pos2 = new Vector(loc.getBlockX(), loc.getBlockY(), loc.getBlockZ());
					world = loc.getWorld();
				}else {
					new Exception("Too many Location's on creation").printStackTrace();
				}
			}
		}
	}

}
