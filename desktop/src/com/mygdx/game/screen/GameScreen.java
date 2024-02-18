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
import com.mygdx.game.entity.Circle;
import com.mygdx.game.entity.EntityManager;
import com.mygdx.game.entity.TextureObject;
import com.mygdx.game.entity.Triangle;


public class GameScreen extends Screens{

	private EntityManager entityList;
	private boolean isPaused = false;
    private SpriteBatch batch;
    private BitmapFont font;
    private int totalCollisions = 0;

	
	public GameScreen(Game game) 
	{
		super(game, new Stage(new ScreenViewport()));
		Gdx.input.setInputProcessor(stage);
		entityList = new EntityManager();
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
		int x = 10;
		//ensure that the object is randomly place 
		for (int i = 0; i < x; i++) {
			float ranX = MathUtils.random(64,Gdx.graphics.getWidth()- 64);
			float ranY = MathUtils.random(Gdx.graphics.getHeight()/2,Gdx.graphics.getHeight());
			entityList.addEntity(new TextureObject("droplet.png",ranX,ranY,2));
		}
		//Creates all the Object needed
		entityList.addEntity(new TextureObject("bucket.png",280,20,300));
		entityList.addEntity(new Triangle(150,250,350,50,150,50,Color.RED,200));
		entityList.addEntity(new Circle(50,50,50,Color.GRAY,200));
	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
	    if (!isPaused) {
	        // Update and draw entities only when the game is not paused
	        entityList.move();
	        entityList.update();

	        int collisionsThisFrame = entityList.checkCollide();
	        totalCollisions += collisionsThisFrame;
	        System.out.println("Total collisions so far: " + totalCollisions);
	        
		     // Check if there have been any collisions
		     if (totalCollisions >= 200 ) {
		    	 // Switch to end game scene
		    	 game.setScreen(new EndScreen(game));
		     } else {
		         System.out.println(totalCollisions);
		     }
	    }
		
		stage.act(Math.min(Gdx.graphics.getDeltaTime(), 1 / 30f));
		stage.draw();
		entityList.draw();

        
		if (isPaused) {
		    // Example: Display a simple pause overlay
		    batch.begin();;
			font.draw(batch, "Paused - Press P to Resume", 100, 150);
		    batch.end();
		}
        
        if (Gdx.input.isKeyJustPressed(Input.Keys.P)) {
            isPaused = !isPaused; // Toggle the pause state
        }

	}

	@Override
	public void resize(int width, int height) {
		stage.getViewport().update(width, height, true);
	}


	@Override
	public void hide() {

		
	}

	@Override
	public void dispose() {
        stage.dispose();
	}
	
}