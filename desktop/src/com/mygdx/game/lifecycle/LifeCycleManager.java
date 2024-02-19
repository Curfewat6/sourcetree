package com.mygdx.game.lifecycle;
import com.badlogic.gdx.Game;
import com.mygdx.game.entity.EntityManager;
import com.mygdx.game.screen.ScreenManager;
import com.mygdx.game.screen.TitleScreen;

public class LifeCycleManager {
	
	private Game game;
	
	 public LifeCycleManager() {}

	    // Start the simulation and initialize the first scene
	    public void startSimulation(ScreenManager screenManager, EntityManager entityManager) {
	    	game = screenManager.getScreen();
	    	
	    	game.setScreen(new TitleScreen(game, entityManager));		
			
	    }

	    // Ends the simulation and disposes everything used
	    public void endSimulation(ScreenManager screenManager,EntityManager entityManager ) {
	        entityManager.dispose();
	        screenManager.dispose();
	        //for (Scenes scenes: sceneManager.getSceneMap().values()) {
	        //    scenes.dispose();
	        //}
	    }
}
