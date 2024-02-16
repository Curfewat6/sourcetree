package com.mygdx.game;

public interface EntityManger {
	
	public abstract void addEntity(Entity entity);
	public abstract void draw();
	public abstract void move();
	public abstract void dispose();
	public abstract void update();
	

}