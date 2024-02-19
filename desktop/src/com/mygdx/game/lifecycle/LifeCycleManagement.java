package com.mygdx.game.lifecycle;

import com.mygdx.game.entity.EntityManagement;
import com.mygdx.game.screen.ScreenManagement;

public interface LifeCycleManagement {
	
	public void startSimulation(ScreenManagement screenList, EntityManagement entityList);
	public void endSimulation(ScreenManagement screenManager,EntityManagement entityManager);

}
