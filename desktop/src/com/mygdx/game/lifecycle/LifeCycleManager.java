package com.mygdx.game.lifecycle;
import com.badlogic.gdx.Game;
import com.mygdx.game.entity.EntityManagement;
import com.mygdx.game.screen.ScreenManagement;
import com.mygdx.game.screen.TitleScreen;

public class LifeCycleManager implements LifeCycleManagement{
	
	private Game game;
	
	 public LifeCycleManager() {}

	    // Start the simulation and initialize the first scene
	    public void startSimulation(ScreenManagement screenManager, EntityManagement entityManager) {
	    	game = screenManager.getScreen();
	    	
	    	game.setScreen(new TitleScreen(game, entityManager));		
			
	    }

	    // Ends the simulation and disposes everything used
	    public void endSimulation(ScreenManagement screenManager,EntityManagement entityManager ) {
	        entityManager.dispose();
	        screenManager.dispose();
	        //for (Scenes scenes: sceneManager.getSceneMap().values()) {
	        //    scenes.dispose();
	        //}
	    }
}
