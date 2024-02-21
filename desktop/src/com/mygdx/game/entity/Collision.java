package com.mygdx.game.entity;

public interface Collision {
	public boolean objCollision();
	public boolean npcCollision();
	public boolean checkCollision(TextureObject tex);
}
