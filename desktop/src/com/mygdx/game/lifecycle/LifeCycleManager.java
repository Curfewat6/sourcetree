package com.mygdx.game.lifecycle;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.utils.ScreenUtils;
import com.mygdx.game.entity.Circle;
import com.mygdx.game.entity.EntityManager;
import com.mygdx.game.entity.TextureObject;
import com.mygdx.game.entity.Triangle;
import com.mygdx.game.screen.ScreenManager;
import com.mygdx.game.screen.TitleScreen;

public class LifeCycleManager {
	
	 public LifeCycleManager() {}

	    // Start the simulation and initialize the first scene
	    public void startSimulation(ScreenManager screenManager, EntityManager entityManager) {

	        //sceneManager.initializeScenes(entityManager);			
			
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
