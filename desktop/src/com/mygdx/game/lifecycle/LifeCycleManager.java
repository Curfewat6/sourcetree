package com.mygdx.game.lifecycle;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.MathUtils;
import com.mygdx.game.entity.Circle;
import com.mygdx.game.entity.EntityManagement;
import com.mygdx.game.entity.NonPlayable;
import com.mygdx.game.entity.Player;
import com.mygdx.game.entity.Triangle;
import com.mygdx.game.screen.ScreenManagement;
import com.mygdx.game.screen.TitleScreen;

public class LifeCycleManager implements LifeCycleManagement{
	
	private Game game;
	
	 public LifeCycleManager() {}

	    // Start the simulation and initialize the first scene
	    public void startSimulation(ScreenManagement screenManager, EntityManagement entityManager) {
	    	game = screenManager.getScreen();
			int x = 10;
			//ensure that the object is randomly place 
			for (int i = 0; i < x; i++) {
				float ranX = MathUtils.random(64,Gdx.graphics.getWidth()- 64);
				float ranY = MathUtils.random(Gdx.graphics.getHeight()/2,Gdx.graphics.getHeight());
				entityManager.addEntity(new NonPlayable("droplet.png",ranX,ranY,2));
			}
			//Creates all the Object needed
			entityManager.addEntity(new Player("bucket.png",280,20,300));
			//entityManager.addEntity(new Triangle(150,250,350,50,150,50,Color.RED,200));
			//entityManager.addEntity(new Circle(50,50,50,Color.GREEN,200));
	    	
	    	game.setScreen(new TitleScreen(game));		
			
	    }

	    // Ends the simulation and disposes everything used
	    public void endSimulation(ScreenManagement screenManager,EntityManagement entityManager ) {
	        entityManager.dispose();
	        screenManager.dispose();
	    }
}
