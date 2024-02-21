package com.mygdx.game.screen;

import org.lwjgl.opengl.GL20;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.mygdx.game.ai.AIManagement;
import com.mygdx.game.ai.AIManager;
import com.mygdx.game.collision.CollisionManagement;
import com.mygdx.game.collision.CollisionManager;
import com.mygdx.game.entity.Circle;
import com.mygdx.game.entity.EntityManagement;
import com.mygdx.game.entity.EntityManager;
import com.mygdx.game.entity.Triangle;
import com.mygdx.game.io.InputOutManagement;
import com.mygdx.game.io.InputOutputManager;
import com.mygdx.game.pcm.PlayerControlManagement;
import com.mygdx.game.pcm.PlayerControlManager;


public class GameScreen extends Screens{

	private EntityManagement entityList;
	private CollisionManagement collisionManager;
	private PlayerControlManagement playerControl;
	private InputOutManagement ioManager;
	private AIManagement aiManager;
	
	private boolean isPaused = false;
    private SpriteBatch batch;
    private BitmapFont font;
    private int totalCollisions = 0;

	
	public GameScreen(Game game) 
	{
		super(game);
		Gdx.input.setInputProcessor(getStage());
		entityList = EntityManager.getInstance();
		playerControl = PlayerControlManager.getInstance();
		ioManager = InputOutputManager.getInstance();
		collisionManager = CollisionManager.getInstance();
		aiManager = AIManager.getInstance();
		
		batch = new SpriteBatch();
		font = new BitmapFont();
	}
	
	@Override
	public void pause() {
	    isPaused = true;
	}

	@Override
	public void resume() {
	    isPaused = false;
	}
	
	

	@Override
	public void show() 
	{
		
	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		if (ioManager.handleInput()){
			isPaused = !isPaused;
		}
	    if (!isPaused) {
	        // Update and draw entities only when the game is not paused
	        //entityList.move();
	        entityList.update();
	        //playerControl.handlingPlayerInput();
			ioManager.handleInput();
			aiManager.aiMovement();

	        int collisionsThisFrame = collisionManager.checkCollision();
	        totalCollisions += collisionsThisFrame;
	        System.out.println("Total collisions so far: " + totalCollisions);
	        
		     // Check if there have been any collisions
		     if (totalCollisions >= 50 ) {
		    	 // Switch to end game scene
		    	 getGame().setScreen(new EndScreen(getGame()));
		     } else {
		         System.out.println(totalCollisions);
		     }
	    }
		
		getStage().act(Math.min(Gdx.graphics.getDeltaTime(), 1 / 30f));
		getStage().draw();
		entityList.draw();

        
		if (isPaused) {
		    // Example: Display a simple pause overlay
		    batch.begin();
			font.draw(batch, "Paused - Press P to Resume", 100, 150);
		    batch.end();
		}

	}

	@Override
	public void resize(int width, int height) {
		getStage().getViewport().update(width, height, true);
	}


	@Override
	public void hide() {

		
	}

	@Override
	public void dispose() {

		
	}
	
}