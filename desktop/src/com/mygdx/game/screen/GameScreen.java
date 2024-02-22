package com.mygdx.game.screen;

import org.lwjgl.opengl.GL20;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.mygdx.game.ai.AIManagement;
import com.mygdx.game.ai.AIManager;
import com.mygdx.game.collision.CollisionManagement;
import com.mygdx.game.collision.CollisionManager;
import com.mygdx.game.entity.Circle;
import com.mygdx.game.entity.Entity;
import com.mygdx.game.entity.EntityManagement;
import com.mygdx.game.entity.EntityManager;
import com.mygdx.game.entity.Player;
import com.mygdx.game.entity.Triangle;
import com.mygdx.game.io.InputOutManagement;
import com.mygdx.game.io.InputOutputManager;
import com.mygdx.game.pcm.PlayerControlManagement;
import com.mygdx.game.pcm.PlayerControlManager;


public class GameScreen extends Screens implements PauseCallBack{

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
		ioManager.setPauseCallback(this);
		collisionManager = CollisionManager.getInstance();
		aiManager = AIManager.getInstance();
		
		batch = new SpriteBatch();
		font = new BitmapFont();
	}
	
	public void create()
	{
        setBackgroundImage(new Image(getTexture()));
        getBackgroundImage().setSize(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        
        getStage().addActor(getBackgroundImage());

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
	    setTexture(new Texture(Gdx.files.internal("gamebackground.jpg")));
	    create();
	}
	
	private void ScreenBounds() {
	    int screenWidth = Gdx.graphics.getWidth();
	    int screenHeight = Gdx.graphics.getHeight();

	    for (int i = 0; i < entityList.getEntities().size(); i++){
	   		Entity a = entityList.getEntities().get(i);
			   	if (!(a instanceof Player)) {
		             continue;
		        }	
		        Player player = (Player) a;
		        float newX = Math.max(0, Math.min(player.getPosX(), screenWidth - 64));
		 	    float newY = Math.max(0, Math.min(player.getPosY(), screenHeight - 64));

		 	    player.setPosX(newX);
		 	    player.setPosY(newY);
	    }
	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		//if (ioManager.handleInput()){
			//isPaused = !isPaused;
		//}
		ioManager.handleInput();
	    if (!isPaused) {
	        // Update and draw entities only when the game is not paused
	        //entityList.move();
	        entityList.update();
	        //playerControl.handlingPlayerInput();			
			aiManager.aiMovement();
			// Enforce bounds after updates
			ScreenBounds();


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
		getStage().draw();
	}


	@Override
	public void hide() {

		
	}

	@Override
	public void dispose() {

		
	}

	@Override
	public void togglePause() {
		// TODO Auto-generated method stub
		isPaused = !isPaused;
	}
	
}