package com.mygdx.game.entity;

import java.util.List;

public interface EntityManagement {
	
	public abstract void addEntity(Entity entity);
	public abstract void draw();
	public abstract void move();
	public abstract void dispose();
	public abstract void update();
    public abstract List<Entity> getEntities();
	public void setList(EntityManagement el);
	
}
