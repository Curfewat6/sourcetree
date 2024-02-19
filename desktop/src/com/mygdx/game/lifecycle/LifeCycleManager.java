package com.mygdx.game.lifecycle;
import com.badlogic.gdx.Game;
import com.mygdx.game.entity.EntityManagement;
import com.mygdx.game.entity.EntityManager;
import com.mygdx.game.screen.ScreenManagement;
import com.mygdx.game.screen.ScreenManager;
import com.mygdx.game.screen.TitleScreen;

public class LifeCycleManager {
	
	private Game game;
	
	 public LifeCycleManager() {}

	    // Start the simulation and initialize the first scene
	    public void startSimulation(ScreenManagement screenList, EntityManagement entityList) {
	    	game = screenList.getScreen();
	    	
	    	game.setScreen(new TitleScreen(game, entityList));		
			
	    }

	    // Ends the simulation and disposes everything used
	    public void endSimulation(ScreenManagement screenList,EntityManagement entityList ) {
	        entityList.dispose();
	        screenList.dispose();
	        //for (Scenes scenes: sceneManager.getSceneMap().values()) {
	        //    scenes.dispose();
	        //}
	    }
}
