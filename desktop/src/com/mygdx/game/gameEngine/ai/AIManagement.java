package com.mygdx.game.gameEngine.ai;

import com.mygdx.game.gameEngine.entity.NonPlayable;

public interface AIManagement {
	
	public void aiMovement();
	public void movementSet(NonPlayable droplet);
	public void resetMovement(NonPlayable b);

}
