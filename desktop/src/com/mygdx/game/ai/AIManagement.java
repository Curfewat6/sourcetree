package com.mygdx.game.ai;

import com.mygdx.game.entity.NonPlayable;

public interface AIManagement {
	
	public void aiMovement();
	public void movementSet(NonPlayable droplet);
	public void resetMovement(NonPlayable b);

}
