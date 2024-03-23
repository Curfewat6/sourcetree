package com.mygdx.game.gameLogic.screen;

import org.lwjgl.opengl.GL20;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Dialog;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.mygdx.game.gameEngine.ai.AIManagement;
import com.mygdx.game.gameEngine.ai.AIManager;
import com.mygdx.game.gameEngine.collision.CollisionManagement;
import com.mygdx.game.gameEngine.collision.CollisionManager;
import com.mygdx.game.gameEngine.entity.Entity;
import com.mygdx.game.gameEngine.entity.EntityManagement;
import com.mygdx.game.gameEngine.entity.EntityManager;
import com.mygdx.game.gameLogic.entity.Player;
import com.mygdx.game.gameLogic.io.InputOutManagement;
import com.mygdx.game.gameLogic.io.InputOutputManager;
import com.mygdx.game.gameLogic.level.LevelManagement;
import com.mygdx.game.gameLogic.level.LevelManager;
import com.mygdx.game.gameLogic.level.LevelSpecifier;
import com.mygdx.game.gameEngine.pcm.PlayerControlManagement;
import com.mygdx.game.gameEngine.pcm.PlayerControlManager;
import com.mygdx.game.gameEngine.screen.*;



public class GameScreen extends Screens implements PauseCallBack{
	private Skin skin;
	private EntityManagement entityList;
	private CollisionManagement collisionManager;
	private PlayerControlManagement playerControl;
	private InputOutManagement ioManager;
	private AIManagement aiManager;
	private ScreenManagement screenList;
	private LevelManagement levelList;

	private Dialog pauseMenu;
	private boolean isPaused = false;
    private SpriteBatch batch;
    private BitmapFont font;
    private int totalCollisions = 0;
	private FitViewport fitViewport;
	private String keyPressed;
	private LevelSpecifier level;
	private String background;


	
	public GameScreen(Game game, String name, LevelSpecifier level) 
	{
		super(game, Width, Height);
		setName(name);
		entityList = EntityManager.getInstance();
		playerControl = PlayerControlManager.getInstance();
		ioManager = InputOutputManager.getInstance();
		ioManager.setPauseCallback(this);
		collisionManager = CollisionManager.getInstance();
		aiManager = AIManager.getInstance();
		levelList = LevelManager.getInstance();
		screenList = ScreenManager.getInstance();
		background = level.getBgPath();
		
		batch = new SpriteBatch();
		font = new BitmapFont();
	}
	
	public void create()
	{
		fitViewport = new FitViewport(Screens.Width, Screens.Height);
		Stage newStage = new Stage(fitViewport);
		setStage(newStage);
		Gdx.input.setInputProcessor(getStage());

		pauseMenu = new Dialog("", skin);
        pauseMenu.text("Game Paused");
		pauseMenu.button("Go Home", "QUIT").addListener(new ClickListener() 
		{
			@Override
			public void clicked(InputEvent event, float x, float y) {
				resume();
				screenList.getScreen("TITLE");
			}
		});
		pauseMenu.hide();
		getStage().addActor(pauseMenu);

        setBackgroundImage(new Image(getTexture()));
        getBackgroundImage().setSize(Screens.Width, Screens.Height);
        
        getStage().addActor(getBackgroundImage());
		
	}

	
	@Override
	public void pause() {
		pauseMenu.show(getStage());
	    isPaused = true;
		
	}

	@Override
	public void resume() {
	    isPaused = false;
		pauseMenu.hide();
		
	}
	
	

	@Override
	public void show() 
	{
		skin = new Skin(Gdx.files.internal("uiskin.json")); 
	    setTexture(new Texture(background));
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
		fitViewport.apply();
		//if (ioManager.handleInput()){
			//isPaused = !isPaused;
		//}
		keyPressed = ioManager.handleInput();
	    if (!isPaused) 
	    {
	    	if (keyPressed.startsWith("left")) {
				playerControl.setDirection("left");
				playerControl.movePlayerBasedOnDirection();
				System.out.println("Moving left");
			} else if (keyPressed.startsWith("right")) {
				playerControl.setDirection("right");
				playerControl.movePlayerBasedOnDirection();
				System.out.println("Moving right");
			} else if (keyPressed.startsWith("SHOOT:")) {
				String typedText = keyPressed.substring(6); // Basically just get the text after the "SHOOT:" part
				System.out.println("shooting: ");
				System.out.println(typedText);
			}
	        // Update and draw entities only when the game is not paused
	        //entityList.move();
	        entityList.update();
	        //playerControl.handlingPlayerInput();			
			//aiManager.aiMovement();
			// Enforce bounds after updates
			ScreenBounds();


	        //int collisionsThisFrame = collisionManager.checkCollision();
	        //totalCollisions += collisionsThisFrame;
	
			// [ATTENTION!] Hi i commented this out to test my IO. You can uncomment it if need be. ~ Lucas <3
	        //System.out.println("Total collisions so far: " + totalCollisions);
	        
		    // Check if there have been any collisions
		    if (totalCollisions >= 50 ) 
		    {
		    	 // Switch to end game scene
		    	 // getGame().setScreen(new EndScreen(getGame()));
			    screenList.getScreen("END");


		    }
		    	 
	    }
	    
		getStage().act(Math.min(Gdx.graphics.getDeltaTime(), 1 / 30f));
		getStage().draw();
		entityList.draw();


        
		if (isPaused) {
		    // Example: Display a simple pause overlay
		    // batch.begin();
			// font.draw(batch, "Paused - Press Esc to Resume", 100, 150);
		    // batch.end();
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

	@Override
	public void togglePause() {
		// TODO Auto-generated method stub
		isPaused = !isPaused;
		if(isPaused){
			pause();
		} else{
			resume();
		}
	}
	
}