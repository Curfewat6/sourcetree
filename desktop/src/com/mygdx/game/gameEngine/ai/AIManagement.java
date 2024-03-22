package com.mygdx.game.gameEngine.ai;

import com.mygdx.game.gameLogic.entity.Target;

public interface AIManagement {
	
	public void aiMovement();
	public void movementSet(Target droplet);
	public void resetMovement(Target b);

}
