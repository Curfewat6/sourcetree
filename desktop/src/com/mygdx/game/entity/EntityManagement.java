package com.mygdx.game.entity;

import java.util.List;

public interface EntityManagement {
	
	public abstract void addEntity(Entity entity);
	public abstract void draw();
	public abstract void dispose();
	public abstract void update();
	public String getTexName();
	public void setList(EntityManagement em);
	public List<Entity> getEntities();
	
}
