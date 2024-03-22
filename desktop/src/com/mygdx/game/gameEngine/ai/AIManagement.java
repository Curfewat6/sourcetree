package com.mygdx.game.gameEngine.ai;


import com.mygdx.game.gameEngine.entity.Colliable;

public interface AIManagement {
	
	public void aiMovement();
	public void movementSet(Colliable droplet);
	public void resetMovement(Colliable b);

}
