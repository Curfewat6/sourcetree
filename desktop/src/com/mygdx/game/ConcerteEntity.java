package com.mygdx.game;

public interface ConcerteEntity {
	
	//Function that any Manager can call 
	public abstract void create();
	public abstract void render();
	public abstract void update();
	public abstract void dispose();
	public abstract void move();

}
