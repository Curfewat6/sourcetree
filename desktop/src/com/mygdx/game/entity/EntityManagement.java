package com.mygdx.game.entity;


public interface EntityManagement {
	
	public abstract void addEntity(Entity entity);
	public abstract void draw();
	public abstract void move();
	public abstract void dispose();
	public abstract void update();
	public abstract int checkCollide();
	public void setList(EntityManager el);
	
}
