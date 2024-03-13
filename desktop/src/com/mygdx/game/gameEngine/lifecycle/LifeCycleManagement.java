package com.mygdx.game.gameEngine.lifecycle;

import com.mygdx.game.gameEngine.entity.EntityManagement;
import com.mygdx.game.gameEngine.screen.ScreenManagement;
import com.mygdx.game.gameEngine.screen.ScreenManager;

public interface LifeCycleManagement {
	
	public void startSimulation(ScreenManagement screenList, EntityManagement entityList);
	public void endSimulation(ScreenManagement screenManager,EntityManagement entityManager);

}
